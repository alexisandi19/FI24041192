package Practicas.CP1;

// TheStack.java
// Pagina que use: implementación clásica de pila con array (estructura LIFO).
// Adaptado con ayuda de ChatGPT.

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;

public class TheStack {

    private final Double[] items; // arreglo interno para la pila
    private int top;              // índice del tope (número actual de elementos)
    private final int capacity;   // capacidad máxima

    // Constructor 

    public TheStack(int capacity) {
        this.capacity = capacity;
        this.items = new Double[capacity];
        this.top = 0; // indica cantidad actual
    }

    // push: Improvement debe retornar true si pudo insertar, false si overflow

    public Boolean push(Double value) {
        if (top >= capacity) {
            return false; // overflow -> no insertar
        }
        items[top++] = value;
        return true;
    }

    // pop: Update retornar null si está vacía

    public Double pop() {
        if (top == 0) return null;
        Double val = items[--top];
        items[top] = null; // ayuda al GC
        return val;
    }

    // peek: Update retornar null si vacía 

    public Double peek() {
        if (top == 0) return null;
        return items[top - 1];
    }

    // print: muestra contenido desde base[0] ... top-1
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < top; i++) {
            sb.append(items[i]);
            if (i < top - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return top;
    }

    public boolean empty() {
        return top == 0;
    }

 
    // main de demostración

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DecimalFormat df = new DecimalFormat("0.###############");
        
        // args[0] será provisto, mayor o igual a cero

        int n = 3;
        if (args.length > 0) n = Integer.parseInt(args[0]);

        TheStack stack = new TheStack(n);
        Random rnd = new Random();

        System.out.println("Pushing {capacity + 1}");
        for (int i = 0; i < stack.capacity + 1; i++) {
            double r = rnd.nextDouble();
            System.out.println(" ↳ push(" + df.format(r) + ") → " + stack.push(r));
        }

        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());

        System.out.println();
        System.out.println("Popping {capacity + 1}");
        for (int i = 0; i < stack.capacity + 1; i++) {
            System.out.println(" ↳ pop() → " + stack.pop());
        }

        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
    }
}