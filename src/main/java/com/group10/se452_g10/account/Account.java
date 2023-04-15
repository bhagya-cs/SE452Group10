package com.group10.se452_g10.account;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Account {

    @Id
    @GeneratedValue
    private Long id;
    protected String username;
    protected String password;
}
