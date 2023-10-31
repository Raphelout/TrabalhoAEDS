////////////////////////////////////////////////////////////////////////
// Dupla: Raphael Inácio Bicalho de Carvalho e Luka Guimarães Fantini //
// Mesa.java                                                          //
////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Mesa {
    
    //Atributos
    private int numeroMesa;
    private String data;
    private boolean reserva;
    public Cliente[] clientes;
    public Comanda mesaComanda = new Comanda();
    //Scanner
    Scanner leitor = new Scanner(System.in);

    //Setters
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public void setData(String data) {
        this.data = data;
    }

    //Getters
    public int getNumeroMesa() {
        return numeroMesa;
    }
    public String getData() {
        return data;
    }
    public boolean getReserva(){
        return reserva;
    }

    //Reservar
    public boolean reservar(){
        System.out.println("A mesa é para quantas clientes? [1:6]");
        clientes = new Cliente[leitor.nextInt()]; //cria uma array de clientes dentro da mesa sendo reservada com o numero de clientes q o user informar
        leitor.nextLine();
        for (int i = 0; i < clientes.length; i++){
            clientes[i] = new Cliente();
        }

        System.out.println("Quer reservar pra quando?");
        this.data = leitor.nextLine();

        System.out.println("\nPARA O/A/Ê REPRESENTANTE DA RESERVA");
        System.out.print("Por favor, informe o seu nome, senhor(a/e): ");
        clientes[0].setNome(leitor.nextLine());

        System.out.print("Em seguida, o email para contato: ");
        clientes[0].setEmail(leitor.nextLine());
        System.out.println("MESA RESERVADA COM SUCESSO (0)");
        this.reserva = true;
        return true;
    }

    //Cancelar reserva
    public boolean cancelar(){
        this.reserva = false;
        clientes = new Cliente[0];
        return false;
    }

    void pedidoM(){
        if (this.reserva) {

            do {
                System.out.println("\nCardápio");
                System.out.println("    [1] - Canja de tatu vegetariana.............R$10,00");
                System.out.println("    [2] - PF (prato feito)......................R$15,00");
                System.out.println("    [3] - PQF (prato quase feito)...............R$14,99");
                System.out.println("    [4] - Suco do bandeco (sabor vermelho)......R$3,05");
                System.out.println("    [5] - Suco do bandeco (sabor roxo)..........R$3,00");
                System.out.println("    [6] - Água não saborizada...................R$6,00");
                System.out.println("[0] Finalizar pedido");
                int esc = leitor.nextInt();
                leitor.nextLine();
                System.out.println();

                //pega o valor do ultimo pedido feito e adiciona ao valor da comanda
                mesaComanda.setValor(mesaComanda.getValor() + mesaComanda.precoPedidos.get(mesaComanda.precoPedidos.size() - 1));
                System.out.println("valor atual da comanda: " + mesaComanda.getValor());

            } while(esc != 0);

            
            
        } else {
            System.out.println("Essa mesa não está reservada");
        }
    }

}