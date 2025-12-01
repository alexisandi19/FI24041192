// Implementación guiada de matriz de adyacencia para grafo con ChatGPT
// Referencia conceptual: https://www.geeksforgeeks.org/graph-and-its-representations/

package Practicas.CP2;

public class CustomGraph {

    private int[][] _matrix;
    private int size; 

    // Constructor: crea una matriz NxN

    public CustomGraph(int size) {
        this.size = size;
        this._matrix = new int[size][size];
    }

    // Agrega un arco dirigido (from → to)

    public void addEdge(int fromIdx, int toIdx) {
        if (fromIdx < 0 || toIdx < 0 || fromIdx >= size || toIdx >= size) {
            System.out.println("Índice fuera de rango");
            return;
        }
        _matrix[fromIdx][toIdx] += 1;
    }

    // Obtiene la matriz

    public int[][] getMatrix() {
        return _matrix;
    }

    // Retorna la cantidad de nodos

    public int getSize() {
        return size;
    }

    // Imprime el grafo como matriz de adyacencia

    public void print() {
        System.out.println("Matriz de adyacencia:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(_matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
