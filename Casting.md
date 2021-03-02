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