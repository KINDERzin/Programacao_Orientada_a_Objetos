package ex003;

public class Triangulo extends FormaGeometrica{
   private Double base;
   private Double altura;

   public Triangulo(Double b, Double h) {
      this.altura = h;
      this.base = b;

      calcular_area();
   }
   @Override
   public void calcular_area() {
      Double area = (base * altura) / 2;
      System.out.println("Area do triangulo: " + area);
   }
}
