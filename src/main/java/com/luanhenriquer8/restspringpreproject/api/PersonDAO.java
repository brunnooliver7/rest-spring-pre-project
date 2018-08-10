package com.luanhenriquer8.restspringpreproject.api;

import com.luanhenriquer8.restspringpreproject.api.entities.PersonEntity;
import com.luanhenriquer8.restspringpreproject.api.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDAO  {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity findById(Integer personId){
        return personRepository.getOne(personId);
    }

    public List<PersonEntity> findAll(){
        return personRepository.findAll();
    }

    public void createPerson(PersonEntity personEntity){
        personRepository.save(personEntity);
    }

    public void updatePerson(PersonEntity personEntity) {
        personRepository.save(personEntity);
    }

    public void deletePerson(Integer personId){
        personRepository.deleteById(personId);
    }
}
