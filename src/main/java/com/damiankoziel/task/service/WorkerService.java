package com.damiankoziel.task.service;

import com.damiankoziel.task.vm.NumbersToAddVm;
import com.damiankoziel.task.vm.WorkerVm;

public interface WorkerService {

    Long addNumbers(NumbersToAddVm numbersToAddVm);

    WorkerVm createWorker(WorkerVm workerVm);

    WorkerVm getWorkerById(Long id) throws Exception;
}
