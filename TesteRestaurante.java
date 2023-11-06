////////////////////////////////////////////////////////////////////////
// Dupla: Raphael Inácio Bicalho de Carvalho e Luka Guimarães Fantini //
// TesteRestaurante.java (MAIN)                                       //
////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class TesteRestaurante {
    public static void main(String[] args) {

        //Scanner
        Scanner leitor = new Scanner(System.in);
        
        //Cria restaurante
        Restaurante r1 = new Restaurante("Buchinho Cheio", "Rua Infoslindos, 203, Coltecufmg", 10);
        
        //Dá boas vindas
        r1.recepcao();

        //Fecha leitor :(
        //tudo na vida tem um fim,
        leitor.close();
        //assim como o leitor.
    }
}