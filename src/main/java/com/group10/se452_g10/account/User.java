package com.group10.se452_g10.account;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
//Seperating User fields
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class User extends Account {
    protected String email;
    protected String firstName;
    protected String lastName;
    protected long phoneNumber;
    protected String address;
    protected long ssn;
    protected Date dob;
    protected String gender;


    public User(){

    }
    public User(String firstName, String lastName, long age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
