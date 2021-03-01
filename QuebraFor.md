# Tabuada

- Quando o valor da tabuada for 5 * 5 = 25, o loop interno quebra e continua no valor 6.

```java
for ( int i = 1; i < 10; i++ ) {
    for ( int j = 1; j < 10; j++ ) {
        if ( i * j == 25 ) break;
        System.out.println(i + " * " + j + " = " + (i * j));
    }
}
```

- Podemos dar nomes para loops, fazendo com que o break quebre o loop externo.

```java
externo: for ( int i = 1; i < 10; i++ ) {
    for ( int j = 1; j < 10; j++ ) {
        if ( i * j == 25 ) break externo;
        System.out.println(i + " * " + j + " = " + (i * j));
    }
}
```