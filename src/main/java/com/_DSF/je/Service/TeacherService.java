package com._DSF.je.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._DSF.je.Entity.Teacher;
import com._DSF.je.Repository.TeacherRepository;
import com._DSF.je.Util.PasswordUtil;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher registerTeacher(Teacher teacher) {
        teacher.setPassword(PasswordUtil.hashPassword(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }

    public Teacher findByUsername(String username) {
        return teacherRepository.findByUsername(username);
    }
}
