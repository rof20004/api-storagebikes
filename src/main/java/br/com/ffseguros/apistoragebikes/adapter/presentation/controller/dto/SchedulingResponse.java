package br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SchedulingResponse {

    private String id;
    private String customerName;
    private String outsourcingName;
    private String outsourcingType;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime schedule;

}
