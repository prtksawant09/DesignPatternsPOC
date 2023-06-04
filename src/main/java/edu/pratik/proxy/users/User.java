package edu.pratik.proxy.users;

import edu.pratik.proxy.exception.AccessDenied_Exception;
import edu.pratik.proxy.exception.TaskAlreadyAdded_Exception;
import edu.pratik.proxy.exception.TaskNotFound_Exception;
import edu.pratik.proxy.operations.RequestProcessor_Proxy;

public class User {
    private final UserType userType;
    RequestProcessor_Proxy requestProcessorProxy;

    public User(UserType userType) {
        this.userType = userType;
        this.requestProcessorProxy = new RequestProcessor_Proxy(userType);
    }

    public void addRecord(String record) {
        try {
            requestProcessorProxy.InsertRecord(record);
        } catch (AccessDenied_Exception e) {
            System.out.println(e.getMessage());
        } catch (TaskAlreadyAdded_Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeRecord(String record) {
        try {
            requestProcessorProxy.deleteRecord(record);
        } catch (AccessDenied_Exception e) {
            System.out.println(e.getMessage());
        } catch (TaskNotFound_Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getRecord() {
        try {
            requestProcessorProxy.fetchRecords();
        } catch (TaskNotFound_Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void approveRecord(String record) {
        try {
            requestProcessorProxy.confirmRecord(record);
        } catch (AccessDenied_Exception e) {
            System.out.println(e.getMessage());
        } catch (TaskNotFound_Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void rejectRecord(String record) {
        try {
            requestProcessorProxy.rejectRecord(record);
        } catch (AccessDenied_Exception e) {
            System.out.println(e.getMessage());
        } catch (TaskNotFound_Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
