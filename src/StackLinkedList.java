import java.util.Scanner;
public class StackLinkedList {
    private static class Node {
        int valor;
        Node prox;
        Node(int v) { valor = v; prox = null; }
    }

    private Node topo;

    public StackLinkedList() { topo = null; }

    public void insere(int x) {
        Node n = new Node(x);
        n.prox = topo;
        topo = n;
        System.out.println("insere: " + x);
    }

    public int remove() {
        if (topo == null) {
            System.out.println("remove: pilha vazia");
            return Integer.MIN_VALUE;
        }
        int v = topo.valor;
        topo = topo.prox;
        System.out.println("remove: " + v);
        return v;
    }

    public void imprime() {
        if (topo == null) {
            System.out.println("imprime: pilha vazia");
            return;
        }
        System.out.print("pilha (top -> base): ");
        Node p = topo;
        while (p != null) {
            System.out.print(p.valor + " ");
            p = p.prox;
        }
        System.out.println();
    }

    public boolean estaVazia() { return topo == null; }

    private static void demo() {
        StackLinkedList s = new StackLinkedList();
        s.insere(10);
        s.insere(20);
        s.insere(30);
        s.imprime();
        s.remove();
        s.imprime();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackLinkedList pilha = new StackLinkedList();
        System.out.println("Pilha (lista encadeada) — Lucas Dal Pra");
        while (true) {
            System.out.println("\n1) insere  2) remove  3) imprime  4) demo  0) sair");
            System.out.print("opção: ");
            int opc;
            try { opc = Integer.parseInt(sc.next()); } catch (Exception e) { opc = -1; }
            if (opc == 0) break;
            switch (opc) {
                case 1:
                    System.out.print("valor: ");
                    pilha.insere(sc.nextInt());
                    break;
                case 2:
                    pilha.remove();
                    break;
                case 3:
                    pilha.imprime();
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
