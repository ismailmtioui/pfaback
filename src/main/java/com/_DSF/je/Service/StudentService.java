package com._DSF.je.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._DSF.je.Entity.Student;
import com._DSF.je.Repository.StudentRepository;
import com._DSF.je.Util.PasswordUtil;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student registerStudent(Student student) {
        student.setPassword(PasswordUtil.hashPassword(student.getPassword()));
        return studentRepository.save(student);
    }

    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}
