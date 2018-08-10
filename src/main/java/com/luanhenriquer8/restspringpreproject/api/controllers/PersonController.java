package com.luanhenriquer8.restspringpreproject.api.controllers;

import com.luanhenriquer8.restspringpreproject.api.DTO.PersonDTO;
import com.luanhenriquer8.restspringpreproject.api.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> getAllPeople(){
        return personService.getAllPeople();
    }

    @ResponseBody
    @RequestMapping(value = "/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO getPerson(@PathVariable Integer personId){
        return personService.getPerson(personId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody PersonDTO personDTO){
        personService.createPerson(personDTO);
        return "Person saved success";
    }

    @ResponseBody
    @RequestMapping(value = "/{personId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object updatePerson(@PathVariable Integer personId,@RequestBody PersonDTO personDTO){
        personService.updatePerson(personId, personDTO);
        return "Person updated success";
    }

    @ResponseBody
    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deletePerson(@PathVariable Integer personId){
        personService.deletePerson(personId);
        return "Person deleted success";
    }
}
