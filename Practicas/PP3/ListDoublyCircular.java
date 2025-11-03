package Practicas.PP3;

public class ListDoublyCircular<E> implements ListInterface<E> {
    private NodeDoubly<E> head;
    private NodeDoubly<E> tail;
    private int size;

    public ListDoublyCircular() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void addFirst(E data) {  
        NodeDoubly<E> newNode = new NodeDoubly<>(data);

    // Si la lista está vacía
    if (head == null) {
        head = newNode;
        tail = newNode;
        // el nodo se apunta a sí mismo
        newNode.next = newNode;
        newNode.prev = newNode;
    } else {
        // Conecta el nuevo nodo antes del actual head
        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        tail.next = newNode;
        head = newNode;
    }
    size++;
    
    }

    
    public void addLast(E data) {

    NodeDoubly<E> newNode = new NodeDoubly<>(data);

    // Si la lista está vacía
    if (tail == null) {
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
    } else {
        // Conecta el nuevo nodo después del actual tail
        newNode.prev = tail;
        newNode.next = head;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;
    }
    size++;

    }

    public E removeFirst() {
    if (head == null) {
        return null; // lista vacía
    }

    E data = head.data;

    // Si solo hay un nodo
    if (head == tail) {
        head = null;
        tail = null;
    } else {
        // El siguiente nodo se convierte en el nuevo head
        head = head.next;
        head.prev = tail;
        tail.next = head;
    }
    size--;
    return data;

    }

    public E removeLast() {
    if (tail == null) {
        return null; // lista vacía
    }

    E data = tail.data;

    // Si solo hay un nodo
    if (head == tail) {
        head = null;
        tail = null;
    } else {
        // El nodo anterior se convierte en el nuevo tail
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }
    size--;
    return data;

    }

}
