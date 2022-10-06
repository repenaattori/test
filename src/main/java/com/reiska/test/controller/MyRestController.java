package com.reiska.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reiska.test.data.Person;

@RestController
public class MyRestController {

    List<Person> persons = new ArrayList<>();

    @GetMapping("person")
    public Person getPerson(){
        return new Person("Reima", 23);
    }

    @GetMapping("persons")
    public List<Person> getPersons(){
        return persons;
    }

    @PostMapping("addperson")
    public Person addPerson(@RequestBody Person p){
        persons.add(p);
        return p;
    }

    @PostMapping("addmisc")
    public Map<String, Object> addPerson(@RequestBody Map<String, Object> jsonInfo){

        String hobby = (String)jsonInfo.get("hobby");
        int money = (int)jsonInfo.get("money");

        Map<String, Object> info = new HashMap<>();
        info.put("color", "red");
        info.put("points", 25);
        info.put("persons", List.of(
                    new Person("Pekka", 34),
                    new Person("Lisa", 22)
                ));

        return info;
    }
}
