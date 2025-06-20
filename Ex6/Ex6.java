package Ex6;
import java.util.HashMap;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        HashMap<String, Integer> animais = new HashMap<>();

        // exemplos de dados da expedição
        animais.put("Onça", 2);
        animais.put("Tamanduá", 5);
        animais.put("Macaco", 8);
        animais.put("Bem-te-vi", 12);
        animais.put("Jaguatirica", 2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do animal que quer buscar: ");
        String animalBuscado = scanner.nextLine();

         if (animais.containsKey(animalBuscado)) {
             int quantidade = animais.get(animalBuscado);
             System.out.printf("%s foi visto %d vez(es) na expedição%n", animalBuscado, quantidade);
         } else {
             System.out.printf("%s não foi registrado na expedição.%n", animalBuscado);
         }
         scanner.close();
    }
}
