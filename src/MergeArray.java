import java.util.Scanner;
public class MergeArray {

    static class QueueArray {
        private int[] data;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public QueueArray(int cap) {
            capacity = Math.max(1, cap);
            data = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void insere(int x) {
            if (size == capacity) {
                System.out.println("insere: fila cheia (cap=" + capacity + ")");
                return;
            }
            rear = (rear + 1) % capacity;
            data[rear] = x;
            size++;
            System.out.println("insere: " + x);
        }

        public int remove() {
            if (size == 0) {
                System.out.println("remove: fila vazia");
                return Integer.MIN_VALUE;
            }
            int v = data[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("remove: " + v);
            return v;
        }

        public void imprime() {
            if (size == 0) {
                System.out.println("imprime: fila vazia");
                return;
            }
            System.out.print("fila (front -> rear): ");
            int idx = front;
            for (int i = 0; i < size; i++) {
                System.out.print(data[idx] + " ");
                idx = (idx + 1) % capacity;
            }
            System.out.println();
        }

        public boolean estaVazia() { return size == 0; }

        public int peek() {
            if (size == 0) return Integer.MIN_VALUE;
            return data[front];
        }

        public int tamanho() { return size; }

        public static QueueArray fromArray(int[] arr) {
            QueueArray q = new QueueArray(arr.length + 5);
            for (int v : arr) q.insere(v);
            return q;
        }
    }

    public static QueueArray merge(QueueArray A, QueueArray B) {
        QueueArray C = new QueueArray(A.tamanho() + B.tamanho() + 5);
        while (!A.estaVazia() && !B.estaVazia()) {
            if (A.peek() <= B.peek()) C.insere(A.remove());
            else C.insere(B.remove());
        }
        while (!A.estaVazia()) C.insere(A.remove());
        while (!B.estaVazia()) C.insere(B.remove());
        return C;
    }

    private static void demo() {
        int[] aVals = {12, 35, 52, 64};
        int[] bVals = {5, 15, 23, 55, 75};
        QueueArray A = QueueArray.fromArray(aVals);
        QueueArray B = QueueArray.fromArray(bVals);
        System.out.println("A:");
        A.imprime();
        System.out.println("B:");
        B.imprime();
        QueueArray C = merge(A, B);
        System.out.println("C (merge):");
        C.imprime();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Merge (filas por array) — Lucas Dal Pra");
        System.out.println("1) demo  0) manual");
        int modo = sc.nextInt();
        if (modo == 1) {
            demo();
            sc.close();
            return;
        }

        System.out.print("capacidade fila A: ");
        QueueArray A = new QueueArray(sc.nextInt());
        System.out.println("insira A em ordem crescente (99999 p/ terminar):");
        while (true) {
            int v = sc.nextInt();
            if (v == 99999) break;
            A.insere(v);
        }

        System.out.print("capacidade fila B: ");
        QueueArray B = new QueueArray(sc.nextInt());
        System.out.println("insira B em ordem crescente (99999 p/ terminar):");
        while (true) {
            int v = sc.nextInt();
            if (v == 99999) break;
            B.insere(v);
        }

        System.out.println("A:");
        A.imprime();
        System.out.println("B:");
        B.imprime();

        QueueArray C = merge(A, B);
        System.out.println("C (merge):");
        C.imprime();

        sc.close();
    }
}
