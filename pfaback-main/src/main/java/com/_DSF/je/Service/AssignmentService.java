package com._DSF.je.Service;

import com._DSF.je.Entity.Assignment;
import com._DSF.je.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Set<Assignment> getAllAssignments() {
        return Set.copyOf(assignmentRepository.findAll());
    }

    public Assignment updateAssignment(Long id, Assignment assignmentDetails) {
        Optional<Assignment> optionalAssignment = assignmentRepository.findById(id);
        System.out.println("zbi"+optionalAssignment.isPresent());
        if (optionalAssignment.isPresent()) {
            Assignment assignment = optionalAssignment.get();
            assignment.setTitle(assignmentDetails.getTitle());
            assignment.setDescription(assignmentDetails.getDescription());
            assignment.setCourse(assignmentDetails.getCourse());
            return assignmentRepository.save(assignment);
        }
        return null;
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
