package br.com.ffseguros.apistoragebikes.adapter.database.jpa.repository;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.model.SchedulingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<SchedulingModel, String> {
}
