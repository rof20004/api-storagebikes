package br.com.ffseguros.apistoragebikes.adapter.presentation.controller;

import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.SchedulingRequest;
import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.SchedulingResponse;
import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import br.com.ffseguros.apistoragebikes.application.service.SchedulingService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.with;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchedulingControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private SchedulingService schedulingService;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void shouldCreateScheduling() {
        var method = "POST";
        var endpoint = "/schedulings";

        var request = SchedulingRequest.builder()
                .customerName("Customer Fake")
                .outsourcingName("Garage Fake")
                .schedule(LocalDateTime.parse("9999-12-31 23:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .build();

        var response = with()
                .contentType(ContentType.JSON)
                .body(request)
                .request(method, endpoint)
                .andReturn();

        var json = response.jsonPath();

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
        assertNotNull(json.get("id"));
    }

    @Test
    void shouldGetAllScheduling() {
        var entityOne = Scheduling.builder()
                .id(UUID.randomUUID().toString())
                .customerName("Customer Fake One")
                .outsourcingName("Garage Fake One")
                .schedule(LocalDateTime.now())
                .build();

        var entityTwo = Scheduling.builder()
                .id(UUID.randomUUID().toString())
                .customerName("Customer Fake Two")
                .outsourcingName("Garage Fake Two")
                .schedule(LocalDateTime.now())
                .build();

        when(schedulingService.getAllScheduling()).thenReturn(List.of(entityOne, entityTwo));

        var method = "GET";
        var endpoint = "/schedulings";
        var response = with()
                .request(method, endpoint)
                .andReturn();

        var json = response.jsonPath();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(2, json.getList(".", SchedulingResponse.class).size());
    }

}
