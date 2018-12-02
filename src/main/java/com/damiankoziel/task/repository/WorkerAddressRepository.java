package com.damiankoziel.task.repository;

import com.damiankoziel.task.entity.WorkerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerAddressRepository extends JpaRepository<WorkerAddressEntity, Long> {
}
