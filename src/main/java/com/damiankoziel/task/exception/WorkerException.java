package com.damiankoziel.task.exception;

public class WorkerException extends Exception {
    public WorkerException(final String workerNotFound) {
        super(workerNotFound);
    }
}
