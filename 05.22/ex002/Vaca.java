package ex002;

class Vaca extends Animal {
    @Override
    public void emitir_som() {
        System.out.println("Muuuuuuuuuuuuuuhhh");
    }

    public Vaca() {
        emitir_som();
    }
}