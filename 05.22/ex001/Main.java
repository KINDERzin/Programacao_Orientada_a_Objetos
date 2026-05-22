package ex001;

import ex001.Cachorro;
import ex001.Gato;
import ex001.Vaca;
class Main{
    public static void main(String[] args) {
        System.out.println("O que o dog faz?");
        Cachorro dog = new Cachorro();
        System.out.println("O que o gato faz?");
        Gato gato = new Gato();
        System.out.println("O que a vaca faz?");
        Vaca vaca = new Vaca();
    }
}