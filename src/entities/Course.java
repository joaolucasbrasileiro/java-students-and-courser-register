package entities;


import java.util.LinkedHashSet;
import java.util.Set;

public class Course {

    private String name;
    private int vacancies;
    private Set<Users> users = new LinkedHashSet<>();

    public Course(String name) {
        this.name = name;
    }

    public boolean addUser(Users user) {
        return users.add(user);
    }

    public void setVacancies(int vacancies) {
        if (vacancies <= 0) {
            throw new IllegalArgumentException("Número de vagas inválido.");
        }
        this.vacancies = vacancies;
    }

    public int getTotalUsers() {
        return users.size();
    }

    public boolean hasVacancy() {
        return users.size() < vacancies;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public boolean checkVacancy() {
        return users.size() < vacancies;
    }
}