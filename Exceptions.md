```java
class Conta {
    double saldo = 100;
    // Diz que pode lançar uma exception do tipo
    void saca(double quantidade) throws java.io.IOException {
        if ( this.saldo < quantidade ) {
           throw new java.io.IOException("Saldo insuficiente " +  saldo + " para sacar " + quantidade);
        }
        saldo -= quantidade;
    }
}

class TestaTrataException {
    public static void metodo() {
        try {
            new Conta().saca(500);
        } catch(java.io.IOException ex) {
            System.out.println("Tratei no metodo");
        }
    }

    public static void main(String args[]) {
        metodo();
    }
}
```

## Criação de Exceptions

```java
// Herda de Exception --> Checked Exception
// Herda de RuntimeException --> Unchecked Exception
class SaldoInsuficienteException extends Exception {
    SaldoInsuficienteException(String msg) {
        super(msg);
    }
}

class Conta {
    double saldo = 100;
    // Diz que pode lançar uma exception do tipo
    void saca(double quantidade) throws SaldoInsuficienteException {
        if ( this.saldo < quantidade ) {
           throw new SaldoInsuficienteException("Saldo insuficiente " +  saldo + " para sacar " + quantidade);
        }
        saldo -= quantidade;
    }
}

class TestaTrataException {
    public static void metodo() {
        try {
            new Conta().saca(500);
        } catch(SaldoInsuficienteException ex) {
            System.out.println("Tratei no metodo");
        }
    }

    public static void main(String args[]) {
        metodo();
    }
}
```