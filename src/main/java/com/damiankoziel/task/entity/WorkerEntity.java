package com.damiankoziel.task.entity;

import com.damiankoziel.task.config.IEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "workers")
public class WorkerEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String position;

    @OneToOne(mappedBy = "worker",
            cascade = CascadeType.ALL,
            optional = false)
    private WorkerAddressEntity workerAddress;

}
