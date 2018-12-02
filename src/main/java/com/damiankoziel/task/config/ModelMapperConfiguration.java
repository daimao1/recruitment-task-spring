package com.damiankoziel.task.config;

import com.damiankoziel.task.vm.WorkerVm;
import com.damiankoziel.task.entity.WorkerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(WorkerEntity.class, WorkerVm.class)
                .addMappings(mapper -> {
                    mapper.map(workerEntity -> workerEntity.getWorkerAddress().getCity(), WorkerVm::setCity);
                    mapper.map(workerEntity -> workerEntity.getWorkerAddress().getCountry(), WorkerVm::setCountry);
                    mapper.map(workerEntity -> workerEntity.getWorkerAddress().getRegion(), WorkerVm::setRegion);
                    mapper.map(workerEntity -> workerEntity.getWorkerAddress().getStreetAddress(), WorkerVm::setStreetAddress);
                    mapper.map(workerEntity -> workerEntity.getWorkerAddress().getZipCode(), WorkerVm::setZipCode);
                });

        return modelMapper;
    }
}
