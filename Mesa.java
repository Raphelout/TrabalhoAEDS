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
        System.out.println("A mesa é para quantas pessoas? [1:6]");
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

    void pedir(){
        if (this.reserva) {

            int esc;
            do {

                System.out.println("\nCardápio");
                System.out.println("    [1] - Canja de tatu vegetariana.............R$10,00");
                System.out.println("    [2] - PF (prato feito)......................R$15,00");
                System.out.println("    [3] - PQF (prato quase feito)...............R$14,99");
                System.out.println("    [4] - Suco do bandeco (sabor vermelho)......R$3,05");
                System.out.println("    [5] - Suco do bandeco (sabor roxo)..........R$3,00");
                System.out.println("    [6] - Água não saborizada...................R$6,00");
                System.out.println("[0] Finalizar pedido");
                
                //Pega o codigo do pedido
                esc = leitor.nextInt();
                leitor.nextLine();

                if (esc != 0 ){

                    //Adiciona pedido na lista de pedidos
                    mesaComanda.codigoPedidos.add(esc);
                    System.out.println("\nPedido " + esc + " do valor de " + mesaComanda.precoPedidos.get(esc - 1) + " adicionado à comanda");
                
                    //Pega o valor do último pedido feito e adiciona ao valor da comanda
                    mesaComanda.setValor(mesaComanda.getValor() + mesaComanda.precoPedidos.get(esc - 1));
                    System.out.printf("Valor atual da comanda: " + "%.2f\n", mesaComanda.getValor());
                }
                  
            } while(esc != 0);
       
        } else {
            System.out.println("Essa mesa não está reservada");
        }
    }

    public void pagar(){ 
        
        // voce quer racha isso dai? 
        // printiefa pagamento efetuado
        // retira mesa da lista 

        if (this.reserva){
            // mostra a comanda toda
            mesaComanda.listarConsumo();

            //Acrescentar 10% ao valor total (gorjeta)
            System.out.print("Se você deseja pagar a gorjeta(10%), digite 1: ");
            int esc = leitor.nextInt();
            leitor.nextLine();   
            if (esc == 1){
                mesaComanda.setValor(mesaComanda.getValor() + mesaComanda.calcular10porcento());
                System.out.printf("Valor atualizado: R$%.2f\n", mesaComanda.getValor());
            }

            System.out.printf("Você gostaria de doar %.2f centavos para as crianças com câncer do Hospital Humberto Honda? Se sim, digite 1: ", mesaComanda.calcularSobra());
            esc = leitor.nextInt();
            leitor.nextLine();
            if (esc == 1){
                mesaComanda.setValor(mesaComanda.getValor() + mesaComanda.calcularSobra());
                System.out.printf("Valor atualizado: R$%.2f\n", mesaComanda.getValor());
            }
            if (clientes.length > 1){
                
                System.out.println("Se as pessoas da mesa gostariam de dividir a conta, digite 1");
                esc = leitor.nextInt();
                leitor.nextLine();
                if (esc == 1){
                    System.out.println("Quantas pessoas vão dividir a conta?");
                    int num = leitor.nextInt();
                    leitor.nextLine();
                    mesaComanda.dividirConta(mesaComanda.getValor(), num);
                    System.out.printf("Valor atualizado: R$%.2f\n", mesaComanda.getValor());
                }
            }

        } else{
            System.out.println("Essa mesa não está reservada");
        }

    }

}