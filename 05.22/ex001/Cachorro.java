package ex001;

class Cachorro extends Animal {
    @Override
    public void emitir_som() {
        System.out.println("Auauauauauauauauauauauauuauauu");
    }
    public Cachorro() {
        emitir_som();
    }
}