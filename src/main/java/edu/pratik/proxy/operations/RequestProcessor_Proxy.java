package edu.pratik.proxy.operations;

import edu.pratik.proxy.exception.AccessDenied_Exception;
import edu.pratik.proxy.exception.TaskAlreadyAdded_Exception;
import edu.pratik.proxy.exception.TaskNotFound_Exception;
import edu.pratik.proxy.users.UserType;

public class RequestProcessor_Proxy {
    RequestProcessor requestProcessor;
    UserType userType;
    public RequestProcessor_Proxy(UserType userType) {
        this.requestProcessor = new RequestProcessor();
        this.userType=userType;
    }

    public void InsertRecord(String task) throws AccessDenied_Exception, TaskAlreadyAdded_Exception {
        insertRecordPrehook(task);
        requestProcessor.InsertRecord(task);
        insertRecordPosthook(task);
    }

    private void insertRecordPosthook(String task) {
        System.out.println("Cleanup activity after INSERT: "+task);
    }

    private void insertRecordPrehook(String task) throws AccessDenied_Exception {
        System.out.println("Activity/access check before INSERT: "+task);
        if (!(userType== UserType.ADMIN || userType==UserType.MAKER))
            throw new AccessDenied_Exception(userType + " cannot insert new record.", new Throwable("Invalid user type for insertion."));
    }

    public void deleteRecord(String task) throws AccessDenied_Exception, TaskNotFound_Exception {
        deleteRecordPrehook(task);
        requestProcessor.deleteRecord(task);
        deleteRecordPosthook(task);
    }

    private void deleteRecordPosthook(String task) {
        System.out.println("Cleanup activity post DELETE: "+task);
    }

    private void deleteRecordPrehook(String task) throws AccessDenied_Exception {
        System.out.println("Activity/access check before DELETE: "+task);
        if (!(userType== UserType.ADMIN))
            throw new AccessDenied_Exception(userType + " cannot delete record.", new Throwable("Invalid user type for deletion."));
    }

    public void fetchRecords() throws TaskNotFound_Exception {
        fetchRecordPrehook();
        requestProcessor.fetchRecords();
        fetchRecordPosthook();
    }

    private void fetchRecordPosthook() {
        System.out.println("Cleanup activity after FETCHING records.");
    }

    private void fetchRecordPrehook() {
        System.out.println("Activity/access check before FETCHING records.");
    }

    public void confirmRecord(String task) throws AccessDenied_Exception, TaskNotFound_Exception {
        confirmRecordPrehook(task);
        requestProcessor.confirmRecord(task);
        confirmRecordPosthook(task);
    }

    private void confirmRecordPosthook(String task) {
        System.out.println("Cleanup activity post APPROVAL: "+task);
    }

    private void confirmRecordPrehook(String task) throws AccessDenied_Exception {
        System.out.println("Activity/access check before APPROVAL: "+task);
        if (!(userType== UserType.ADMIN ||userType==UserType.CHECKER))
            throw new AccessDenied_Exception(userType + " cannot approve record.",
                    new Throwable("Invalid user type for approval."));

    }

    public void rejectRecord(String task) throws AccessDenied_Exception, TaskNotFound_Exception {
        rejectRecordPrehook(task);
        requestProcessor.rejectRecord(task);
        rejectRecordPosthook(task);
    }

    private void rejectRecordPosthook(String task) {
        System.out.println("Cleanup activity post REJECT: "+task);
    }

    private void rejectRecordPrehook(String task) throws AccessDenied_Exception {
        System.out.println("Activity/access check before REJECT: "+task);
        if (!(userType== UserType.ADMIN ||userType==UserType.CHECKER))
            throw new AccessDenied_Exception(userType + " cannot reject record.",
                    new Throwable("Invalid user type for rejection."));
    }
}
