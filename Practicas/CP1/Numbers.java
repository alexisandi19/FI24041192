package Practicas.CP1;

// Numbers.java
// Pagina que use: https://plus.maths.org/content/silver-ratio
// Implementación y explicación adaptadas con ayuda de ChatGPT.

import java.text.DecimalFormat;
import java.util.Locale;

public class Numbers {

    // nombres de los metales 

    private static final String[] METALS = {
        "Platinum","Golden","Silver","Bronze","Copper",
        "Nickel","Aluminum","Iron","Tin","Lead"
    };

    // n global 

    private static final int N = 25;

    // Formateador a 10 decimales
    private static final DecimalFormat DF = new DecimalFormat("0.##########");

    public static void main(String[] args) {

        // Forzar locale para punto decimal

        Locale.setDefault(Locale.US);

        for (int z = 0; z < METALS.length; z++) {
            System.out.println("[" + z + "] " + METALS[z]);
            double fN = recursive(z, N);
            double fNminus1 = recursive(z, N - 1);
            System.out.println(" ↳ formula(" + z + ")   ≈ " + DF.format(formula(z)));
            System.out.println(" ↳ recursive(" + z + ") ≈ " + DF.format(fN / fNminus1));
            System.out.println(" ↳ iterative(" + z + ") ≈ " + DF.format(iterative(z, N) / iterative(z, N - 1)));
            System.out.println();
        }
    }

    // Métodos públicos 
    
    // (Se asume que en el enunciado estos ya están correctos)
    // Aquí los mantenemos públicos por claridad; en el enunciado
    // los que se cambian son los privados (pero esto es funcional).
    
    // Implementación de la fórmula directa:
    private static double formula(int z) {
        // formula(z) = (z + sqrt(4 + z^2)) / 2
        return (z + Math.sqrt(4.0 + z * (double) z)) / 2.0;
    }

    // Improvement: recursivo corregido según f(z, n) definido en enunciado

    private static double recursive(int z, int n) {
        
        // f(z,0)=1, f(z,1)=1, f(z,n)= z*f(z,n-1) + f(z,n-2)

        if (n == 0 || n == 1) return 1.0;
        return z * recursive(z, n - 1) + recursive(z, n - 2);
    }

    // Update: implementación iterativa equivalente
    
    private static double iterative(int z, int n) {
        if (n == 0 || n == 1) return 1.0;
        double a = 1.0; // f(z,0)
        double b = 1.0; // f(z,1)
        double c = 1.0;
        for (int i = 2; i <= n; i++) {
            c = z * b + a; // f(z,i) = z*f(z,i-1) + f(z,i-2)
            a = b;
            b = c;
        }
        return c;
    }
}