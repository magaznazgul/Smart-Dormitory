package com.smartdormitory.service;

import com.smartdormitory.domain.RepairRequest;
import com.smartdormitory.domain.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestFactoryTest {

    @Test
    void repairFactoryShouldCreateRepairRequest() {
        RequestFactory factory = new RepairRequestFactory();

        Request request = factory.createRequest(
                1, "Айдана", "205",
                "Кран сломан", "repair"
        );

        assertInstanceOf(RepairRequest.class, request);
        assertEquals("Жөндеу жұмыстары", request.getCategory());
    }

    @Test
    void generalFactoryShouldCreateGeneralRequest() {
        RequestFactory factory = new GeneralRequestFactory();

        Request request = factory.createRequest(
                2, "Али", "310",
                "Бөлмеде мәселе бар", "Жалпы өтінім"
        );

        assertEquals(Request.class, request.getClass());
        assertEquals("Жалпы өтінім", request.getCategory());
    }
}