package com.group10.se452_g10.account;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class User extends Account {
    protected String email;
    protected String firstName;
    protected String lastName;
    protected long phoneNumber;
    protected long address;
    protected long ssn;
    protected Date dob;
}
