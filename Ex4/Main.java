package Ex4;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Paciente> filaDePacientes = new PriorityQueue<>();

        filaDePacientes.add(new Paciente("Marileno", 3));
        filaDePacientes.add(new Paciente("Leandra", 1));
        filaDePacientes.add(new Paciente("Thelissa", 4));
        filaDePacientes.add(new Paciente("Bianco", 2));
        filaDePacientes.add(new Paciente("Asa", 5));

        System.out.println("Iniciando atendimento dos pacientes:\n");

        while (!filaDePacientes.isEmpty()) {
            Paciente p = filaDePacientes.poll();
            System.out.println("Atendendo -> " + p);
        }
    }
}
