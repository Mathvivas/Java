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

<br>

<br>

# Switch

```java
for ( int i = 0; i < 4; i++ ) {
    switch (i) {
        case 0:
        case 1:
            System.out.println("Caso " + i);
            break;
        case 2:
            System.out.println("Legal, " + i);
            continue;
        case 3:
            System.out.println("Cheguei no 3");
            break;
        default:
            System.out.println("Estranho...");
            break;
    }
    System.out.println("Fora do switch");
}
```

- Ao utilizar o break, quebra (sai) do switch e imprime o "Fora do switch";

- Ao utilizar o continue, volta para o for, sem passar pelo que está depois.