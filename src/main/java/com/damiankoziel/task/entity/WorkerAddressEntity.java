package com.damiankoziel.task.entity;

import com.damiankoziel.task.config.IEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "workers_address")
public class WorkerAddressEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String streetAddress;

    private String zipCode;

    private String region;

    private String city;

    private String country;

    @OneToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity worker;
}
