package com.damiankoziel.task.worker;

import com.damiankoziel.task.entity.WorkerAddressEntity;
import com.damiankoziel.task.entity.WorkerEntity;
import com.damiankoziel.task.repository.WorkerRepository;
import com.damiankoziel.task.service.WorkerService;
import com.damiankoziel.task.vm.WorkerVm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkerResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper json;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private WorkerRepository workerRepository;

    @Test
    public void shouldCreateWorker() throws Exception {
        WorkerVm workerVm = new WorkerVm();
        workerVm.setCity("exampleCity");
        workerVm.setCountry("exampleCountry");
        workerVm.setRegion("exampleRegion");
        workerVm.setStreetAddress("exampleStreetAddress");
        workerVm.setZipCode("zipCode");
        workerVm.setEmail("example@email.com");
        workerVm.setFirstName("exampleFirstName");
        workerVm.setLastName("exampleLastName");
        workerVm.setPhone("examplePhone");
        workerVm.setPosition("examplePosition");

        mockMvc.perform(put("/api/workers/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(json.writeValueAsString(workerVm))).andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    public void shouldNotCreateWorkerIfValidationIsIncorrect() throws Exception {
        WorkerVm workerVm = new WorkerVm();
        workerVm.setCity("exampleCity");
        workerVm.setCountry("exampleCountry");
        workerVm.setRegion("exampleRegion");
        workerVm.setStreetAddress("exampleStreetAddress");
        workerVm.setZipCode("tooLongZipCode12345");
        workerVm.setEmail("notValidEmailAddress");
        workerVm.setFirstName("exampleFirstName");
        workerVm.setLastName("exampleLastName");
        workerVm.setPhone("PhoneIsTooLong");
        workerVm.setPosition("examplePosition");

        mockMvc.perform(put("/api/workers/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(json.writeValueAsString(workerVm))).andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldNotCreateWorkerIfRequiredDataIsEmpty() throws Exception {
        WorkerVm workerVm = new WorkerVm();
        workerVm.setCity("exampleCity");
        workerVm.setCountry("exampleCountry");
        workerVm.setRegion("exampleRegion");
        workerVm.setStreetAddress("exampleStreetAddress");
        workerVm.setZipCode("zipCode");
        workerVm.setEmail("email@email.com");
        workerVm.setPhone("phone");
        workerVm.setPosition("examplePosition");

        mockMvc.perform(put("/api/workers/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(json.writeValueAsString(workerVm))).andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldGetWorkerById() throws Exception {
        WorkerAddressEntity workerAddressEntity = new WorkerAddressEntity();
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setPosition("examplePosition");
        workerEntity.setPhone("123456789");
        workerEntity.setFirstName("exampleFirstName");
        workerEntity.setLastName("exampleLastName");
        workerEntity.setEmail("email@email.com");
        workerEntity.setWorkerAddress(workerAddressEntity);
        workerAddressEntity.setWorker(workerEntity);
        WorkerEntity savedWorker = workerRepository.save(workerEntity);

        mockMvc.perform(get("/api/workers/{id}", savedWorker.getId())).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk()).andDo(print());

    }


}

