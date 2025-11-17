## Su nombre y carné.

**Nombre:** José Alexis Sandí Guillén
**Carné:** FI24041192

## El IDE o editor utilizado.

Visual Studio Code

## Páginas web donde halló posibles soluciones a problemas encontrados o Snippets de código.

https://stackoverflow.com/  
https://docs.oracle.com/en/java/

## Prompts (consultas y respuestas) de los chatbots de IA (Copilot, Gemini, ChatGPT, etc.) que haya utilizado.

**Prompts utilizados con ChatGPT**

"Necesito implementar un arbol binario ordenado usando un arreglo fijo en Java y no puedo usar recursividad para el insert, ni agregar nuevos atributos, ni modificar el main. Me puedes explicar cómo hacer un insert iterativo usando únicamente las fórmulas 2i+1 y 2i+2?"

**Respuesta del chatbot:**

"Claro. Para realizar un insert iterativo en un árbol binario representado con un arreglo fijo, debes comenzar desde la raíz (índice 0) y recorrer el árbol comparando el valor a insertar contra cada posición.
Si el valor es menor que el nodo actual, debes moverte al hijo izquierdo usando la fórmula 2*i + 1.
Si es mayor o igual, moverte al hijo derecho con 2*i + 2.
Cuando encuentres una posición donde el arreglo contenga null, allí insertas el nuevo valor.
Es importante validar que el índice no se pase del tamaño del arreglo y no usar recursividad, sino únicamente un ciclo while."