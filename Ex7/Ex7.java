package Ex7;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Ex7 {

    public static void main(String[] args) {
        List<String> animais = new CopyOnWriteArrayList<>();

        // Thread 1: adiciona elementos à lista
        Thread t1 = new Thread(() -> {
            System.out.println("[T1] Adicionando elementos...");
            animais.add("Onça");
            animais.add("Macaco-prego");
            animais.add("Tamanduá");
        });

        // Thread 2: remove um elemento específico da lista
        Thread t2 = new Thread(() -> {
            try {
                // garante que elementos sejam adicionados primeiro
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("[T2] Removendo 'Macaco-prego'...");
            boolean removido = animais.remove("Macaco-prego");
            if (removido) {
                System.out.println("[T2] 'Macaco-prego' removida com sucesso.");
            } else {
                System.out.println("[T2] 'Macaco-prego' não encontrada.");
            }
        });

        // Thread 3: lê os elementos da lista
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(200); // espera a modificação acontecer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("[T3] Lendo lista de animais:");
            for (String animal : animais) {
                System.out.println(" - " + animal);
            }
        });

        // Inicia as threads
        t1.start();
        t2.start();
        t3.start();
    }
}

//Mesmo que as threads modifiquem e leiam a lista ao mesmo tempo, o CopyOnWriteArrayList garante consistência e thread safety.
