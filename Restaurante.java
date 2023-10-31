import java.util.Scanner;

public class Restaurante {
    
    //Atributos
    private String nome;
    private String endereco;
    private Mesa[] mesas;

    //Scanner
    Scanner leitor = new Scanner(System.in);

    //Método construtor
    public Restaurante(String nomef, String enderecof, int qmesasf){
        this.nome = nomef;
        this.endereco = enderecof;
        mesas = new Mesa[qmesasf];
        for (int i = 0; i < mesas.length; i++){
            mesas[i] = new Mesa();
            mesas[i].setNumeroMesa(i+1);
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
    public Mesa[] getMesas(){
        return mesas;
    }

    //Método para imprimir o menu e coletar resposta
    public int menuRestaurante(){
        System.out.println("Digite o que quer fazer");
        System.out.println("    [1] - Reservar uma mesa");
        System.out.println("    [2] - Cancelar reserva");
        System.out.println("    [3] - Listar mesas reservadas");
        System.out.println("    [4] - Fazer um pedido");
        System.out.println("    [5] - Pagar pelo pedido");
        System.out.println("    [0] - Sair");
        int escolha = leitor.nextInt();
        leitor.nextLine();
        return escolha;     
    }        
    
}