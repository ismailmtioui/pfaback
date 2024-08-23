package com._DSF.je.Controller;

import com._DSF.je.Entity.Student;
import com._DSF.je.Service.StudentService;
import com._DSF.je.Util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerStudent(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("image") MultipartFile image) {

        try {
            Student student = new Student();
            student.setUsername(username);
            student.setPassword(PasswordUtil.hashPassword(password));
            student.setEmail(email);
            student.setImage(image.getBytes());

            studentService.registerStudent(student);
            return new ResponseEntity<>("Student registered successfully", HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while processing the image", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestParam String username, @RequestParam String password) {
        Student student = studentService.findByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }
}
