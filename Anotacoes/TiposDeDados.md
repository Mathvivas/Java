## char

- Compatível com tipo número;
- Possui somente números positivos, começando no zero;
- char c = 'A';
- char c = 65.

## Valores Literais

- Números inteiros são int por padrão;
- Números de ponto flutuante são double por padrão;
- Forçar long: 13L ou 13l;
- Forçar float: 13.1F ou 13.1f.

## Base Octal

- 0 .. 7;
- 0761 não representa 761, representa 497;
- 08 não existe --> Erro.
- 09 não existe --> Erro.

## Base Hexadecimal

- 0, .. 9, A, .. F;
- Representado por 0x ou 0X;
- 0xA representa 10.

## Base Binária

- 0 ou 1;
- Representado por 0b ou 0B;
- 0b100 representa 4.

## Notação Científica

- 3.1E2 ou 3.1e2 representa 3.1 * 10² = 310.0.

## Tabela Unicode

- Representado por '\u';
- '\u03A9' representa a letra omega.

## Wrappers

```java
// Devolve Primitivo
int i0 = Interger.parseInt("10", 10);
int i1 = Interger.parseInt("11", 16);
int i2 = Interger.parseInt("A", 16);
long l = Long.parseLong("11", 2);
String s = Integer.toString(123, 10);

// Primitivo --> Wrapper
Integer intWrapper = Integer.valueOf(1);
// Wrapper --> Primitivo
int intPrimitivo = intWrapper.intValue();
```

## Formatação

- System.out.print não possui versão sem argumentos;

- System.out.format;
- System.out.printf.

```java
System.out.format("String: %s %n Número: %d %n Número: %f", "oi", 45, 37.8);

// n$ -> Seleciona qual será printado primeiro.
System.out.format("%2$s, %1$s", "World", "Hello");
// Hello, World
System.out.format("%2$s, %2$s", "World", "Hello");
// Hello, Hello

// Número de casas
System.out.format("%5d", 42);

// Alinhamento na esquerda
System.out.format("%-5d", 42);

System.out.format("%.2f", 43.75);
```