import java.util.Scanner;

public class Mesa {
    
    //Atributos
    private int numeroMesa;
    private String data;
    private boolean reserva;
    public Cliente[] pessoas;
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
        pessoas = new Cliente[leitor.nextInt()]; //cria uma array de clientes dentro da mesa sendo reservada com o numero de pessoas q o user informar
        leitor.nextLine();
        for (int i = 0; i < pessoas.length; i++){
            pessoas[i] = new Cliente();
        }

        System.out.println("Quer reservar pra quando?");
        this.data = leitor.nextLine();

        System.out.println("PARA O/A/Ê REPRESENTANTE DA RESERVA");
        System.out.print("Por favor, informe o seu nome, senhor(a/e)?");
        pessoas[0].setNome(leitor.nextLine());

        System.out.print("\nEm seguida, o email para contato: ");
        pessoas[0].setEmail(leitor.nextLine());
        System.out.println("Mesa reservada com sucesso");
        this.reserva = true;
        return true;
    }

    //Cancelar reserva
    public boolean cancelar(){
        this.reserva = false;
        pessoas = new Cliente[0];
        return false;
    }

    void pedidoM(){
        if (this.reserva){
        System.out.println("Qual o nome do pedido?");
        this.mesaComanda.nomePedidos.add(leitor.nextLine()); //adiciona o pedido pelo scanner e coloca dentro
        System.out.println("e qual o preço desse pedido?");
        this.mesaComanda.precoPedidos.add(leitor.nextDouble()); 
        mesaComanda.setValor(mesaComanda.getValor() + mesaComanda.precoPedidos.get(mesaComanda.precoPedidos.size() - 1)); //pega o valor do ultimo pedido feito e adiciona ao valor da comanda
        System.out.println("valor atual da comanda: " + mesaComanda.getValor());
        } else {
            System.out.println("Essa mesa não está reservada");
        }
    }

}