package br.com.ffseguros.apistoragebikes.adapter.database.jpa.repository;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.model.OutsourcingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutsourcingRepository extends JpaRepository<OutsourcingModel, String> {
}
