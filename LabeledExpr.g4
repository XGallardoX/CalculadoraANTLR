grammar LabeledExpr;

// Definición de reglas
stat: expr NEWLINE?             // Una expresión opcionalmente seguida de un salto de línea
    | ID '=' expr NEWLINE?      // Una asignación opcionalmente seguida de un salto de línea
    | NEWLINE?                  // Un salto de línea opcional
    ;
    
expr: expr op=('*'|'/') expr     // multiplicación o división
    | expr op=('+'|'-') expr     // suma o resta
    | expr op='^' expr           // potenciación
    | ABS '(' expr ')'           // valor absoluto
    | FLOAT                      // Un número flotante
    | INT                        // Un número entero
    | ID                         // Un identificador
    | '(' expr ')'               // Una expresión entre paréntesis
    ;

// Definición de tokens
MUL : '*' ;        // Operador de multiplicación
DIV : '/' ;        // Operador de división
ADD : '+' ;        // Operador de suma
SUB : '-' ;        // Operador de resta
POW : '^' ;        // Operador de potenciación
ABS : 'abs' ;      // Palabra clave para valor absoluto

NEWLINE : [\r\n]+ ; // Saltos de línea
ID : [a-zA-Z]+ ;   // Identificadores
FLOAT : [0-9]* '.' [0-9]+ ; // Números flotantes
INT : [0-9]+ ;     // Números enteros
WS : [ \t]+ -> skip ; // Espacios y tabulaciones
