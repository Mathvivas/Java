# Referência

- Duas referências são consideradas iguais somente se elas estão apontando para o mesmo objeto. Mesmo que os objetos que elas apontem sejam iguais, ainda são referências para objetos diferentes.

<br>

 ```java
Objeto a = new Objeto();
a.valor = 5;
// a não é um objeto, a referencia um objeto

Objeto b = new Objeto();
b.valor = 5;

Objeto c = a;

System.out.println(a == b); // false
System.out.println(a == c); // true
```
<br>

 ```java
Class B {
    int v = 15;
}

Class A {
    public static void main(String[] args) {
        B x = new B();
        B y = x; // y e x -> referência do mesmo valor
        y.v++;  // 16
        x.v++;  // 17
        B z = y;
        z.v--;  // 16

        System.out.println(x.v + y.v + z.v); 
        // 16 + 16 + 16 = 48
    }
}
  ```

<br>

 ```java
for ( int i = 0; i < 10; i++ ) {
    Carro c = new Carro();
}
/*
    Criando 10 carros dentro do for
    A variável c é local, só existe dentro do for
    10 carros que não serão utilizados
*/

Carro c2;
for ( int i = 0; i < 10; i++ ) {
    c2 = new Carro();
}

/*
    Variável c2 existe fora do for
    c2 referencia um Carro diferente a cada iteração
    Somente o último Carro será utilizado
*/
  ```

  ______

```java
class Prova {
    int tempo;
}

public class TestaReferenciaEPrimitivo {
    public static void main(String[] args) {
        Prova prova = new Prova();
        prova.tempo = 100;
        teste(prova);
        System.out.println(prova.tempo);    // 210

        teste2(prova);
        System.out.println(prova.tempo);    // 210
    }

    static void teste(Prova prova) {
        // Não foi criado um novo Objeto
        prova.tempo = 210;
    }

    static void teste2(Prova prova) {
        // Criação de um novo Objeto
        prova = new Prova();
        prova.tempo = 520;
    }
}
```