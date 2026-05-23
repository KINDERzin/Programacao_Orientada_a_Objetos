import java.util.Scanner;

class ContaBancaria
{
    double saldo = 0;

    public void Depositar(double valor)
    {
        saldo+=valor;
    }

    public void Sacar(double valor)
    {
        saldo-=valor;
    }

    public double ExibirSaldo()
    {
        return saldo;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();
        int operacao;
        int valor;

        do
        {

            operacao = leitor.nextInt();

            switch(operacao)
            {
                case 0: 
                    System.out.println("Encerrando...");
                    return;

                case 1: 
                    System.out.println(conta.ExibirSaldo());
                    break;

                case 2:
                    System.out.append("Insira o valor a ser depositado: ");
                    valor = leitor.nextInt();
                    conta.Depositar(valor);
                    break;
                    
                case 3:
                    System.out.append("Insira o valor a ser sacado: ");
                    valor = leitor.nextInt();
                    conta.Sacar(valor);
                    break;
            }
        } while (operacao != 0);

    }
}