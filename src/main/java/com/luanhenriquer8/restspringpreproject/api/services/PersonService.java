package com.luanhenriquer8.restspringpreproject.api.services;

import com.luanhenriquer8.restspringpreproject.api.DTO.PersonDTO;
import com.luanhenriquer8.restspringpreproject.api.PersonDAO;
import com.luanhenriquer8.restspringpreproject.api.entities.PersonEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public List<PersonDTO> getAllPeople() {

        Iterable<PersonEntity> peopleListEntities = personDAO.findAll();
        List<PersonDTO> peopleListDTO = new ArrayList<>();

        for (PersonEntity personEntity : peopleListEntities) {
            PersonDTO personDTO = new PersonEntity()
                    .parseToPersonDTO(
                            personEntity.getId(),
                            personEntity.getName());

            peopleListDTO.add(personDTO);
        }

        return peopleListDTO;
    }

    public PersonDTO getPerson(Integer personId) {
        PersonEntity personEntity = personDAO.findById(personId);
        PersonDTO personDTO = new PersonEntity()
                .parseToPersonDTO(
                        personEntity.getId(),
                        personEntity.getName());

        return personDTO;
    }

    public void createPerson(PersonDTO personDTO) {
        PersonEntity personEntity = new PersonDTO()
                .parseToPersonEntity(
                        personDTO.getId(),
                        personDTO.getName());

        personDAO.createPerson(personEntity);
    }

    public void updatePerson(Integer personId, PersonDTO personDTO) {
        PersonEntity personEntity = personDAO.findById(personId);
        PersonEntity personEntityToUpdate = new PersonDTO().parseToPersonEntity(personEntity.getId(), personDTO.getName());

        personDAO.updatePerson(personEntityToUpdate);
    }

    public Object deletePerson(Integer personId) {
        personDAO.deletePerson(personId);
        return "Example Controller Working";
    }
}
