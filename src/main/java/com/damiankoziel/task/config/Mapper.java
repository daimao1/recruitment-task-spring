package com.damiankoziel.task.config;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<ENTITY extends IEntity, VM extends ViewModel> {

    ENTITY toEntity(VM VM);

    VM toVm(ENTITY entity);

    default List<ENTITY> toEntities(List<VM> VMS) {
        return VMS.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<VM> toVms(List<ENTITY> entities) {
        return entities.stream().map(this::toVm).collect(Collectors.toList());
    }

}

