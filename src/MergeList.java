import java.util.Scanner;
public class MergeList {

    public static QueueLinkedList merge(QueueLinkedList A, QueueLinkedList B) {
        QueueLinkedList C = new QueueLinkedList();
        while (!A.estaVazia() && !B.estaVazia()) {
            if (A.peek() <= B.peek()) {
                C.insere(A.remove());
            } else {
                C.insere(B.remove());
            }
        }
        while (!A.estaVazia()) C.insere(A.remove());
        while (!B.estaVazia()) C.insere(B.remove());
        return C;
    }

    private static void demo() {
        QueueLinkedList A = new QueueLinkedList();
        QueueLinkedList B = new QueueLinkedList();

        A.insere(12); A.insere(35); A.insere(52); A.insere(64);
        B.insere(5);  B.insere(15); B.insere(23); B.insere(55); B.insere(75);

        System.out.println("A:");
        A.imprime();
        System.out.println("B:");
        B.imprime();

        QueueLinkedList C = merge(A, B);
        System.out.println("C (merge):");
        C.imprime();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Merge (filas encadeadas) — Lucas Dal Pra");
        System.out.println("1) demo  0) manual");
        int modo = sc.nextInt();
        if (modo == 1) {
            demo();
            sc.close();
            return;
        }

        QueueLinkedList A = new QueueLinkedList();
        QueueLinkedList B = new QueueLinkedList();

        System.out.println("Insira A em ordem crescente (digite 99999 para terminar):");
        while (true) {
            int x = sc.nextInt();
            if (x == 99999) break;
            A.insere(x);
        }

        System.out.println("Insira B em ordem crescente (digite 99999 para terminar):");
        while (true) {
            int x = sc.nextInt();
            if (x == 99999) break;
            B.insere(x);
        }

        System.out.println("A:");
        A.imprime();
        System.out.println("B:");
        B.imprime();

        QueueLinkedList C = merge(A, B);
        System.out.println("C (merge):");
        C.imprime();

        sc.close();
    }
}
