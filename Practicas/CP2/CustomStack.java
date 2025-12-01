// Código de ejemplo generado y adaptado con ChatGPT
// https://www.geeksforgeeks.org/stack-data-structure/

package Practicas.CP2;

public class CustomStack {

    private StackNode _top;

    // agrega al inicio (tope)
    public void push(String word) {
        StackNode newNode = new StackNode(word);
        newNode.setNext(_top);
        _top = newNode;
    }

    // retorna la palabra del tope; si está vacía => null
    public String pop() {
        if (_top == null) return null;

        String val = _top.getValue();
        _top = _top.getNext();
        return val;
    }

    // recorre la pila contando nodos
    public int size() {
        int count = 0;
        StackNode current = _top;

        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}
