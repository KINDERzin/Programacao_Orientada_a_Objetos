class main
{
    public static void main(String[] args)
    {
        int idade = 10;
        String faixa;

        if(idade < 0)
        {
            System.out.println("Idade invalida!");    
            // Encerra a execução da função
            return;
        }

        if(idade < 13)
            faixa = "Crianca";
        else if( idade < 18)
            faixa = "Adolescente";
        else if( idade < 60)
            faixa = "Adulto";
        else
            faixa = "Idoso";

        System.out.println(faixa);
    }
}