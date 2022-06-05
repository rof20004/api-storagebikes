package br.com.ffseguros.apistoragebikes.application.entity;

import br.com.ffseguros.apistoragebikes.application.enums.OutsourcingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Outsourcing {

    private String id;
    private String name;
    private String address;
    private LocalDateTime schedule;
    private OutsourcingType type;

}
