# Exemplos de Herança

## Pacote a

```java
package a;
import b.*;

public class A extends B {
    protected int a(String s) {
        return 2;
    }
}
```

## Pacote b

```java
package b;
import a.*;

public class B {
    public int a(Object s) {
        return 1;
    }
}
```

## Principal

```java
import a.*;
import b.*;

class C {
    public static void main(String[] args) {
        System.out.println(new A().a("a"));
    }
}
```

- A <strong> main </strong> chama o método "a" da Classe A, mas esse método é protected, ou seja, somente quem está no mesmo pacote ou que herda de A, pode usar o método. Como a main não tem acesso, ela chama o método "a" da Classe B, que está sendo herdada pela Classe A. Como resultado, imprime 1.

______

```java
class Pai {
    Pai(int x) {}
}

public class Filho extends Pai {
    /*
        Não compila, pois o construtor padrão chama super(), 
        e o Pai não tem construtor vazio (padrão).
    */
}

public class Filho2 extends Pai {
    Filho2() {
        super(15);      // Compila.
    }
}
```

- Uma classe <strong> final </strong> pode herdar, mas não pode ser herdada.

- Todos os métodos e atributos de uma classe mãe são herdados, independente das visibilidades.