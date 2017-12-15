package mum.edu.dao;

import mum.edu.domain.Student;

import java.util.List;

public interface StudentDao {


    Student save(Student student);

    List<Student> getAll();

    Student update(Student student);
}
