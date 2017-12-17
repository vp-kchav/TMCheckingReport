package mum.edu.service;

import mum.edu.domain.Student;

import java.util.List;

public interface StudentService {

    long save(Student student);

    List<Student> getAll();

    Student update(Student student);


}
