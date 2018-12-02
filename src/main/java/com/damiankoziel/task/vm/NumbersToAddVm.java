package com.damiankoziel.task.vm;

import com.damiankoziel.task.config.ViewModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class NumbersToAddVm implements ViewModel {

    @NotNull
    @Min(0)
    @Max(10)
    private Long firstNumber;

    @NotNull
    @Min(0)
    @Max(10)
    private Long secondNumber;
}
