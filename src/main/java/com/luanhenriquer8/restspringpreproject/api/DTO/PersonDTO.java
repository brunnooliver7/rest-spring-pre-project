package com.luanhenriquer8.restspringpreproject.api.DTO;

import com.luanhenriquer8.restspringpreproject.api.entities.PersonEntity;

import java.io.Serializable;

public class PersonDTO implements Serializable{

    private Integer id;

    private String name;

    public PersonDTO() {}

    private PersonDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonEntity parseToPersonEntity(Integer id, String name){
        return new PersonEntity.PersonBuiler()
                .id(id)
                .name(name)
                .CreatePersonEntity();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /** This class is for to have a build pattern. It make easy to create a new object and
     * define its own fields. Following example how to use it:
     *
     * PersonEntity entity = PersonDTO dto = new PersonDTO
     *      .PersonDTOBuilder()
     *      .id(1)
     *      .name("name")
     *      .CreatePersonDTO();
     *
     * */
    public static class PersonDTOBuilder{
        private Integer id;

        private String name;

        public PersonDTOBuilder() {}

        public PersonDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }

        public PersonDTOBuilder name(String name){
            this.name = name;
            return this;
        }

        public PersonDTO CreatePersonDTO(){
            return new PersonDTO(id, name);
        }
    }


}
