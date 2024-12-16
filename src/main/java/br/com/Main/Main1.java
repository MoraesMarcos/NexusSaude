package br.com.Main;

import jakarta.persistence.EntityManager;
import java.util.Scanner;

import br.com.Entidade.JPAUtil;
import br.com.Persistence.MedicoDAO;
import br.com.Persistence.PacienteDAO;

public class Main1 {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Scanner scanner = new Scanner(System.in);

        try {
            menuCadastro(em, scanner);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no sistema de cadastro.");
        } finally {
            em.close();
            scanner.close();
        }
    }

    public static void menuCadastro(EntityManager em, Scanner scanner) {
        MedicoDAO medicoDAO = new MedicoDAO(em);
        PacienteDAO pacienteDAO = new PacienteDAO(em);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n### MENU CADASTRO ###");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Cadastrar Paciente");
            System.out.println("3. Listar Médicos");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Atualizar Médico");
            System.out.println("6. Atualizar Paciente");
            System.out.println("7. Deletar Médico");
            System.out.println("8. Deletar Paciente");
            System.out.println("9. Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        medicoDAO.cadastrar(scanner);
                        break;
                    case 2:
                        pacienteDAO.cadastrar(scanner);
                        break;
                    case 3:
                        medicoDAO.listar();
                        break;
                    case 4:
                        pacienteDAO.listar();
                        break;
                    case 5:
                        medicoDAO.atualizar(scanner);
                        break;
                    case 6:
                        pacienteDAO.atualizar(scanner);
                        break;
                    case 7:
                        medicoDAO.deletar(scanner);
                        break;
                    case 8:
                        pacienteDAO.deletar(scanner);
                        break;
                    case 9:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, tente novamente.");
                scanner.nextLine();
            }
        }
    }
}
