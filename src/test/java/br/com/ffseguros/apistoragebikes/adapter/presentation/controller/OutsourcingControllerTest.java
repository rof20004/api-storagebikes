package br.com.ffseguros.apistoragebikes.adapter.presentation.controller;

import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.OutsourcingRequest;
import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.OutsourcingResponse;
import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
import br.com.ffseguros.apistoragebikes.application.service.OutsourcingService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OutsourcingControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private OutsourcingService outsourcingService;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void shouldCreateOutsourcing() {
        doNothing().when(outsourcingService).saveOutsourcing(any());

        var method = "POST";
        var endpoint = "/outsourcings";

        var request = OutsourcingRequest.builder()
                .name("Garage Fake")
                .address("Avenue Laguna")
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
    void shouldGetAllOutsourcing() {
        var entityOne = Outsourcing.builder()
                .id(UUID.randomUUID().toString())
                .name("Garage Fake One")
                .address("Avenue Laguna")
                .schedule(LocalDateTime.now())
                .build();

        var entityTwo = Outsourcing.builder()
                .id(UUID.randomUUID().toString())
                .name("Garage Fake Two")
                .address("Avenue Laguna")
                .schedule(LocalDateTime.now())
                .build();

        when(outsourcingService.getAllOutsourcing()).thenReturn(List.of(entityOne, entityTwo));

        var method = "GET";
        var endpoint = "/outsourcings";
        var response = with()
                .request(method, endpoint)
                .andReturn();

        var json = response.jsonPath();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(2, json.getList(".", OutsourcingResponse.class).size());
    }

}
