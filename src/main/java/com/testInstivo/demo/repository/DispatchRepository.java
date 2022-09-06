package com.testInstivo.demo.repository;

import com.testInstivo.demo.entites.ResponseDispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatchRepository extends JpaRepository<ResponseDispatch, Long> {
}
