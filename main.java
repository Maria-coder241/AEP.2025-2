package main;

import dao.ProfessorDAO;
import model.Escola;
import model.Professor;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Escola escola = new Escola(1, "Colégio Estadual Maringá");
        Professor prof = new Professor("Carlos Silva", "carlos@email.com", "1234", "Matemática", escola);

        ProfessorDAO dao = new ProfessorDAO();
        dao.inserir(prof);

        System.out.println("\nLista de Professores:");
        ArrayList<Professor> lista = dao.listar();
        for (Professor p : lista) {
            p.exibirInformacoes();
            System.out.println("-------------------");
        }
    }
}

