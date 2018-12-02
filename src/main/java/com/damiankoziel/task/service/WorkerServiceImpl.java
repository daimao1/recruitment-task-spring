package com.damiankoziel.task.service;

import com.damiankoziel.task.exception.WorkerException;
import com.damiankoziel.task.vm.NumbersToAddVm;
import com.damiankoziel.task.vm.WorkerVm;
import com.damiankoziel.task.entity.WorkerAddressEntity;
import com.damiankoziel.task.entity.WorkerEntity;
import com.damiankoziel.task.mapper.WorkerMapper;
import com.damiankoziel.task.repository.WorkerAddressRepository;
import com.damiankoziel.task.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerAddressRepository workerAddressRepository;
    private final WorkerMapper workerMapper;

    @Override
    public Long addNumbers(NumbersToAddVm numbersToAddVm) {
        return numbersToAddVm.getFirstNumber() + numbersToAddVm.getSecondNumber();
    }

    @Override
    public WorkerVm createWorker(WorkerVm workerVm) {
        WorkerEntity workerEntity = workerMapper.toEntity(workerVm);
        WorkerAddressEntity workerAddressEntity = new WorkerAddressEntity();
        workerAddressEntity.setCity(workerVm.getCity());
        workerAddressEntity.setCountry(workerVm.getCountry());
        workerAddressEntity.setRegion(workerVm.getRegion());
        workerAddressEntity.setStreetAddress(workerVm.getStreetAddress());
        workerAddressEntity.setZipCode(workerVm.getZipCode());
        workerAddressEntity.setWorker(workerEntity);
        workerAddressRepository.save(workerAddressEntity);
        workerRepository.save(workerEntity);
        return workerMapper.toVm(workerEntity);
    }

    @Override
    public WorkerVm getWorkerById(Long id) throws Exception {
        WorkerEntity workerEntity = workerRepository.findById(id).orElseThrow(() -> new WorkerException("Nie odnaleziono pracownika o podanym id: " + id));
        return workerMapper.toVm(workerEntity);
    }


}
