package Ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

    private String nome;
    private int matricula;
    private float N1, N2, N3, N4;
    private boolean aprovado;

    public String getNome() {
        return nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public float getN1() {
        return N1;
    }
    public float getN2() {
        return N2;
    }
    public float getN3() {
        return N3;
    }
    public float getN4() {
        return N4;
    }
    public boolean isAprovado() {
        return aprovado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public void setNotas(float n1, float n2, float n3, float n4) {
        this.N1 = n1;
        this.N2 = n2;
        this.N3 = n3;
        this.N4 = n4;
        this.aprovado = calcularMedia() >= 7.0f;
    }

    public void cadastrarAluno(Scanner sc) {
        System.out.print("nome: ");
        sc.nextLine();
        setNome(sc.nextLine());

        System.out.print("digita a matrícula: ");
        setMatricula(sc.nextInt());

        System.out.println("fala as 4 notas:");
        float n1 = sc.nextFloat();
        float n2 = sc.nextFloat();
        float n3 = sc.nextFloat();
        float n4 = sc.nextFloat();

        setNotas(n1, n2, n3, n4);
    }

    public float calcularMedia() {
        return (N1 + N2 + N3 + N4) / 4;
    }

    @Override
    public String toString() {
        return nome + ", media final: " + this.calcularMedia();
    }
}

