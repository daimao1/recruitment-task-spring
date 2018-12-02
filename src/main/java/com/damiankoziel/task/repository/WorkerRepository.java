package com.damiankoziel.task.repository;

import com.damiankoziel.task.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
}
