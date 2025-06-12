package Ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

    String nome;
    int matricula;

    float N1, N2, N3, N4;

    boolean aprovado;

    public void cadastrarAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        nome = sc.nextLine();
        System.out.println("Digite o matricula do aluno: ");
        matricula = sc.nextInt();

        System.out.println("Agora digite as 4 notas em sequencia");
        N1 = sc.nextFloat();
        N2 = sc.nextFloat();
        N3 = sc.nextFloat();
        N4 = sc.nextFloat();

        aprovado = (N1 + N2 + N3 + N4) / 4 >= 7.0;
    }

    public float media_Aluno(){
        float media = (N1 + N2 + N3 + N4) / 4;

        System.out.println("A media do aluno " + nome + " é " + media);

        return media;
    }

}
