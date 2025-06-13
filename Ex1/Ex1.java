import java.util.ArrayList;

public class Ex1 {
    public static void main(String[] args) {
        var l = new ArrayList<String>();
        l.add("Curitiba" );
        l.add("Santa Maria");
        l.add("Florianópolis");
        l.add("Manaus");
        l.add("São Paulo");
        l.add("Brasília");

        for (var i = 0; i < l.size();) {
            int num_de_caracteres = l.get(i).length();
            if(num_de_caracteres % 2 == 0){
                System.out.println(l.get(i) + " - Numero de caracteres par: " + num_de_caracteres);
                System.out.println("O dado não será removido.\n");
                i++;
            }
            else {
                System.out.println(l.get(i) + " - Numero de caracteres impar: " + num_de_caracteres);
                System.out.println("Removendo dado da lista...\n");
                l.remove(i);
            }
        }

        System.out.println("Resultado final: ");
        for (var i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}
