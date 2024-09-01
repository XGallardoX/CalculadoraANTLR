Juan Gallardo
Juan Joya
Jefferson Gutiérrez

# Calculadora ANTLR

Este proyecto contiene una calculadora simple construida usando ANTLR para el análisis de expresiones matemáticas. La calculadora soporta operaciones básicas como suma, resta, multiplicación, división, potenciación y el cálculo del valor absoluto, además de poder ingresar numeros por archivos .txt y por consola.

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
   *Descripción:* Intento de dividir un número entre cero. La calculadora debería manejar este caso y mostrar un mensaje de error.

5. *Expresión:* 3 * 3  
   *Resultado esperado:* 9  
   *Descripción:* Multiplicación de dos números enteros.

6. *Expresión:* 3 ^ 3  
   *Resultado esperado:* 27  
   *Descripción:* Potenciación de dos números enteros (3 elevado a la potencia 3).

7. *Expresión:* abs(-3 + 7)  
   *Resultado esperado:* 4  
   *Descripción:* Cálculo del valor absoluto de la expresión -3 + 7, que resulta en 4.

8. *Expresión:* 2.5 - 1.5  
   *Resultado esperado:* 1.0  
   *Descripción:* Resta de dos números flotantes.

9. *Expresión:* 2.4 / 1.3  
   *Resultado esperado:* 1.8461538461538463  
   *Descripción:* División de dos números flotantes. El resultado puede variar ligeramente debido a la precisión del cálculo de los números flotantes.

10. *Expresión:* 3.7 * 4.2  
    *Resultado esperado:* 15.54  
    *Descripción:* Multiplicación de dos números flotantes.

