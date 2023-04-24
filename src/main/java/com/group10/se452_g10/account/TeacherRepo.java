package com.group10.se452_g10.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {



    public List<Teacher> findByAgeLessThanEqual(long age);

    public List<Teacher> findByFirstName(String name);



}
