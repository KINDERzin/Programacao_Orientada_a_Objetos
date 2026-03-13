import java.util.Scanner;

class main
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        int vetor[] = new int[5];
        int soma = 0;

        // Laço de repetição irá preencher
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Insira um numero: " + (i+1) + " de 5");
            // Lê a entrada do tipo int
            vetor[i] = leitor.nextInt();
        }
        // Preenche manualmente
        // vetor[0] = 1;
        // vetor[1] = 2;
        // vetor[2] = 3;
        // vetor[3] = 4;
        // vetor[4] = 5;

        // Vetor na posição i incrementa na soma
        for(int i = 0; i < 5; i++)
            soma+=vetor[i];

        System.out.println("Resultado: " + soma);
    }
}