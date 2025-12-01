// Implementación de árbol binario y lógica adaptada para CP2 con ChatGPT
// Referencia conceptual: https://www.baeldung.com/java-binary-tree

package Practicas.CP2;

public class CustomTree {

    private TreeNode root;

    public CustomTree() {
        this.root = null;
    }

    // Método público para insertar usando TF y palabra
    public void add(double tf, String word) {
        root = insert(root, tf, word);
    }

    // Variante A: usando nodo completo
  
    private TreeNode insert(TreeNode current, TreeNode newNode) {
        if (current == null) {
            return newNode;
        }

        double currentTf = current.getTf();
        double newTf = newNode.getTf();

        if (newTf < currentTf) {
            current.setLeft(insert(current.getLeft(), newNode));
        } else if (newTf > currentTf) {
            current.setRight(insert(current.getRight(), newNode));
        } else {
           
            current.getWords().push(newNode.getWords().pop());
        }

        return current;
    }

    // Variante B: usando TF y palabra directamente

    private TreeNode insert(TreeNode current, double tf, String word) {
        if (current == null) {
            TreeNode nodo = new TreeNode(tf);
            nodo.getWords().push(word);
            return nodo;
        }

        double currentTf = current.getTf();

        if (tf < currentTf) {
            current.setLeft(insert(current.getLeft(), tf, word));
        } else if (tf > currentTf) {
            current.setRight(insert(current.getRight(), tf, word));
        } else {
           
            current.getWords().push(word);
        }

        return current;
    }

    public TreeNode getRoot() {
        return root;
    }
}