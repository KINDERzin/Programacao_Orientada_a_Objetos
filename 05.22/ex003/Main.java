package ex003;

import java.util.Scanner;
public class Main {
   public static void main(String[] args) {
      FormaGeometrica[] formas = new FormaGeometrica[3];
      Scanner leitor = new Scanner(System.in);

      System.out.println("Digite a base do triângulo: ");
      Double b_t = leitor.nextDouble();
      System.out.println("Digite a altura do triângulo: ");
      Double h_t = leitor.nextDouble();
      formas[0] = new Triangulo(b_t, h_t);
      
      System.out.println("Digite a base do retangulo: ");
      Double b_r = leitor.nextDouble();
      System.out.println("Digite a altura do triângulo: ");
      Double h_r = leitor.nextDouble();
      formas[1] = new Retangulo(b_r, h_r);
   
      System.out.println("Digite o raio do círculo: ");
      Double r_c = leitor.nextDouble();
      formas[2] = new Circulo(r_c);

      for(int i = 0; i < 3; i++)
         formas[i].calcular_area();
   }
}
