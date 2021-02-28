# Referência

- Duas referências são consideradas iguais somente se elas estão apontando para o mesmo objeto. Mesmo que os objetos que elas apontem sejam iguais, ainda são referências para objetos diferentes.

<br>

 ```java
Objeto a = new Objeto();
a.valor = 5;

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