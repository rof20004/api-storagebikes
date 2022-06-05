package br.com.ffseguros.apistoragebikes.adapter.presentation.controller;

import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.OutsourcingRequest;
import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.OutsourcingResponse;
import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.mapper.OutsourcingDtoMapper;
import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
import br.com.ffseguros.apistoragebikes.application.service.OutsourcingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/outsourcings")
@RequiredArgsConstructor
@Api(tags = "Outsourcing", description = "outsourcing operations")
public class OutsourcingController {

    private final OutsourcingService outsourcingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create an outsourcing")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "outsourcing created successfully", response = Outsourcing.class)})
    public OutsourcingResponse createOutsourcing(@RequestBody OutsourcingRequest request) {
        var outsourcing = Outsourcing.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .address(request.getAddress())
                .schedule(request.getSchedule())
                .type(request.getType())
                .build();

        this.outsourcingService.saveOutsourcing(outsourcing);

        return OutsourcingDtoMapper.toResponse(outsourcing);
    }

    @GetMapping
    @ApiOperation(value = "fetch all outsourcing")
    public List<OutsourcingResponse> getAllOutsourcing() {
        return this.outsourcingService.getAllOutsourcing().stream()
                .map(OutsourcingDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

}
