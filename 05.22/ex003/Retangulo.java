package ex003;

public class Retangulo  extends FormaGeometrica{
   private Double base;
   private Double altura;

   public Retangulo(Double b, Double h) {
      this.altura = h;
      this.base = b;

      calcular_area();
   }

   @Override
   public void calcular_area() {
      Double area = base * altura;
      System.out.println("Area do retangulo: " + area);
   }
}
