import java.util.Scanner;

public class somaDoisNumeros
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x,  y,  soma;

        System.out.print("Digite um numero: ");
        x = sc.nextInt();
        System.out.print("Digite outro numero: ");
        y = sc.nextInt();
        soma = x + y;
        System.out.println("Soma: " + soma);

        sc.close();
    } // end Main
} // end class 