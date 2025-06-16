package Ex4;

import java.util.PriorityQueue;

class Paciente implements Comparable<Paciente> {
    private String nome;
    private int nivelUrgencia; // 1 (mais urgente) a 5 (menos urgente)

    public Paciente(String nome, int nivelUrgencia) {
        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
    }

    public String getNome() {
        return nome;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    @Override
    public int compareTo(Paciente outro) {
        return Integer.compare(this.nivelUrgencia, outro.nivelUrgencia);
    }

    @Override
    public String toString() {
        return "paciente: " + nome + " (urgencia: " + nivelUrgencia + ")";
    }
}
