package com.damiankoziel.task.vm;

import com.damiankoziel.task.config.ViewModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class WorkerVm implements ViewModel {

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Email
    @Size(min = 6, max = 150)
    private String email;

    @NotNull
    @Size(max = 12)
    private String phone;

    @NotNull
    private String position;

    private String streetAddress;

    @Size(max = 10)
    private String zipCode;

    private String region;

    private String city;

    private String country;


}
