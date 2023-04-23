package com.group10.se452_g10.course;

import com.group10.se452_g10.account.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "gpa")
@AllArgsConstructor
@NoArgsConstructor
public class GPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false, unique = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false, unique = false)
    private Student student;
    private float grade;
    private float gpa;
}
