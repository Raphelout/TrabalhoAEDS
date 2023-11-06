////////////////////////////////////////////////////////////////////////
// Dupla: Raphael Inácio Bicalho de Carvalho e Luka Guimarães Fantini //
// Comanda.java                                                       //
////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

public class Comanda {

    //Atributos
    private double valor;
    Mesa mesacomanda;

    //Cria lista de pedidos
    ArrayList<Integer> codigoPedidos = new ArrayList<>();//Para registrar nomes (para comanda)
    ArrayList<String> nomePedidos = new ArrayList<>();
    ArrayList<Double> precoPedidos = new ArrayList<>();//Para calcular valor

    //Lista de preços
    public Comanda(){
        nomePedidos.add("Canja de tatu vegetariana");
        nomePedidos.add("PF (prato feito)");
        nomePedidos.add("PQF (prato quase feito)");
        nomePedidos.add("Suco do bandeco (sabor vermelho)");
        nomePedidos.add("Suco do bandeco (sabor roxo)");
        nomePedidos.add("Água não saborizada");

        precoPedidos.add(10.00);
        precoPedidos.add(15.00);
        precoPedidos.add(14.99);
        precoPedidos.add(3.05);
        precoPedidos.add(3.00);
        precoPedidos.add(6.00);
    }

    //Setters
    public void setValor(double valor){
        this.valor = valor;
    }

    //Getters
    public double getValor(){
        return valor;
    }
    public ArrayList<Integer> getCodigoPedidos() {
        return codigoPedidos;
    }

    //Imprime todos os pedidos do cliente e seus respectivos valores
    public void listarConsumo(){

        if (mesacomanda.getReserva()){
            System.out.println("\nCOMANDA");
            for (int i = 0; i < codigoPedidos.size(); i++){
                System.out.printf("Pedido[" + i + "]: " + this.nomePedidos.get(this.codigoPedidos.get(i) - 1) + " - R$%.2f\n", this.precoPedidos.get(this.codigoPedidos.get(i) - 1));
            }
            System.out.println("Valor: R$" + this.getValor());
        } else {
            System.out.println("Essa mesa não está reservada");
        }
    }

    //Cálculos envolvendo o valor total a ser pago
    public double calcular10porcento(){
        return valor/10;
    }
    public double calcularSobra(){
        return 1 - valor%1;
    }
    public double dividirConta(double valor, int qpessoas){
        return valor/qpessoas;
    }

}