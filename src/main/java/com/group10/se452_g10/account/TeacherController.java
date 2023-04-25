package com.group10.se452_g10.account;

import java.util.List;

import com.group10.se452_g10.course.Course;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;
@RestController
@RequestMapping("/api/teachers")
@Log4j2
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepo teacherRepo;


    @PostMapping("addTeacher")
    public String addVTypes(@ModelAttribute Teacher teachers, Model model){
        teacherService.addTeacher(teachers);
        model.addAttribute("newTeacher", new Teacher());
        return "TeachersAdd";

    }

    @GetMapping
    @Operation(summary = "Returns all the Teachers in the database")
    @ApiResponse(responseCode = "200", description = "valid response",
            content = {@Content(mediaType="application/json", schema=@Schema(implementation= Teacher.class))})
    public List<Teacher> list(){
        log.traceEntry("Enter list");
        var retval = teacherRepo.findAll();
        log.traceExit("Exit list", retval);
        return teacherRepo.findAll();
    }

    @PostMapping("/save")
    @Operation(summary = "Save the Course and returns the Teacher First name")
    public String save(@RequestBody Teacher teach) {
        log.traceEntry("enter save", teach);
        teacherRepo.save(teach);
        log.traceExit("exit save", teach);
        return teach.getFirstName();
    }

    @DeleteMapping
    @Operation(summary = "Delete the teacher")
    public void delete(Long id) {
        log.traceEntry("Enter delete", id);
        teacherRepo.deleteById(id);
        log.traceExit("Exit delete");
    }

}
