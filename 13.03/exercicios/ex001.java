import java.util.Scanner;

class main
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);
        
        int x = 0;
        int y = 0;
        int soma = x + y;

        // Numero 1
        System.out.println("Insira um valor: ");
        x = leitor.nextInt();
        // Numero 2
        System.out.println("Insira outro valor: ");
        y = leitor.nextInt();
        
        // Mostra o valor da soma
        System.out.println("Valor da soma: " + soma);
    }
}