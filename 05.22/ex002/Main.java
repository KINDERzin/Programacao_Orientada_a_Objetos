package ex002;

import ex002.Animal;
import ex002.Cachorro;
import ex002.Gato;
import ex002.Vaca;

class Main{
    public static void main(String[] args) {
        Animal[] animais = new Animal[3];

        animais[0] = new Cachorro();
        animais[1] = new Gato();
        animais[2] = new Vaca();

        for(int i = 0; i < 3; i++)
            animais[i].emitir_som();
    }
}