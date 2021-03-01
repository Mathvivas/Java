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