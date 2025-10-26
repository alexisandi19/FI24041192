package Practicas.CP1;

// TheQueue.java
// Pagina que use: Uso de ArrayDeque (Deque) y operaciones poll/peek/push adaptadas.
// Implementación con ayuda de ChatGPT.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;
import java.util.Random;
import java.util.Arrays;

public class TheQueue {

    private final Deque<Character> queue;
    private final int n; // Aqui se ve la cantidad de nucleótidos generados

    // constructor 
    
    public TheQueue(int n) {
        this.n = n;
        this.queue = new ArrayDeque<>();
    }

    // enqueue: agrega al final

    public void enqueue(Character c) {
        queue.addLast(c);
    }

    // Improvement: dequeue debe retornar y remover el frente; retornar null si vacía
    // Nota: sin usar condicionales, aprovechamos poll() que retorna null si está vacía

    public Character dequeue() {
        return queue.poll(); // poll() devolvera null si vacia
    }

    // Improvement: getFront solo retorna el frente sin quitar; retorna null si vacía
    // Usamos peekFirst() (equivalente a peek() en ArrayDeque)

    public Character getFront() {
        return queue.peekFirst();
    }

    public int getSize() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public String print() {
        return queue.toString();
    }

    // Update: El getCodons vacía la cola formando ternas, retorno String[] de tamaño n/3

    public String[] getCodons() {
        int codonCount = n / 3;
        String[] codons = new String[codonCount];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (!queue.isEmpty() && idx < codonCount) {
            
            // formar una terna

            sb.setLength(0);
            
            // Aqui asumimos que n es múltiplo de 3 (según enunciado)

            Character a = queue.poll(); // poll puede devolver null pero queue no debería quedar con nulls aquí
            Character b = queue.poll();
            Character c = queue.poll();
            sb.append(a).append(b).append(c);
            codons[idx++] = sb.toString();
        }
        return codons;
    }

   
    // main de demostración

        public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        int n = 15;
        if (args.length > 0) n = Integer.parseInt(args[0]);

        TheQueue q = new TheQueue(n);
        Random rnd = new Random();

        // nucleótidos: A, C, G, T

        char[] nucleotidos = {'A','C','G','T'};

        // Llenar la cola con n elementos aleatorios

        for (int i = 0; i < n; i++) {
            char c = nucleotidos[rnd.nextInt(nucleotidos.length)];
            q.enqueue(c);
        }

        System.out.println("Filled {full}");
        System.out.println(" ↳ print() → " + q.print());
        System.out.println("   ↳ getFront() → " + q.getFront());
        System.out.println("   ↳ getSize() → " + q.getSize());
        System.out.println("   ↳ isEmpty() → " + q.isEmpty());
        System.out.println();
        System.out.println("getCodons() → " + Arrays.toString(q.getCodons()));
        System.out.println();
        System.out.println("End {empty}");
        System.out.println(" ↳ print() → " + q.print());
        System.out.println("   ↳ getFront() → " + q.getFront());
        System.out.println("   ↳ getSize() → " + q.getSize());
        System.out.println("   ↳ isEmpty() → " + q.isEmpty());
    }
}