// Código de prueba y ensamble utilizado para validar estructuras CP2 con Gemini

package Practicas.CP2;

public class Main {
    public static void main(String[] args) {

        // Prueba de CustomQueue
        
        CustomQueue queue = new CustomQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue()); 
        System.out.println("Queue size: " + queue.getSize()); 

        // Prueba de CustomStack
        
        CustomStack stack = new CustomStack();
        stack.push("hola");
        stack.push("mundo");
        System.out.println("Pop: " + stack.pop()); 
        System.out.println("Stack size: " + stack.size()); 

        // Prueba de CustomTree

        CustomTree tree = new CustomTree();
        tree.add(0.5, "casa");
        tree.add(0.2, "perro");
        tree.add(0.7, "gato");
        tree.add(0.5, "carro"); 

        System.out.println("Root TF: " + tree.getRoot().getTf());
        System.out.println("Words en root: " + tree.getRoot().getWords().size());

        // Prueba de CustomGraph
        
        CustomGraph graph = new CustomGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);

        graph.print();
    }
}
