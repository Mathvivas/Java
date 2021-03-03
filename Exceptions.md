## Try & Catch

```java
try {
    // trecho que pode gerar um erro na execução.
} catch (Throwable t) { // pegando todos os possíveis erros de 
                        //execução.
    // tratamento para o possível erro de execução.
}

try {
    // trecho que pode gerar um erro na execução.
} catch (Exception e) { // pegando todas as exceptions.
    // tratamento para o possível erro de execução.
}

try {
    System.out.println("Ok");
} catch (RuntimeException e) { // pegando RuntimeException 
                               // (unckecked).
    // tratamento.
}
```

_______

## Finally

- O bloco finally é sempre executado, tanto no sucesso quanto no fracasso por qualquer tipo de erro.

```java
void metodo(){
    try {
        abreConexao();
        fazConsultas(); // Não precisa mais fechar a conexao 
                        // aqui.
    } catch(SQLException e) {
        // tratamento
    } finally {
        fechaConexao(); // fechando a conexao no sucesso ou no
                        // fracasso.
    }
}
```
_______

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

## Tratando mais de uma Exception

```java
class TestaTrataException {
    public static void metodo() {
        try {
            new Conta().saca(500);
        } catch(NullPointerException ex) {
            System.out.println("Tratei nullPointer");
        } catch(SaldoInsuficienteException ex) {
            System.out.println("Tratei saldo insuficiente");
        }
    }

    public static void main(String args[]) {
        metodo();
    }
}
```