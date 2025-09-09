import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== TDE1 — Pilhas e Filas Dinâmicas ===");
            System.out.println("1) Pilha (StackLinkedList)");
            System.out.println("2) Fila (QueueLinkedList)");
            System.out.println("3) Merge com listas encadeadas");
            System.out.println("4) Merge com arrays");
            System.out.println("0) Sair");
            System.out.print("opção: ");

            int opc;
            try {
                opc = Integer.parseInt(sc.next());
            } catch (Exception e) {
                opc = -1;
            }

            switch (opc) {
                case 1 -> StackLinkedList.main(new String[]{});
                case 2 -> QueueLinkedList.main(new String[]{});
                case 3 -> MergeList.main(new String[]{});
                case 4 -> MergeArray.main(new String[]{});
                case 0 -> {
                    System.out.println("fim.");
                    sc.close();
                    return;
                }
                default -> System.out.println("opção inválida.");
            }
        }
    }
}
