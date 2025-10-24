# Práctica 3 - Implementación de Funciones Primitivas Recursivas

Este proyecto consiste en implementar un programa que calcule la función potencia(x, y) como una función primitiva recursiva: el programa recibe como argumentos una base y un exponente, a partir de los cuales calcula la potencia haciendo uso únicamente de funciones primitivas recursivas y de las operaciones de combinación, composición y recursión. La salida del programa consta de:

- El resultado de la operación.
- El número de llamadas a funciones que se han realizado.

## Estructura del repositorio

- `src/` - código fuente Java organizado por paquetes (núcleo, operaciones, utilidades, etc.).
- `bin/` - salida de compilación (generada por los scripts).
- `runProgram.sh` - script minimo que compila y lanza `prf.Main`, pasando todos los argumentos literales.

Principales clases:

- `prf.Main` - punto de entrada del programa.
- `prf.utils.ArgumentsParser` - parseador de argumentos de línea de comandos.
- `prf.core.PrimitiveFunction` - interfaz base que implementarán las funciones y las operaciones.
- `prf.core.AbstractPrimitiveFunction` - clase abstracta base de la que heredarán todas las funciones primitivas recursivas.
- `prf.core.PrimitiveOperation` - clase abstracta base de la que heredarán todas las operaciones.
- `prf.core.FunctionCallLogger` - clase estática que registra el número de llamadas a funciones primitivas recursivas.

## Requisitos

- Java JDK 11 o superior (recomendado). Algunas utilidades del código usan APIs disponibles a partir de Java 11 (por ejemplo `String.repeat`).
- bash (scripts de ejecución proporcionados).

## Compilar y Ejecutar

El proyecto se compila con `javac`. El script incluido invoca la compilación automáticamente, pero puedes compilar manualmente:

```bash
mkdir -p bin
javac -g -d bin $(find src -name "*.java")
```

La opción `-g` incluye símbolos de depuración (útil para depurar en VS Code).

Hay dos maneras sencillas de ejecutar:

1) Usando `runProgram.sh` para compilar y ejecutar, pasando los argumentos que necesites:

```bash
# ejemplos
./runProgram.sh -b 4 -e 6
```

2) Compilar manualmente y ejecutar java directamente:

```bash
# compilar
mkdir -p bin
javac -g -d bin $(find src -name "*.java")

# ejecutar (todos los args pasados después se envían a main)
java -cp bin prf.Main -b 4 -e 6
```

> **Nota:** `runProgram.sh` simplemente compila y ejecuta automáticamente la misma clase `prf.Main`, reenviando todos los parámetros que les pases.

## Uso del programa

El programa principal espera argumentos en este formato:

- `-b <base>`: Base de la potencia.
- `-e <exponent>`: Exponente de la potencia.

Ejemplo completo:

```bash
./runProgram.sh -b 4 -e 6
```

Si el parseador detecta `-h` imprimirá la ayuda y saldrá.