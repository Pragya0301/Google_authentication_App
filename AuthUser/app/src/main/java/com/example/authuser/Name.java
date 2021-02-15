package com.example.authuser;

public class Name {

    String Id;
    String name;
    String email;
    public Name(){

    }

    public Name(String name, String id, String email) {
        this.name = name;
        Id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }
}
