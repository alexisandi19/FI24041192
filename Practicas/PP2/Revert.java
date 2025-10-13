package Practicas.PP2;

import java.io.*;
import java.util.Stack;

public class Revert {
    public static void main(String[] args) {
        // Nombres de los archivos
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Crear la pila de caracteres
        Stack<Character> stack = new Stack<>();

        // 1️⃣ Leer el archivo y llenar la pila
        try (FileReader reader = new FileReader(inputFile)) {
            int data;
            while ((data = reader.read()) != -1) { // -1 = fin de archivo
                stack.push((char) data);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // 2️⃣ Vaciar la pila en el archivo de salida (inverso)
        try (FileWriter writer = new FileWriter(outputFile)) {
            while (!stack.isEmpty()) {
                writer.write(stack.pop());
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        System.out.println("Archivo invertido correctamente en: " + outputFile);
    }
}