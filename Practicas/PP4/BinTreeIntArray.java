package Practicas.PP4;

public class BinTreeIntArray {

    private Integer[] _tree;    

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public static void main(String[] args) {
        BinTreeIntArray bt = new BinTreeIntArray(7);

        System.out.println("\nEmpty array → " + java.util.Arrays.toString(bt._tree));

        int[] nodes = {4, 6, 5, 2, 7, 1, 3};

        for (int n : nodes) {
            bt.insert(n); 
            System.out.println(" ↳ insert: " + n + " → " + java.util.Arrays.toString(bt._tree));
        }

        System.out.println("\nFull array → " + java.util.Arrays.toString(bt._tree));

        System.out.print(" ↳ inOrderTraversal → ");
        bt.inOrderTraversal(0);
        System.out.println();

        System.out.print(" ↳ preOrderTraversal → ");
        bt.preOrderTraversal();
        System.out.println();

        System.out.print(" ↳ postOrderTraversal → ");
        bt.postOrderTraversal();
        System.out.println();
    }

    // Método Insert 
    
    public void insert(Integer value) {
        // Actualizar

        int i = 0; // Empezamos en la raíz

        while (i < _tree.length) {

            if (_tree[i] == null) { 
                _tree[i] = value;
                return; 
            }

            // Árbol binario ordenado
            if (value < _tree[i]) {
                // Ir a la izquierda: 2i + 1
                i = 2 * i + 1;
            } else {
                // Ir a la derecha: 2i + 2
                i = 2 * i + 2;
            }
        }
    }

    // Método Pre-Order 

    public void preOrderTraversal() {
        // Actualizar

        // Usando un stack manual basado en índices
        int size = _tree.length;
        int[] stack = new int[size];
        int top = -1;

        // Empezamos por la raíz
        stack[++top] = 0;

        while (top >= 0) {

            int i = stack[top--];

            // Si el nodo NO es null, imprimirlo y empujar hijos
            if (i < size && _tree[i] != null) {
                System.out.print(_tree[i] + " ");

                // Push derecha primero (para que izquierda salga primero)
                int right = 2 * i + 2;
                if (right < size && _tree[right] != null)
                    stack[++top] = right;

                // Push izquierda
                int left = 2 * i + 1;
                if (left < size && _tree[left] != null)
                    stack[++top] = left;
            }
        }
    }

    // Método Post-Order  
  
    public void postOrderTraversal() {
        // Actualizar

        int size = _tree.length;

        int[] stack1 = new int[size];
        int[] stack2 = new int[size];
        int top1 = -1, top2 = -1;

        // Iniciamos desde la raíz
        stack1[++top1] = 0;

        while (top1 >= 0) {

            int i = stack1[top1--];

            if (i < size && _tree[i] != null) {
                stack2[++top2] = i;

                // hijos
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < size && _tree[left] != null)
                    stack1[++top1] = left;

                if (right < size && _tree[right] != null)
                    stack1[++top1] = right;
            }
        }

        // Imprimir en orden post-order usando stack2
        while (top2 >= 0) {
            System.out.print(_tree[stack2[top2--]] + " ");
        }
    }

    public void inOrderTraversal(int i) {
        if (i >= _tree.length || _tree[i] == null)
            return;

        inOrderTraversal(2 * i + 1);
        System.out.print(_tree[i] + " ");
        inOrderTraversal(2 * i + 2);
    }
}
    

