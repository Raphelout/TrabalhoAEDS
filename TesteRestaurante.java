import java.util.Scanner;

public class TesteRestaurante {
    public static void main(String[] args) {

        //Scanner
        Scanner leitor = new Scanner(System.in);
        
        //Cria restaurante
        Restaurante r1 = new Restaurante("Buchinho Cheio", "Rua Infoslindos, 203, Coltecufmg", 10);

        System.out.print("Bem vindo ao Restaurante " + r1.getNome());
        

        while (true){
            System.out.println("Digite o que quer fazer");
            
            // reservar
            // listar reservas
            // cancelar reserva
            // fazer pedido
            // pagar pedido
            // sair

            
        }

    }
}