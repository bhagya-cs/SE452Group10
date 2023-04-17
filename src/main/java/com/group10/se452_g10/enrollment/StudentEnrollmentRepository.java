package com.group10.se452_g10.enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, Long> {
}
