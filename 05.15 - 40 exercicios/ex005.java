import java.util.Scanner;

public class ex005 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      Integer lado;
      Integer base;
      Integer altura;
      Double raio;

      System.out.println("Digite o lado do quadrado:");
      lado = leitor.nextInt();

      System.out.println("Digite a base do triângulo:");
      base = leitor.nextInt();

      System.out.println("Digite a altura do triângulo:");
      altura = leitor.nextInt();

      System.out.println("Digite o raio do círculo:");
      raio = leitor.nextDouble();

      Integer areaQuadrado = lado * lado;
      Double areaTriangulo = (base * altura) / 2.0;
      Double areaCirculo = Math.PI * Math.pow(raio, 2);

      System.out.println("A área do quadrado é: " + areaQuadrado);
      System.out.println("A área do triângulo é: " + areaTriangulo);
      System.out.println("A área do círculo é: " + areaCirculo);

      leitor.close();
   }
}
