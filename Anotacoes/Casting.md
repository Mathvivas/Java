```java
class Veiculo {}
class Moto extends Veiculo {}
class Carro extends Veiculo {}

public class Casting {
    public static void main(String[] args) {
        Veiculo v = new Carro();
        Moto m = (Moto) v;  
        /*
            Compila, mas gera erro de execução.
            Compila, pois Carro e Moto herdam de Veiculo.
        */

        Carro c = new Carro();
        Moto m2 = (Moto) c;
        /*
            Não compila.
            O compilador sabe que essas duas classes não possuem ligação.
        */
    }
}
```

## Operador instanceof

- referência <strong> instaceof </strong> classe;
- Devolve <strong> true </strong> caso a referência aponte para um objeto compatível ao tipo classe.

```java
Object c = new Carro();
boolean b1 = c instanceof Carro;    // true
boolean b2 = c instanceof Moto;     // false
```

- O instanceof não compila se a referência em questão for obviamente incompatível.

```java
String s = "a";
boolean b = s instanceof java.util.List;    // Não Compila
```
