package br.com.ffseguros.apistoragebikes.adapter.database.jpa.model;

import br.com.ffseguros.apistoragebikes.application.enums.OutsourcingType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "outsourcing")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OutsourcingModel {

    @Id
    private String id;
    private String name;
    private String address;
    private OutsourcingType type;
    private LocalDateTime schedule;

}
