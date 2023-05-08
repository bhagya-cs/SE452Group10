package com.group10.se452_g10.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dept;

    @Column(unique = true, nullable = false)
    private String num;

    private String name;

    public Course(String dept, String num, String name) {
        this.dept = dept;
        this.num = num;
        this.name = name;
    }
}
