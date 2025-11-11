package model;

public class Professor extends Usuario {
    private int RP;
    private String materia;
    private Escola escola;

    public Professor(int RP, String nome, String email, String senha, String materia, Escola escola) {
        super(nome, email, senha);
        this.RP = RP;
        this.materia = materia;
        this.escola = escola;
    }

    public Professor(String nome, String email, String senha, String materia, Escola escola) {
        super(nome, email, senha);
        this.materia = materia;
        this.escola = escola;
    }

    public int getRP() {
        return RP;
    }

    public String getMateria() {
        return materia;
    }

    public Escola getEscola() {
        return escola;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== Professor ===");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Matéria: " + materia);
        System.out.println("Escola: " + escola.getNome_escola());
    }
}
