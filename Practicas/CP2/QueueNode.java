// Implementación básica de nodos enlazados para cola con Gemini

package Practicas.CP2;

public class QueueNode {

    private int _value;
    private QueueNode _next;

    public QueueNode(int value) {
        _value = value;
        _next = null;
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        _value = value;
    }

    public QueueNode getNext() {
        return _next;
    }

    public void setNext(QueueNode next) {
        _next = next;
    }
}