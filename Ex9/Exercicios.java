package Ex9;

import java.util.List;

public class Exercicios {

    private int numero;
    private String nome;
    private List<String> musculosAtivados;

    public Exercicios(int numero, String nome, List<String> musculosAtivados) {
        this.numero = numero;
        this.nome = nome;
        this.musculosAtivados = musculosAtivados;
    }


    public int getNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }
    public List<String> getMusculosAtivados() {
        return musculosAtivados;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMusculosAtivados(List<String> musculosAtivados) {
        this.musculosAtivados = musculosAtivados;
    }

    // Representação em string
    @Override
    public String toString() {
        return String.format("%03d   %s - %s", numero, nome, String.join(", ", musculosAtivados));
    }

}
