package com.group10.se452_g10.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

//
    public List<Student> findByAgeLessThanEqual(long age);

    public List<Student> findByFirstName(String name);


}
