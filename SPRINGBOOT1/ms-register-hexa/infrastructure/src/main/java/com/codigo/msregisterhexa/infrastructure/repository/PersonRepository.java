package com.codigo.msregisterhexa.infrastructure.repository;

import com.codigo.msregisterhexa.infrastructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
