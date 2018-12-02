package com.damiankoziel.task.resource;

import com.damiankoziel.task.vm.NumbersToAddVm;
import com.damiankoziel.task.vm.WorkerVm;
import com.damiankoziel.task.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/workers")
@RequiredArgsConstructor
public class WorkerResource {
    private final WorkerService workerService;

    @PostMapping("/addNumbers")
    public ResponseEntity<Long> addNumbers(@RequestBody NumbersToAddVm numbersToAddVm) {
        Long result = workerService.addNumbers(numbersToAddVm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/save")
    public ResponseEntity<Void> saveWorker(@RequestBody @Valid WorkerVm workerVm) {
        WorkerVm VM = workerService.createWorker(workerVm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerVm> getWorkerById(@PathVariable Long id) throws Exception {
        WorkerVm workerVm = workerService.getWorkerById(id);
        return new ResponseEntity<>(workerVm, HttpStatus.OK);
    }

}
