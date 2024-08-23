package com._DSF.je.Controller;

import com._DSF.je.Entity.Teacher;
import com._DSF.je.Service.TeacherService;
import com._DSF.je.Util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerTeacher(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("image") MultipartFile image) {

        try {
            Teacher teacher = new Teacher();
            teacher.setUsername(username);
            teacher.setPassword(PasswordUtil.hashPassword(password));
            teacher.setEmail(email);
            teacher.setImage(image.getBytes());

            teacherService.registerTeacher(teacher);
            return new ResponseEntity<>("Teacher registered successfully", HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while processing the image", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginTeacher(@RequestParam String username, @RequestParam String password) {
        Teacher teacher = teacherService.findByUsername(username);
        if (teacher != null && teacher.getPassword().equals(password)) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }
}
