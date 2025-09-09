import java.util.Scanner;

/**
 * Lucas Dal Pra — Implementação de Fila usando lista encadeada.
 * Métodos exigidos: insere, remove, imprime
 *
 * Convenção:
 * - front: início (onde se remove)
 * - rear: fim (onde se insere)
 */
public class QueueLinkedList {
    private static class Node {
        int valor;
        Node prox;
        Node(int v) { valor = v; prox = null; }
    }

    private Node front;
    private Node rear;

    public QueueLinkedList() { front = null; rear = null; }

    public void insere(int x) {
        Node n = new Node(x);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.prox = n;
            rear = n;
        }
        System.out.println("insere: " + x);
    }

    public int remove() {
        if (front == null) {
            System.out.println("remove: fila vazia");
            return Integer.MIN_VALUE;
        }
        int v = front.valor;
        front = front.prox;
        if (front == null) rear = null;
        System.out.println("remove: " + v);
        return v;
    }

    public void imprime() {
        if (front == null) {
            System.out.println("imprime: fila vazia");
            return;
        }
        System.out.print("fila (front -> rear): ");
        Node p = front;
        while (p != null) {
            System.out.print(p.valor + " ");
            p = p.prox;
        }
        System.out.println();
    }

    public boolean estaVazia() { return front == null; }

    public int peek() {
        if (front == null) return Integer.MIN_VALUE;
        return front.valor;
    }

    private static void demo() {
        QueueLinkedList q = new QueueLinkedList();
        q.insere(12); q.insere(35); q.insere(52); q.insere(64);
        q.imprime();
        q.remove();
        q.imprime();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLinkedList fila = new QueueLinkedList();
        System.out.println("Fila (lista encadeada) — Lucas Dal Pra");
        while (true) {
            System.out.println("\n1) insere  2) remove  3) imprime  4) demo  0) sair");
            System.out.print("opção: ");
            int opc;
            try { opc = Integer.parseInt(sc.next()); } catch (Exception e) { opc = -1; }
            if (opc == 0) break;
            switch (opc) {
                case 1:
                    System.out.print("valor: ");
                    fila.insere(sc.nextInt());
                    break;
                case 2:
                    fila.remove();
                    break;
                case 3:
                    fila.imprime();
                    break;
                case 4:
                    demo();
                    break;
                default:
                    System.out.println("opção inválida");
            }
        }
        sc.close();
        System.out.println("fim.");
    }
}
