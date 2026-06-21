import java.util.Scanner;

public class ex004 {
   public static void main(String[] args){
      Double temperaturaCelsius;
      Scanner leitor = new Scanner(System.in);

      System.out.println("Digite a temperatura em Celsius:");
      temperaturaCelsius = leitor.nextDouble();

      Double temperaturaFahrenheit = (temperaturaCelsius * 1.8) + 32;
   
      System.out.println("A temperatura em Fahrenheit é: " + temperaturaFahrenheit);
      
      leitor.close();
   }
}