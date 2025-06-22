package Ex9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Planos {

    private String nome;
    private int codigo;
    private float valorMensal;

    public Planos() {}

    public String getNome() {
        return nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public float getValorMensal() {
        return valorMensal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setValorMensal(float valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Planos(String nome, int codigo, float valorMensal) {
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setValorMensal(Math.round(valorMensal * 100) / 100f);
    }

    public static void ListarPlanos(ArrayList<Planos> ListaPlanos) {

        if(ListaPlanos.isEmpty()) {
            System.out.println("nao tem nenhum plano");
        }

        for (Planos plano: ListaPlanos) {
            System.out.println(plano);
        }
        System.out.println();
    }
    public static void AdicionarPlano(Scanner sc, ArrayList<Planos> ListaPlanos) {

        Planos planoNovo = new Planos();

        System.out.print("fala o numero/codigo do plano: ");
        planoNovo.setCodigo(sc.nextInt());
        sc.nextLine();

        System.out.print("diz o nome do plano: ");
        planoNovo.setNome(sc.nextLine());

        System.out.print("e qual o valor do plano: ");
        planoNovo.setValorMensal(sc.nextFloat());
        sc.nextLine();

        ListaPlanos.add(planoNovo);

        System.out.println("Pronto :O\n");

    }

    @Override
    public String toString() {
        String nomeFormatado = String.format("%-15s", nome);
        return codigo + "   " + nomeFormatado + "   " + valorMensal;
    }

}
