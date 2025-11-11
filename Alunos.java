package model;

public class Alunos extends Usuario {
    private int RA;
    private String ano_escolar;
    private Escola escola;

    public Alunos(int RA, String nome, String email, String senha, String ano_escolar, Escola escola) {
        super(nome, email, senha);
        this.RA = RA;
        this.ano_escolar = ano_escolar;
        this.escola = escola;
    }

    public Alunos(String nome, String email, String senha, String ano_escolar, Escola escola) {
        super(nome, email, senha);
        this.ano_escolar = ano_escolar;
        this.escola = escola;
    }

    public String getAno_escolar() {
        return ano_escolar;
    }

    public Escola getEscola() {
        return escola;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aluno");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Ano Escolar: " + ano_escolar);
        System.out.println("Escola: " + escola.getNome_escola());
    }
}


