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


    public int findVazia(){
        for (int i = 0; i < listaM.size(); i++){
            if (listaM.get(i).getReserva() == false){
                return i;
            }
        }
        System.out.println("não tem mesa vazia");
        return listaM.size() + 1;
    }


    void fazerPedido(){
        int imesa;
        System.out.print("Digite a mesa que fará o pedido: ");
        imesa = leitor.nextInt(); leitor.nextLine();
        listaM.get(imesa).pedidoM();
    }

    //Lista mesas reservadas
    void listarMesas(){
        System.out.println("Mesas reservadas: ");
        for(int i = 0; i < listaM.size(); i++){
            if (listaM.get(i).getReserva() == true){
                System.out.println("Mesa[" + listaM.get(i).getNumeroMesa() + "]: " + listaM.get(i).clientes[0].getNome() + " (" + listaM.get(i).getData() + ")");
            }
        }
    }

    //Menu
    public void menuRestaurante(){
        int escolha;

        do {
            System.out.println("\nDigite o que quer fazer");
            System.out.println("    [1] - Reservar mesa");
            System.out.println("    [2] - Cancelar reserva");
            System.out.println("    [3] - Listar mesas reservadas");
            System.out.println("    [4] - Fazer pedido");
            System.out.println("    [5] - Pagar pelo pedido");
            System.out.println("    [0] - Sair");
            escolha = leitor.nextInt();
            leitor.nextLine();
            System.out.println();

            switch (escolha) {
                case 1: //Reservar mesa 
                    /* falta fazer com que a disponibilidade de mesas seja relativa à data */
                    listaM.get(findVazia()).reservar();
                    break;
        
                case 2: //Cancelar reserva
                    System.out.print("Digite a mesa que deseja retirar a reserva: ");
                    listaM.get(leitor.nextInt()).cancelar();
                    break;
            
                case 3: //Listar mesas reservadas
                    this.listarMesas();
                    break;//ok
            
                case 4: //Fazer pedido
                        /* colocar menu de pedidos */
                    this.fazerPedido();
                    break;
            
                case 5: //Pagar pelo pedido
                    //pagar pedido
                    break;

                case 0: //Sair
                    System.out.println("Obrigado por apreciar o restaurante :) ");
                    break;

                default:
                    System.out.println("Essa opção nao existe");
                    break;
            }
        } while (escolha != 0);
    }

}