package edu.pratik.proxy.operations;

import edu.pratik.proxy.exception.TaskAlreadyAdded_Exception;
import edu.pratik.proxy.exception.TaskNotFound_Exception;

import java.util.HashSet;
import java.util.Set;

public class OperatingList {
    private static final Set<ListObject> LIST_OF_OPERATIONS = new HashSet<>();

    public void InsertRecord(ListObject record) throws TaskAlreadyAdded_Exception {
        if (recordAvailable(record))
            throw new TaskAlreadyAdded_Exception("cannot insert duplicate record.", new Throwable("Trying to insert duplicate record in OPERATION_LIST."));
        LIST_OF_OPERATIONS.add(record);
    }
    public void deleteRecord(ListObject record) throws TaskNotFound_Exception {
        if (!recordAvailable(record))
            throw new TaskNotFound_Exception("Task "+record.getTask()+" not found in OPERATION_LIST", new Throwable("Trying to delete absent record from OPERATION_LIST."));
        LIST_OF_OPERATIONS.remove(record);
    }
    public Set<ListObject> fetchRecords() throws TaskNotFound_Exception {
        if(LIST_OF_OPERATIONS.isEmpty())
            throw new TaskNotFound_Exception("No task found in OPERATION_LIST", new Throwable("Empty OPERATION_LIST."));
        return LIST_OF_OPERATIONS;
    }
    public void confirmRecord(ListObject record) throws TaskNotFound_Exception {
        if(record==null)
            throw new TaskNotFound_Exception("Empty task cannot be approved.", new Throwable("Trying to approve null record."));
        else if(!recordAvailable(record))
            throw new TaskNotFound_Exception("Task "+record.getTask()+" not found in OPERATION_LIST", new Throwable("Trying to approve absent record from OPERATION_LIST."));

        record.updateApprovalStatus(ApprovalStatus.APPROVED);
        LIST_OF_OPERATIONS.remove(record);
        LIST_OF_OPERATIONS.add(record);
    }

    public void rejectRecord(ListObject record) throws TaskNotFound_Exception {
        if(record==null)
            throw new TaskNotFound_Exception("Empty task cannot be rejected.", new Throwable("Trying to reject null record."));
        else if(!recordAvailable(record))
            throw new TaskNotFound_Exception("Task "+record.getTask()+" not found in OPERATION_LIST", new Throwable("Trying to reject absent record from OPERATION_LIST."));

        record.updateApprovalStatus(ApprovalStatus.REJECTED);
        LIST_OF_OPERATIONS.remove(record);
        LIST_OF_OPERATIONS.add(record);
    }

    private boolean recordAvailable(ListObject record) {
        return LIST_OF_OPERATIONS.contains(record);
    }
}
