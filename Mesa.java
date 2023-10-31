import java.util.Scanner;

public class Mesa {
    
    //Atributos
    private int numeroMesa;
    private String data;
    private boolean reserva;
    Cliente[] pessoas;

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

        System.out.println("PARA O/A/Ê REPRESENTANTE DA RESERVA");
        System.out.print("Por favor, informe o seu nome, senhor(a/e)?");
        pessoas[0].setNome(leitor.nextLine());

        System.out.print("\nEm seguida, o email para contato: ");
        pessoas[0].setEmail(leitor.nextLine());
        
        System.out.println("A mesa é para quantas pessoas? [1:6]");
        pessoas = new Cliente[leitor.nextInt()]; leitor.nextLine();
        
        System.out.println("Quer reservar pra quando?");
        this.data = leitor.nextLine();
        this.reserva = true;
        return true;
    }

}