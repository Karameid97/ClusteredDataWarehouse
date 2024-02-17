package com.task.ClusteredDataWarehouse.service;

import com.task.ClusteredDataWarehouse.repository.DealRepository;
import com.task.ClusteredDataWarehouse.repository.FakeDealRepository;
import com.task.ClusteredDataWarehouse.common.ResponseEnvelop;
import com.task.ClusteredDataWarehouse.common.validation.Validation;
import com.task.ClusteredDataWarehouse.common.validation.ValidationService;
import com.task.ClusteredDataWarehouse.dto.RequestDeal;
import com.task.ClusteredDataWarehouse.entity.DealEntity;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static com.task.ClusteredDataWarehouse.common.Constants.*;

public class DealServiceTest {
    private DealRepository dealRepository;
    private DealService service;

    @BeforeEach
    public void setup(){
        Validation validation=new ValidationService();
        dealRepository= new FakeDealRepository();
        service =new DealService(validation,dealRepository);
    }

    @AfterEach
    public void after(){
        dealRepository.deleteAll();
    }


    @Test
    public void testValidSenario(){
        RequestDeal requestDeal = new RequestDeal("1", "USD", "JOD", new BigDecimal(100), "2022-01-01 12:34:56");
        ResponseEnvelop responseEnvelop = service.process(requestDeal);

        Assertions.assertEquals(SUCCESS,responseEnvelop.getStatus());
        Assertions.assertEquals(APPROVED_DEAL,responseEnvelop.getMessage());
    }


    @Test
    public void testinValidSenario(){
        DealEntity entity=new DealEntity();
        entity.setRefNo("111");
        dealRepository.save(entity);

        RequestDeal requestDeal = new RequestDeal("111", "USD", "JOD", new BigDecimal(100), "2022-01-01 12:34:56");
        ResponseEnvelop responseEnvelop = service.process(requestDeal);

        Assertions.assertEquals(REJECTED,responseEnvelop.getStatus());
        Assertions.assertEquals(REJECTED_DEAL,responseEnvelop.getMessage());
    }
}
