// Código de ejemplo generado y adaptado con ChatGPT
// Referencia conceptual: https://www.geeksforgeeks.org/queue-linked-list-implementation/

package Practicas.CP2;

public class CustomQueue {

    private QueueNode _head;
    private QueueNode _tail;

    public void enqueue(int index) {
        QueueNode newNode = new QueueNode(index);

        if (_head == null) {
            _head = newNode;
            _tail = newNode;
        } else {
            _tail.setNext(newNode);
            _tail = newNode;
        }
    }

    public int dequeue() {
        if (_head == null) return -1;

        int val = _head.getValue();
        _head = _head.getNext();

        if (_head == null) _tail = null;

        return val;
    }

    public int getSize() {
        int count = 0;
        QueueNode current = _head;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }
}
