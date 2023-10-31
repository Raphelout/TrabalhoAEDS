public class Comanda {

    //Atributos
    private String consumo;
    private double valor;

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
        
    }

    public double calcular10porcento(){
        return valor/10;
    }

    public double dividirConta(double valor, int qpessoas){
        return valor/qpessoas;
    }

}