package com.compensar.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compensar.users.model.PerPersona;

@Repository
public interface PerPersonaDao extends JpaRepository<PerPersona, Long>{

}
