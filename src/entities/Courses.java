package entities;

import services.RegisterUser;
import utils.InputManager;

import java.util.Set;
import java.util.TreeSet;

public class Courses {

    private RegisterUser registerUser;
    private Set<Users> A = new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName()));
    private Set<Users> B = new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName()));
    private Set<Users> C = new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName()));

    InputManager inputManager = new InputManager();

    public Courses(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    public void addCourse(String courseName, Set<Users> courseSet) {

        System.out.println("Quantas vagas no curso " + courseName + "?");

        int n;
        try {
            n = Integer.parseInt(inputManager.getSc().nextLine());
            if (n <= 0) {
                System.out.println("O número de vagas deve ser positivo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido.");
            return;
        }

        System.out.println("Serão " + n + " vagas. Inscreva os alunos pelo ID:");
        System.out.println("ALUNOS DISPONÍVEIS:");
        for (Users u : registerUser.getListUsers()) {
            System.out.println(u);
        }

        int vacancies = 0;

        while (vacancies < n) {
            System.out.print("Digite o ID do aluno para a vaga " + (vacancies+1) + ": ");

            try {
                int id = Integer.parseInt(inputManager.getSc().nextLine());

                if (id <= 0) {
                    System.out.println("O ID do aluno deve ser positivo.");
                    continue;
                }

                Users user = registerUser.getUsersById(id);

                if (user == null) {
                    System.out.println("ID não encontrado.");
                    continue;
                }

                if (!courseSet.add(user)) {
                    System.out.println("Aluno já matriculado neste curso.");
                    continue;
                }

                System.out.println("Aluno matriculado com sucesso!");
                vacancies++;

            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números.");
            }
        }
    }

    public int getTotalCourseUsers() {
        Set<Users> totalCourseUsers = new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName()));
        totalCourseUsers.addAll(A);
        totalCourseUsers.addAll(B);
        totalCourseUsers.addAll(C);
        return totalCourseUsers.size();
    }

    public Set<Users> getCourseA() {
        return A;
    }
    public Set<Users> getCourseB() {
        return B;
    }
    public Set<Users> getCourseC() {
        return C;
    }
}
