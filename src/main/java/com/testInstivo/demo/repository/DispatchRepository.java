package com.testInstivo.demo.repository;

import com.testInstivo.demo.entites.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DispatchRepository extends JpaRepository<Dispatch, Long> {

    List<Dispatch> findByRecipientName(String name);

    List<Dispatch> findByWeight(Double weight);

    List<Dispatch> findByZipCodeOrigin(String zip_code);

    List<Dispatch> findByZipCodeDestination(String zip_code);

    List<Dispatch> findByCostFreight(int zip_code);

    List<Dispatch> findByExpectedDeliveryDate(String date);
  }
