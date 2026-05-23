import java.util.Scanner;

class Calculadora
{
    public int Somar(int x, int y)
    {
        return x + y;
    }
    public int Subtrair(int x, int y)
    {
        return x - y;
    }
    public int Dividir(int x, int y)
    {
        return x / y;
    }
    public int Multiplicar(int x, int y)
    {
        return x * y;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        int parametro;
        int resultado = 0;
        int x;
        int y;

        System.out.println("=== CALCULADORA ===");
        
        // Número 1
        System.out.println("Insira um numero: ");
        x = leitor.nextInt();
        // Número 2
        System.out.println("Insira outro numero: ");
        y = leitor.nextInt();

        parametro = leitor.nextInt();

        switch(parametro)
        {
            case 0:
                return;

            case 1:
                resultado = calculadora.Somar(x, y);
                break;

            case 2:
                resultado = calculadora.Subtrair(x, y);
                break;

            case 3:
                resultado = calculadora.Dividir(x, y);
                break;

            case 4:
                resultado = calculadora.Multiplicar(x, y);
                break;

        }
        
        System.out.println("O resultado é: " + resultado);
    }
}