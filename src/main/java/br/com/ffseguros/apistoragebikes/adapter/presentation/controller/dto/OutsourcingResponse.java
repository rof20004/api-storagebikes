package br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto;

import br.com.ffseguros.apistoragebikes.application.enums.OutsourcingType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OutsourcingResponse {

    private String id;
    private String name;
    private String address;
    private OutsourcingType type;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime schedule;

}
