package edu.pratik.proxy.operations;

import edu.pratik.proxy.exception.TaskAlreadyAdded_Exception;
import edu.pratik.proxy.exception.TaskNotFound_Exception;

public class RequestProcessor {

    OperatingList oList = new OperatingList();

    public void InsertRecord(String task) throws TaskAlreadyAdded_Exception {
        oList.InsertRecord(new ListObject(task));
    }

    public void deleteRecord(String task) throws TaskNotFound_Exception {
        oList.deleteRecord(new ListObject(task));
    }

    public void fetchRecords() throws TaskNotFound_Exception {
        System.out.println(oList.fetchRecords());
    }

    public void confirmRecord(String task) throws TaskNotFound_Exception {
        oList.confirmRecord(new ListObject(task));
    }

    public void rejectRecord(String task) throws TaskNotFound_Exception {
        oList.rejectRecord(new ListObject(task));
    }
}
