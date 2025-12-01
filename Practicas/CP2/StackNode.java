// Implementación básica de nodos enlazados para pila con Gemini

package Practicas.CP2;

public class StackNode {

    private String _value;
    private StackNode _next;

    public StackNode(String value) {
        _value = value;
        _next = null;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    public StackNode getNext() {
        return _next;
    }

    public void setNext(StackNode next) {
        _next = next;
    }
}