package model;

public class Escola {
    private int id_escola;
    private String nome_escola;

    public Escola(int id_escola, String nome_escola) {
        this.id_escola = id_escola;
        this.nome_escola = nome_escola;
    }

    public Escola(String nome_escola) {
        this.nome_escola = nome_escola;
    }

    public int getId_escola() {
        return id_escola;
    }

    public String getNome_escola() {
        return nome_escola;
    }

    @Override
    public String toString() {
        return "Escola: " + nome_escola;
    }
}

