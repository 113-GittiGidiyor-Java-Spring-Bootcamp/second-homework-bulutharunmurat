package dev.patika.patika.service;

import dev.patika.patika.database.CourseDAO;
import dev.patika.patika.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements BaseService<Course> {

    CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    @Override
    public Course update(Course course) {
        return (Course) courseDAO.update(course);
    }

    @Override
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }
}
