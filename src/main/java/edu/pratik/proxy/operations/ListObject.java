package edu.pratik.proxy.operations;

import java.util.Objects;

public class ListObject {
    private final String task;
    private ApprovalStatus approvalStatus;

    public ListObject(String task) {
        this.task = task;
        approvalStatus = ApprovalStatus.PENDING;
    }

    public void updateApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListObject)) return false;
        ListObject that = (ListObject) o;
        return task.equals(that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }

    @Override
    public String toString() {
        return "ListObject{" +
                "task='" + task + '\'' +
                ", approvalStatus=" + approvalStatus +
                '}';
    }

    public String getTask() {
        return task;
    }
}
