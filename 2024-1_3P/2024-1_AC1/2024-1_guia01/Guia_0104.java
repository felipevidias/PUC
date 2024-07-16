// 03/02/2024   817294_Felipe_Vilhena_Dias   Guia_01

import java.util.Scanner;

public class ConversorBaseIterativo
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número binário: ");
        String numeroBinario = scanner.nextLine();

        // Convertendo para base 4
        String numeroBase4 = binarioParaBaseIterativo(numeroBinario, 4);
        System.out.println("Número em base 4: " + numeroBase4);

        // Convertendo para base 8
        String numeroBase8 = binarioParaBaseIterativo(numeroBinario, 8);
        System.out.println("Número em base 8: " + numeroBase8);

        // Convertendo para base 16
        String numeroBase16 = binarioParaBaseIterativo(numeroBinario, 16);
        System.out.println("Número em base 16: " + numeroBase16);
    }

    // Método para converter um número binário para outra base de forma iterativa
    public static String binarioParaBaseIterativo(String binario, int base)
    {
        StringBuilder resultado = new StringBuilder();
        int tamanho = binario.length();

        for (int i = 0; i < tamanho; i += Math.log(base) / Math.log(2))
        {
            // Pegando um bloco de bits do tamanho da base
            String bloco = binario.substring(i, Math.min(i + (int) (Math.log(base) / Math.log(2)), tamanho));

            // Convertendo o bloco para decimal
            int decimal = Integer.parseInt(bloco, 2);

            // Convertendo o decimal para a base desejada
            resultado.insert(0, Integer.toString(decimal, base));
        }

        return resultado.toString();
    }
}
