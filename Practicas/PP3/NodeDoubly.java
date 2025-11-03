package Practicas.PP3;

public class NodeDoubly<E> {
    E data;                // valor guardado en el nodo
    NodeDoubly<E> next;    // referencia al siguiente nodo
    NodeDoubly<E> prev;    // referencia al nodo anterior

    public NodeDoubly(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}