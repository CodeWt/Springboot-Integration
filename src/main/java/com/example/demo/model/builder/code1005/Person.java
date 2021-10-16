package com.example.demo.model.builder.code1005;

import org.apache.commons.lang.builder.ToStringBuilder;

import static org.apache.commons.lang.builder.ToStringStyle.MULTI_LINE_STYLE;

/**
 *
 * Effective Java
 *
 */
public class Person {
    private String id;
    private String name;
    private int age;
    private int weight;
    private int score;
    private Location loc;

    private Person(){}

    public static class PersonBuilder{
        Person person = new Person();

        public PersonBuilder basicInfo(String id,String name,int age){
            person.id=id;
            person.name = name;
            person.age=age;
            return this;
        }
        public PersonBuilder loc(String street,String roomNo){
            person.loc = new Location(street, roomNo);
            return this;
        }
        public PersonBuilder weight(int weight){
            person.weight = weight;
            return this;
        }
        public PersonBuilder score(int score){
            person.score = score;
            return this;
        }
        public Person build(){
            return person;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,MULTI_LINE_STYLE);
    }
}
class Location{
    private String street;
    private String roomNo;
    public Location(String street,String roomNo){
        this.street=street;
        this.roomNo=roomNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,MULTI_LINE_STYLE);
    }
}
