import java.util.Scanner;

class main
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);

        int x = 0;
        int y = 0;
        
        System.out.println("Insira um numero: ");
        x = leitor.nextInt();
        
        System.out.println("Insira outro numero: ");
        y = leitor.nextInt();

        System.out.println("Soma: " + (x + y));
        System.out.println("Subtração: " + (x - y));
        System.out.println("Multiplicação: " + (x * y));
        System.out.println("Divisão: " + (x / y));


    }
}