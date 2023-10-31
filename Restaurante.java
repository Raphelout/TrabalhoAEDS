///////////////////////////////////////////////////////////////////////
// Dupla: Raphael Inácio Bicalho de Carvalho e Luka guimarâes Fantini//
// Comanda.java                                                      //
///////////////////////////////////////////////////////////////////////

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
        int escolha;
        System.out.println("Qual é a mesa fazendo o pedido?");
        escolha = leitor.nextInt(); leitor.nextLine();
        listaM.get(escolha).pedidoM();
    }

    void listarMesas(){
        System.out.println("Mesas reservadas: ");
        for(int i = 0; i < listaM.size(); i++){
            if (listaM.get(i).getReserva() == true){
                System.out.println("Mesa número : " + listaM.get(i).getNumeroMesa());
            }
        }
    }
    //Método para imprimir o menu e coletar resposta
    public void menuRestaurante(){
        int escolha;

        do {
            System.out.println("\nDigite o que quer fazer");
            System.out.println("    [1] - Reservar uma mesa");
            System.out.println("    [2] - Cancelar reserva");
            System.out.println("    [3] - Listar mesas reservadas");
            System.out.println("    [4] - Fazer um pedido");
            System.out.println("    [5] - Pagar pelo pedido");
            System.out.println("    [0] - Sair");
            escolha = leitor.nextInt();
            leitor.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println();
                    listaM.get(findVazia()).reservar();
                    break;
        
                case 2:
                    System.out.println();
                    System.out.print("Digite a mesa que deseja retirar a reserva: ");
                    listaM.get(leitor.nextInt()).cancelar();
                    break;
            
                case 3:
                    System.out.println();
                    //listar mesas reservadas
                    this.listarMesas();
                    break;
            
                case 4:
                    System.out.println();
                    this.fazerPedido(); //fazer pedidio
                    break;
            
                case 5:
                    System.out.println();
                    //pagar pedido
                    break;
                case 0:
                System.out.println("obrigado por apreciar o restaurante :) ");
                default:
                    System.out.println("Essa opção nao existe");
                    break;
            }
        } while (escolha != 0);
    }


    

}