package ex003;

public class Circulo extends FormaGeometrica{
   private Double raio;

   public Circulo (Double r) {
      this.raio = r;
   }
   
   @Override
   public void calcular_area() {
      Double area = Math.pow(raio, 2) * Math.PI;
      System.out.println("Area do círculo: " + area);
   }
}
