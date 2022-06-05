package br.com.ffseguros.apistoragebikes.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scheduling {

    private String id;
    private String customerName;
    private String outsourcingName;
    private String outsourcingType;
    private LocalDateTime schedule;

}
