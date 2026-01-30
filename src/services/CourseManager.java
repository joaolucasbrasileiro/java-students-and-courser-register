package services;

import entities.Course;
import controller.RegisterUser;
import utils.InputManager;

import java.util.*;

public class CourseManager {

    private RegisterUser registerUser;

    private Scanner sc = InputManager.getSc();
    private Map<String, Course> courses = new HashMap<>();

    public CourseManager(RegisterUser registerUser) {
        this.registerUser = registerUser;

        courses.put("A", new Course("A"));
        courses.put("B", new Course("B"));
        courses.put("C", new Course("C"));
    }

    public void addCourse(String key, Course course) {
        courses.put(key, course);
    }

    public Course getCourse(String key) {
        return courses.get(key);
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }

    public int getTotalStudents() {
        int total = 0;
        for (Course course : courses.values()) {
            total += course.getTotalUsers();
        }
        return total;
    }

}
