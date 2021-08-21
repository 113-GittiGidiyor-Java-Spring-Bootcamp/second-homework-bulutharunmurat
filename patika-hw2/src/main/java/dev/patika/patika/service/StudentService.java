package dev.patika.patika.service;

import dev.patika.patika.database.StudentDAO;
import dev.patika.patika.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService implements BaseService<Student> {


    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentService() {
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return (Student) studentDAO.save(student);
    }

    @Override
    public void deleteFromDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Student object, int id) {

    }
}
