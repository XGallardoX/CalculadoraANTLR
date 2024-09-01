Juan Gallardo
Juan Joya
Jefferson Gutiérrez

# Calculadora ANTLR

Este proyecto contiene una calculadora simple construida usando ANTLR para el análisis de expresiones matemáticas. La calculadora soporta operaciones básicas como suma, resta, multiplicación, división, potenciación y el cálculo del valor absoluto, además de poder ingresar numeros por archivos .txt y por consola.

## Ejecución
Esta se desarrollo y probó en Linux. 

Para poder usar esta calculadora, debe tener instalado en su entorno de desarrollo ANTLR4, exactamente la version 4.13.2, con la que fue realizada esta misma, además debe tener instalado Java, en este caso la versión 21.0.3, y su respectivo compilador o maquina virtual, siendo requerida la versión openjdk 17 como mínimo.  

Una vez descargados los 3 archivos, mas el caso de prueba; debe abrir su terminal en la carpeta que los contiene, y ejecutar el comando: "antlr4 -no-listener -visitor LabeledExpr.g4", este comando se utiliza para generar código fuente a partir de una gramática escrita en ANTLR, Después de ejecutar este comando, ANTLR generará varios archivos de salida, incluyendo:

    Archivos de análisis léxico (LabeledExprLexer.java).
    Archivos de análisis sintáctico (LabeledExprParser.java).
    Archivos de visitante (LabeledExprBaseVisitor.java y LabeledExprVisitor.java).

-no-listener: Indica que no se deben generar las clases de listener. Los listeners permiten visitar nodos del árbol de análisis sintáctico basados en eventos, pero al usar esta opción, se evita su generación.
-visitor: Indica que se deben generar las clases de visitante. Los visitantes permiten recorrer y procesar el árbol de análisis de manera más flexible y controlada.
labeledexpr.g4: Es el archivo de gramática que define las reglas del lenguaje a analizar.

Luego, se debe ejecutar el comando: "javac *.java", este comando compila todos los archivos Java generados, dando como resultado los .class permitiendo la ejecución de la calculadora.

Finalmente, ejecutamos: "Java Calc" y podemos introducir cualquier expresión por consola, o, ejecutamos: "Java Calc prueba1.txt", que nos devuelve el resultado de la ejecución del txt como respuesta. 

## Casos de Prueba y Resultados Esperados

A continuación se presentan varios casos de prueba junto con sus resultados esperados. Estos casos de prueba cubren una variedad de operaciones y escenarios, incluyendo números enteros y flotantes, así como la división por cero.

### Casos de Prueba

1. *Expresión:* 1 + 2  
   *Resultado esperado:* 3  
   *Descripción:* Suma de dos números enteros.

2. *Expresión:* 5 - 3  
   *Resultado esperado:* 2  
   *Descripción:* Resta de dos números enteros.

3. *Expresión:* 4 / 2  
   *Resultado esperado:* 2  
   *Descripción:* División de dos números enteros.

4. *Expresión:* 5 / 0  
   *Resultado esperado:* Error: División por cero  
   *Descripción:* Intento de dividir un número entre cero.

5. *Expresión:* 3 * 3  
   *Resultado esperado:* 9  
   *Descripción:* Multiplicación de dos números enteros.

6. *Expresión:* 3 ^ 3  
   *Resultado esperado:* 27  
   *Descripción:* Potenciación de dos números enteros (3 elevado a la potencia 3).

7. *Expresión:* abs(-3 + 7)  
   *Resultado esperado:* 10  
   *Descripción:* Cálculo del valor absoluto de la expresión -3 + 7, que resulta en 10.

8. *Expresión:* 2.5 - 1.5  
   *Resultado esperado:* 1.0  
   *Descripción:* Resta de dos números flotantes.

9. *Expresión:* 2.4 / 1.3  
   *Resultado esperado:* 1.8461538461538463  
   *Descripción:* División de dos números flotantes. El resultado puede variar ligeramente debido a la precisión del cálculo de los números flotantes.

10. *Expresión:* 3.7 * 4.2  
    *Resultado esperado:* 15.54  
    *Descripción:* Multiplicación de dos números flotantes.

