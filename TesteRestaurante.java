import java.util.Scanner;

public class TesteRestaurante {
    public static void main(String[] args) {

        //Scanner
        Scanner leitor = new Scanner(System.in);
        
        //Cria restaurante
        Restaurante r1 = new Restaurante("Buchinho Cheio", "Rua Infoslindos, 203, Coltecufmg", 10);

        //Dá boas vindas
        System.out.print("Bem vindo ao Restaurante " + r1.getNome());
        r1.menuRestaurante();

    }
}