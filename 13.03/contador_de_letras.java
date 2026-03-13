import java.util.Scanner;

class main
{
    public static void main(String[] args) 
    {
        Scanner leitor = new Scanner(System.in);

        String palavra;
        int tamanho_palavra;

        System.out.println("Digite uma palavra: ");
        palavra = leitor.nextLine();

        tamanho_palavra = palavra.length();

        System.out.println("A palavra " + palavra + " tem " + tamanho_palavra + " letras");
    }
}