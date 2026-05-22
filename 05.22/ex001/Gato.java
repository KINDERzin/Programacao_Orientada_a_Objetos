package ex001;

class Gato extends Animal {
    @Override
    public void emitir_som() {
        System.out.println("miaaaaaaaaaaaaaaaaaaaauu");
    }

    public Gato() {
        emitir_som();
    }
}