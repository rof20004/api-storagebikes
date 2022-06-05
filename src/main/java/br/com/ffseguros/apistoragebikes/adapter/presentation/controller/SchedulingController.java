package br.com.ffseguros.apistoragebikes.adapter.presentation.controller;

import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.SchedulingRequest;
import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.SchedulingResponse;
import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.mapper.SchedulingDtoMapper;
import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import br.com.ffseguros.apistoragebikes.application.service.SchedulingService;
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
@RequestMapping("/schedulings")
@RequiredArgsConstructor
@Api(tags = "Scheduling", description = "scheduling operations")
public class SchedulingController {

    private final SchedulingService schedulingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create a scheduling")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "scheduling created successfully", response = Scheduling.class)})
    public SchedulingResponse createScheduling(@RequestBody SchedulingRequest request) {
        var scheduling = Scheduling.builder()
                .id(UUID.randomUUID().toString())
                .customerName(request.getCustomerName())
                .outsourcingName(request.getOutsourcingName())
                .schedule(request.getSchedule())
                .build();

        this.schedulingService.saveScheduling(scheduling);

        return SchedulingDtoMapper.toResponse(scheduling);
    }

    @GetMapping
    @ApiOperation(value = "fetch all scheduling")
    public List<SchedulingResponse> getAllScheduling() {
        return this.schedulingService.getAllScheduling().stream()
                .map(SchedulingDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

}
