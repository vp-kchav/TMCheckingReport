package mum.edu.dao;

import java.util.List;

import mum.edu.domain.Student;
import mum.edu.domain.TMCheckingReport;

public interface StudentDao {


    long save(Student student);

    List<Student> getAll();

    Student update(Student student);

    Student get(long id);
    
    Student getByStudentId(String studentId);

    //List<Student> getCheckedStudents();

}
