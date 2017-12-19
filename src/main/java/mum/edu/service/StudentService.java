package mum.edu.service;

import java.util.List;

import mum.edu.domain.Student;

public interface StudentService {

    Student save(Student student);

    List<Student> getAll();

    Student update(Student student);

    Student getByStudentId(String studentId);

    List<Student> findByStudentId(String studentId);
}
