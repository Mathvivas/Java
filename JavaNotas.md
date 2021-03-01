## Compilador

- Programa que, a partir de um código fonte, cria um 
programa semanticamente equivalente, porém escrito em outra
linguagem, código aberto. Um compilador traduz um programa de 
uma linguagem textual para uma linguagem de máquina, específica
para um processador e sistema operacional.
Linguagem de programação de alto nível para uma linguagem 
de programação de baixo nível. 

## ByteCode

- É o código originado da compilação de programas Java.
O Bytecode é o programa interpretado e executado pela JVM.

## Máquina Virtual

- Software que simula uma máquina física e consegue executar vários programas, gerenciar processos, memórias e arquivos;
- Uma plataforma com recursos virtuais, sem dependência do hardware.

## Java Virtual Machine

- Máquina virtual que executa programas Java, executando os bytecodes em linguagem de máquina para cada SO;
- Não é necessário compilar o código para cada SO.

## Java Runtime Environment (JRE)

- Parte responsável pela execução do software Java;
- É composto pela JVM, bibliotecas e APIs da linguagem Java e outros componentes para suporte da plataforma Java.

## Java Development Kit (JDK)

- É um conjunto de utilitários que permitem criar softwares para a plataforma Java;
- É composto pelo compilador Java, bibliotecas da linguagem, ferramentas e a JRE.

## Java Standard Edition (SE)

- É a distribuição mínima da plataforma de desenvolvimennto de aplicações Java.

## Java Enterprise Edition (EE)

- Extensão do SE.

__________

byte --> 8 bits
byte b = 127 --> máximo 127, não cabe mais

int --> 32 bits

long --> 64 bits
long l = 20000L --> Precisa do 'l' no final

float --> 32 bits

double --> 64 bits

__________

## Contas

- Toda conta devolve no mínimo um int.

```
byte b1 = 2;
byte b2 = 5;
byte b3 = b1 + b2;
// Causa erro, não compila
// Correção: int b3 = b1 + b2;
```
__________


## Public

- Pode ser acessada de qualquer lugar por qualquer entidade que possa visualizar a classe a que ela 
pertence.

## Private

- Os métodos e atributos da classe definidos como privados não podem ser acessados ou usados por nenhuma outa classe. Esses atributos e métodos também não podem ser visualizados pelas classes herdadas.

## Protected

- Torna o membro acessível às classes do mesmo pacote ou através de herança, seus membros herdados não
são acessíveis a outras classes fora do pacote em que foram declaradas.


__________


## Abstract

- Esse modificador não é aplicado nas variáveis, apenas nas classes e métodos. Uma classe abstrata não 
pode ser instanciada. Se houver uma declaração de um método como abstract, a classe também deve ser 
marcada como abstract. Não é um objeto, é uma ideia, não possui um corpo.

## Static

- É usada para a criação de uma variável que poderá ser acessada por todas as instâncias de objetos desta 
classe como uma variável comum, ou seja, a variável criada será a mesma em todas as instâncias e quando
seu conteúdo é modificado numa das instâncias, a modificação ocorre em todas as demais. E nas declarações
de metódos ajudam no acesso direto à classee, portanto não é necessário instanciar um objeto para acessar
o método.
O método static pertence a classe e não a instância.

```java
class Moto {
    /* 
        variável que pertence a classe, e não somente dos
        objetos que serão criados
    */
    public static int totalDeMotos = 0;
}

public class TestaStatic {
    public static void main(String[] args) {
        Moto.totalDeMotos = 15; // Acessado diretamente pela Classe
        System.out.println(Moto.totalDeMotos);
    }
}
```
- Não tem necessidade de utilizar: <s> Moto moto = new Moto() </s>

## Final

- Quando é aplicado na classe, não permite estender, nos métodos impede que o mesmo seja sobrescrito 
(overriding) na subclasse, e nos valores de variáveis não pode ser alterado depois que já tenha sido
atribuído um valor.

__________

## Enums

- Basicamente, são dicionários de dados imutáveis;
Não é permitido criar novas instâncias;
O construtor é sempre declarado como private;
Por convenção, por serem objetos constantes e imutáveis (static final), os nomes são em MAIÚSCULO.

__________


## Tipagem Estática

- Esta verificação é feita no código fonte pelo processo de compilação.

## Tipagem Dinâmica

- Esta verificação é feita em tempo de execução.
