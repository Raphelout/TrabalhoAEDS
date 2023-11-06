////////////////////////////////////////////////////////////////////////
// Dupla: Raphael Inácio Bicalho de Carvalho e Luka Guimarães Fantini //
// Restaurante.java                                                   //
////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
import java.util.ArrayList;

public class Restaurante {
    
    //Atributos
    private String nome;
    private String endereco;

    //Cria lista de mesas
    ArrayList<Mesa> listaM = new ArrayList<>();

    //Scanner
    Scanner leitor = new Scanner(System.in);

    //Método construtor
    public Restaurante(String nomef, String enderecof, int qmesasf){
        this.nome = nomef;
        this.endereco = enderecof;
        for (int i = 0; i < qmesasf; i++){
            listaM.add(i, new Mesa());//bota mesa dentro do indice i
            listaM.get(i).setNumeroMesa(i+1);//vai na mesa do indice i e define o numero dela 
        }
    }

    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    //Getters
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }

    //Dá boas vindas e chama o menu
    public void recepcao(){
        System.out.println();
        for (int i = 0; i < (30 + this.getNome().length()); i++) {
            System.out.print("-");
        }
        System.out.println("\n| Bem vindo ao Restaurante " + this.getNome() + "! |");
        for (int i = 0; i < (30 + this.getNome().length()); i++) {
            System.out.print("-");
        }
        this.menuRestaurante();
    }

    //Procura a primeira mesa vazia da lista
    public int findVazia(){
        for (int i = 0; i < listaM.size(); i++){
            if (listaM.get(i).getReserva() == false){
                return i;
            }
        }
        System.out.println("Não há mesas vazias");
        return listaM.size() + 1;
    }

    //Cancela a reserva
    public void cancelarReserva(){
        int imesa;
        System.out.print("\nDigite a mesa que deseja cancelar a reserva: ");
        imesa = leitor.nextInt(); leitor.nextLine();
        if(imesa <= listaM.size() && imesa > 0){
            listaM.get(imesa-1).cancelar();
        } else {
            System.out.println("Essa mesa não existe");
        }
    }

    //Faz o pedido
    public void fazerPedido(){
        int imesa;
        System.out.print("\nDigite a mesa que deseja fazer o pedido: ");
        imesa = leitor.nextInt(); leitor.nextLine();
        if(imesa <= listaM.size() && imesa > 0){
            listaM.get(imesa-1).pedir();
        } else {
            System.out.println("Essa mesa não existe");
        }
    }

    //Lista pedidos
    public void listarPedidos(){
        int imesa;
        System.out.print("\nDigite a mesa que deseja ver os pedidos: ");
        imesa = leitor.nextInt(); leitor.nextLine();
        if(imesa <= listaM.size() && imesa > 0){
            listaM.get(imesa-1).mesaComanda.listarConsumo();
        } else {
            System.out.println("Essa mesa não existe");
        }
    }

    //Paga o pedido
    public void pagarPedido(){
        int imesa;
        System.out.print("\nDigite a mesa que deseja pagar: ");
        imesa = leitor.nextInt(); leitor.nextLine();
        if(imesa <= listaM.size() && imesa > 0){
            listaM.get(imesa-1).pagar();
        } else {
            System.out.println("Essa mesa não existe");
        }
    } 

    //Lista de mesas reservadas
    public boolean listarMesas(){
        
        //Confere se há mesas reservadas
        boolean temMesa = false;
        for (Mesa m : listaM){
            if (m.getReserva() == true) {
                temMesa = true;
            }
        }
        
        //Se tiver mesas reservadas as imprime
        if (temMesa) {
            System.out.println("Mesas reservadas: ");
            for(int i = 0; i < listaM.size(); i++){
                if (listaM.get(i).getReserva() == true){
                    System.out.println("Mesa[" + listaM.get(i).getNumeroMesa() + "]: " + listaM.get(i).clientes[0].getNome() + " (" + listaM.get(i).getData() + ")");
                }
            }   
        } else { //Se não, não as imprime
            System.out.println("Não há mesas reservadas");
        }
        return temMesa;
    }

    //Menu de opções
    public void menuRestaurante(){

        int escolha;
        do {
            System.out.println("\n\nDigite o que quer fazer:");
            System.out.println("  [1] - Reservar mesa");
            System.out.println("  [2] - Cancelar reserva");
            System.out.println("  [3] - Listar mesas reservadas");
            System.out.println("  [4] - Fazer pedido");
            System.out.println("  [5] - Listar consumo");
            System.out.println("  [6] - Pagar pelo pedido");
            System.out.println("[0] - Sair");

            //Pega código da opção
            escolha = leitor.nextInt();
            leitor.nextLine();
            System.out.println();

            switch (escolha) {
                case 1: //Reservar mesa 
                    listaM.get(findVazia()).reservar();
                    break;
        
                case 2: //Cancelar reserva
                    if (this.listarMesas() == true){
                        this.cancelarReserva();
                    }
                    break;
            
                case 3: //Listar mesas reservadas
                    this.listarMesas();
                    break;
            
                case 4: //Fazer pedido
                    if (this.listarMesas() == true){
                        this.fazerPedido();
                    }
                    break;
            
                case 5: //Listar consumo
                    if (this.listarMesas() == true){
                        this.listarPedidos();
                    }
                    break;

                case 6: //Pagar pelo pedido
                    if (this.listarMesas() == true){
                        this.pagarPedido();
                    }
                    break;

                case 0: //Sair
                    System.out.println("Obrigado por apreciar o restaurante :)\n");
                    break;

                default:
                    System.out.println("Essa opção não existe");
                    break;
            }
        } while (escolha != 0);
    }

}