package com.luanhenriquer8.restspringpreproject.api.repositories;

import com.luanhenriquer8.restspringpreproject.api.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
