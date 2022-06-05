package br.com.ffseguros.apistoragebikes.adapter.database.jpa.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "scheduling")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SchedulingModel {

    @Id
    private String id;
    private String customerName;
    private String outsourcingName;
    private String outsourcingType;
    private LocalDateTime schedule;

}
