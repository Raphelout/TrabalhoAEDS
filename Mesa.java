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

    //Reservar mesa
    public boolean reservar(){

        //Pede quantidade de pessoas para o usuário
        System.out.println("PREENCHA AS SEGUINTES INFORMAÇÕES");
        int qClientes;
        do {
            System.out.println("A mesa é para quantas pessoas? [1:6]");
            qClientes = leitor.nextInt();
            leitor.nextLine();
            if (qClientes > 6 || qClientes <= 0 ){
                System.out.println("Quantidade inválida de pessoas, tente novamente\n");
            }
        } while (qClientes > 6 || qClientes <= 0 );

        //Cria uma array de clientes dentro da mesa sendo reservada, de acordo com o número de clientes que o usuário informar
        clientes = new Cliente[qClientes];
        for (int i = 0; i < clientes.length; i++){
            clientes[i] = new Cliente();
        }

        //Pede data de reserva para o usuário
        System.out.println("Quer reservar a mesa para quando?");
        this.data = leitor.nextLine();

        //Pede informações sobre o representante da reserva
        System.out.println("\nPARA O/A/Ê REPRESENTANTE DA RESERVA");
        System.out.print("Por favor, informe o seu nome, senhor(a/e): ");
        clientes[0].setNome(leitor.nextLine());
        System.out.print("Em seguida, informe um email para contato: ");
        clientes[0].setEmail(leitor.nextLine());

        //Informa que mesa foi reservada
        System.out.println("\nMESA RESERVADA COM SUCESSO");
        this.reserva = true;
        return true;
    }

    //Cancelar reserva de mesa
    public boolean cancelar(){
        this.reserva = false;
        clientes = new Cliente[0];
        mesaComanda = new Comanda();
        return false;
    }

    //Menu de pedidos
    void pedir(){

        if (this.reserva) {
            int esc;
            do {
                System.out.println("\nCARDÁPIO");
                for (int i = 0; i < mesaComanda.nomePedidos.size(); i++){
                    System.out.printf("  [" + (i+1) + "] R$%.2f - " + mesaComanda.nomePedidos.get(i) + "\n", mesaComanda.precoPedidos.get(i));
                }
                System.out.println("[0] Finalizar pedido");
                
                //Pega o código do pedido
                esc = leitor.nextInt();
                leitor.nextLine();
                if (esc > 6 || esc < 0) {   
                    System.out.println("Essa opção não existe");
                    continue;
                }

                //Registra pedido na comanda
                if (esc != 0) {
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

    //Pagar pelos pedidos
    public void pagar(){ 

        if (this.reserva){

            //Mostra a comanda
            mesaComanda.listarConsumo();

            int esc;

            //Se o cliente quiser, acrescenta 10% ao valor total (gorjeta)
            System.out.print("\nSe você deseja pagar a gorjeta(10%), digite 1 (se não, digite 0): ");
            esc = leitor.nextInt();
            leitor.nextLine();   
            if (esc == 1){
                mesaComanda.setValor(mesaComanda.getValor() + mesaComanda.calcular10porcento());
                System.out.printf("Valor atualizado: R$%.2f\n", mesaComanda.getValor());
            }

            //Se o cliente quiser, acrescenta centavos para o valor ficar inteiro (doação)
            System.out.printf("\nVocê gostaria de doar %.2f centavos para as crianças com câncer do Hospital Humberto Honda? Se sim, digite 1 (se não, digite 0): ", mesaComanda.calcularSobra());
            esc = leitor.nextInt();
            leitor.nextLine();  
            if (esc == 1){
                mesaComanda.setValor(mesaComanda.getValor() + mesaComanda.calcularSobra());
                System.out.printf("Valor atualizado: R$%.2f\n", mesaComanda.getValor());
            }

            //Se o cliente quiser, divide a conta entre as pessoas da mesa
            if (clientes.length > 1){
                System.out.print("\nSe as pessoas da mesa gostariam de dividir a conta, digite 1 (se não, digite 0): ");
                esc = leitor.nextInt();
                leitor.nextLine();  
                if (esc == 1){
                    int num;
                    do {
                        System.out.print("Quantas pessoas vão dividir a conta? ");
                        num = leitor.nextInt(); leitor.nextLine();
                        if (num <= clientes.length && num > 0){
                            System.out.printf("Valor para cada pessoa: R$%.2f\n", mesaComanda.dividirConta(mesaComanda.getValor(), num));
                        } else {
                            System.out.println("Coloque uma quantidade plausivel de pessoas");
                        }
                    } while (num > clientes.length || num <= 0);
                }
            }

            //Efetua pagamento
            do {
                System.out.print("\nDigite 1 para efetuar o pagamento: ");
                esc = leitor.nextInt();
                leitor.nextLine();  
            } while (esc != 1);
            System.out.println("Pagamento realizado com sucesso");

            this.cancelar();

        } else{
            System.out.println("Essa mesa não está reservada");
        }
    }

}