package com.project.SpringBootApp.model;

public class Person
{
    String id;
    String name;
    String age;
    Person(String id,String name,String age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public String toString()
    {
        return id+" "+name+" "+age;
    }
}
