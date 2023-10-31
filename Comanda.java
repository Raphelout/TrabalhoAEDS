///////////////////////////////////////////////////////////////////////
// Dupla: Raphael Inácio Bicalho de Carvalho e Luka guimarâes Fantini//
// Comanda.java                                                      //
///////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

public class Comanda {

    //Atributos
    private String consumo;
    private double valor;
    Mesa mesacomanda;

    //Cria lista de pedidos
    ArrayList<String> nomePedidos = new ArrayList<>();
    ArrayList<Double> precoPedidos = new ArrayList<>();

    //Setters
    public void setConsumo(String consumo){
        this.consumo = consumo;
    }
    public void setValor(double valor){
        this.valor = valor;
    }

    //Getters
    public String getConsumo(){
        return consumo;
    }
    public double getValor(){
        return valor;
    }

    public void listarConsumo(){
        for (int i = 0; i < nomePedidos.size(); i++){
            System.out.println("Pedido número " + i + " " + nomePedidos.get(i) + " - " + precoPedidos.get(i) + "R$");
        }
    }

    public double calcular10porcento(){
        return valor/10;
    }

    public double dividirConta(double valor, int qpessoas){
        return valor/qpessoas;
    }

}