public class Restaurante {
    
    //Atributos
    private String nome;
    private String endereco;
    private Mesa[] mesas;

    //Método construtor
    public Restaurante(String nomef, String enderecof, int qmesasf){
        this.nome = nomef;
        this.endereco = enderecof;
        mesas = new Mesa[qmesasf];
        for (int i = 0; i < mesas.length; i++){
            mesas[i].setNumeroMesa(i+1);
        }
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //Getters
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public Mesa[] getMesas() {
        return mesas;
    }

}