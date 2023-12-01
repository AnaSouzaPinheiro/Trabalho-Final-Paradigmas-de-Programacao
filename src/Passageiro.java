import java.util.Scanner;

public class Passageiro {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String numPoltrona;
    private String numPassagem;
    private String numVoo;
    private String horario;
    private String destino;

    /**
     * método para criar um novo passageiro pelo console
     * @param num_Voo
     * @return
     */
    public Passageiro criarNovoPassageiro(int num_Voo) {
        Scanner teclado = new Scanner(System.in);
        Passageiro passageiro = new Passageiro();
        System.out.print("Digite o CPF do passageiro: ");
        passageiro.setCpf(teclado.nextLine());

        System.out.print("Digite o nome do passageiro: ");
        passageiro.setNome(teclado.nextLine());

        System.out.print("Digite o endereço do passageiro: ");
        passageiro.setEndereco(teclado.nextLine());

        System.out.print("Digite o telefone do passageiro: ");
        passageiro.setTelefone(teclado.nextLine());

        System.out.print("Digite o número da poltrona do passageiro: ");
        passageiro.setNumeroPoltrona(teclado.nextLine());

        System.out.print("Digite o número da passagem do passageiro: ");
        passageiro.setNumeroPassagem(teclado.nextLine());
        passageiro.setNumeroVoo(Integer.toString(num_Voo));
        switch (num_Voo) {
            case 1:
                passageiro.destino="BH-SP";
                break;
            case 2:
                passageiro.destino="BH-RIO";
                break;
            case 3:
                passageiro.destino="BH-BRA";
                break;
            default:
                break;
        }
        System.out.print("Digite o horário do voo do passageiro: ");
        passageiro.setHorario(teclado.nextLine());
        
        return passageiro;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumeroPassagem() {
        return numPassagem;
    }

    public void setNumeroPassagem(String numeroPassagem) {
        this.numPassagem = numeroPassagem;
    }

    public String getNumeroPoltrona() {
        return numPoltrona;
    }

    public void setNumeroPoltrona(String numeroPoltrona) {
        this.numPoltrona = numeroPoltrona;
    }

    public String getNumeroVoo() {
        return numVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numVoo = numeroVoo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }  

    @Override
    public String toString() {
        return cpf + ", " + nome + ", " +  endereco + ", " + telefone + ", " + numPoltrona + ", " + numPassagem + ", " + numVoo + ", " + horario + ", " + destino;
    }

    /**
     * método especial para impressão de passageiros do botão 1 do menu
     * @return
     */
    public String toString2() { 
        return nome + ", " + cpf + ", " + numPassagem + ", " + numPoltrona;
    }

    /**
     * método especial para impressão de passageiros ao salvar no txt
     * @return
     */
    public String toString3() {
        return cpf + "\n" + nome + "\n" +  endereco + "\n" + telefone + "\n" + numPoltrona +"\n" + numPassagem + "\n" + numVoo + "\n" + horario + "\n" + destino +"\n";
    }
}