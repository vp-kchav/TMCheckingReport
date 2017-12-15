package mum.edu.service.impl;

import mum.edu.dao.StudentDao;
import mum.edu.domain.Student;
import mum.edu.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao;

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student update(Student student) {
        return studentDao.update(student);
    }

    public StudentServiceImpl(){

    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
