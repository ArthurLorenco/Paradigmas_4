package Ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        var lista = new ArrayList<Aluno>();

        int quantos;
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos alunos quer registrar?");
        quantos = sc.nextInt();

        for (int i = 0; i < quantos; i++) {
            Aluno aluno_novo = new Aluno();
            aluno_novo.cadastrarAluno();
            lista.add(aluno_novo);
        }

        System.out.println("Lista de alunos aprovados: ");
        for (Aluno aluno : lista) {
            if(aluno.aprovado) System.out.println(aluno.nome);
        }

    }

}
