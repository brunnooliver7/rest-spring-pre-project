package com.luanhenriquer8.restspringpreproject.api.entities;

import com.luanhenriquer8.restspringpreproject.api.DTO.PersonDTO;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "person_name")
    private String name;

    public PersonEntity() {}

    /** This construct is private just to be used by the PersonBuilder class */
    private PersonEntity(Integer id, String name) {
        this.id  = id;
        this.name = name;
    }

    public PersonDTO parseToPersonDTO(Integer id, String name){
        return new PersonDTO.PersonDTOBuilder()
                .id(id)
                .name(name)
                .CreatePersonDTO();
    }

    /** getId method to return the entity's id */
    public Integer getId() {
        return id;
    }

    /** @param id
     * setId method to set the entity's id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** getName method to return the entity's name */
    public String getName() {
        return name;
    }

    /** @param name
     *  setName method to set the entity's name */
    public void setName(String name) {
        this.name = name;
    }

    /** This class is for to have a build pattern. It make easy to create a new object and
     * define its own fields. Following example how to use it:
     *
     * PersonEntity entity = new PersonEntity
     *      .PersonBuiler()
     *      .id(1)
     *      .name("name")
     *      .CreatePersonEntity();
     *
     * */
    public static class PersonBuiler{

        private Integer id;

        private String name;

        public PersonBuiler() {}

        public PersonBuiler id(Integer id){
            this.id = id;
            return this;
        }

        public PersonBuiler name(String name){
            this.name = name;
            return this;
        }

        public PersonEntity CreatePersonEntity(){
            return new PersonEntity(id, name);
        }
    }
}
