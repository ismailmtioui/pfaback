package com._DSF.je.Service;

import com._DSF.je.Entity.Course;
import com._DSF.je.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourse(Long id) {
        return courseRepository.findById(id);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(courseDetails.getTitle());
        course.setTeacher(courseDetails.getTeacher());
        course.setStudents(courseDetails.getStudents());
        course.setAssignments(courseDetails.getAssignments());
        course.setQuizzes(courseDetails.getQuizzes());
        course.setVideos(courseDetails.getVideos());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(course);
    }
}
