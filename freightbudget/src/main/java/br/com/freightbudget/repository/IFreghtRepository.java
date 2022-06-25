package br.com.freightbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.freightbudget.datasources.FreightDB;

@Repository
public interface IFreghtRepository extends JpaRepository<FreightDB, Integer> {
	
}
