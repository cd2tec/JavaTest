package br.com.sigabem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigabem.model.EncomendaModel;

@Repository
public interface EncomendaRepository extends JpaRepository<EncomendaModel, Long> {

}
