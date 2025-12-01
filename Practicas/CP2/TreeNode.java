// Nodo básico para árbol binario, estructura sugerida por el chatbot Gemini

package Practicas.CP2;

public class TreeNode {

    private double tf;
    private CustomStack words;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(double tf) {
        this.tf = tf;
        this.words = new CustomStack();
        this.left = null;
        this.right = null;
    }

    public double getTf() {
        return tf;
    }

    public CustomStack getWords() {
        return words;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode node) {
        this.left = node;
    }

    public void setRight(TreeNode node) {
        this.right = node;
    }
}
