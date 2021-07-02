## Single Responsability Principle

- Uma classe deve ter um, e somente um, motivo para mudar;
- A classe deve possuir *uma única responsabilidade* dentro do software.


## Open Closed Principle

- Você deve poder estender um comportamento de class, sem modificá-lo;
- Objetos devem estar *abertos para extensão*, mas *fechados para modificação*;
- Quando novos comportamntos precisam ser adicionados no software, devemos estender 
e não alterar o código fonte original.


## Liskov Substitution Principle

- Classes derivadas devem ser substiutíveis por suas classes base;
- "Se para cada objeto o1 do tipo S há um objeto o2 so tipo T de forma que, para 
todos os programas P, o comportamento de P é inalterado quando o1 é substituído
por o2, então S é um subtipo de T."


## Segregation Principle

- Faça interfaces refinadas que são específicas do cliente;
- Uma classe não deve ser forçada a implementar interfaces e métodos que não serão utilizadas;
- É melhor criar interfaces mais específicas ao invés de termos uma única interface genérica.


## Dependency Inversion Principle

- Dependa de abstrações e não de implementações;
- Um módulo de alto nível não deve depender de módulos de baixo nível, ambos devem depender da
abstração;
- Inversão de Dependência não é igual a injeção de Dependência. 
