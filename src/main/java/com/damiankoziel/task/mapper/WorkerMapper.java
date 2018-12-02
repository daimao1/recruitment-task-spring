package com.damiankoziel.task.mapper;

import com.damiankoziel.task.config.Mapper;
import com.damiankoziel.task.vm.WorkerVm;
import com.damiankoziel.task.entity.WorkerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkerMapper implements Mapper<WorkerEntity, WorkerVm> {
    private final ModelMapper modelMapper;

    @Override
    public WorkerEntity toEntity(WorkerVm VM) {
        return modelMapper.map(VM, WorkerEntity.class);
    }

    @Override
    public WorkerVm toVm(WorkerEntity entity) {
        return modelMapper.map(entity, WorkerVm.class);
    }
}
