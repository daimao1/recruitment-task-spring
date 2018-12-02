package com.damiankoziel.task.worker;

import com.damiankoziel.task.mapper.WorkerMapper;
import com.damiankoziel.task.repository.WorkerRepository;
import com.damiankoziel.task.service.WorkerServiceImpl;
import com.damiankoziel.task.vm.NumbersToAddVm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(MockitoJUnitRunner.class)
public class WorkerUnitTests {

    @InjectMocks
    private WorkerServiceImpl workerService;

    @Autowired
    private WorkerMapper workerMapper;

    @Test
    public void shouldAddTwoNumbers() {
        NumbersToAddVm numbers = new NumbersToAddVm();
        numbers.setFirstNumber(11L);
        numbers.setSecondNumber(7L);
        assertEquals(18, workerService.addNumbers(numbers).longValue());
    }

    @Test
    public void shouldNotAddTwoNumbersCorrectlyIfDataIsOutOfRange() {
        NumbersToAddVm numbers = new NumbersToAddVm();
        numbers.setFirstNumber(Long.MAX_VALUE);
        numbers.setSecondNumber(1L);
        assertFalse(workerService.addNumbers(numbers) > Long.MAX_VALUE);
    }

}
