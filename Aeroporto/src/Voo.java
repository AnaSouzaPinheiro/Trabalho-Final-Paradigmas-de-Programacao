import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Voo {
    int num_Voo;

    public int getNum_Voo() {
        return num_Voo;
    }

    String destino;

    public Voo(int num_Voo, String destino) {
        this.num_Voo = num_Voo;
        this.destino = destino;
    }

    ArrayList<Passageiro> Lista_Passageiros = new ArrayList<Passageiro>();
    ArrayList<Passageiro> Lista_Espera = new ArrayList<Passageiro>();

    public void ListaCompleta() {
        for (int i = 0; i < Lista_Passageiros.size(); i++) {
            System.out.println(Lista_Passageiros.get(i).toString2());
        }
    }

    public void PesquisarPassageiroCPF(String Cpf) {

        for (int i = 0; i < Lista_Passageiros.size(); i++) {
            String _CPF = Lista_Passageiros.get(i).getCpf();
            if (_CPF.equalsIgnoreCase(Cpf)) {
                System.out.println("Passageiro encontrado: " + Lista_Passageiros.get(i).toString());
            }
        }
    }

    public void PesquisarPassageiroNome(String Nome) {
        for (int i = 0; i < Lista_Passageiros.size(); i++) {
            if (Lista_Passageiros.get(i).getNome().equalsIgnoreCase(Nome)) {
                System.out.println("Passageiro encontrado: " + Lista_Passageiros.get(i).toString());
            }
        }
    }

    public String getCaminho() {
        String caminho;
        switch (num_Voo) {
            case 1:
                caminho = "src/bd/1 - VOO BH-SP.txt";
                break;
            case 2:                
                caminho = "src/bd/2 - VOO BH-RIO.txt";
                break;
            case 3:
                caminho = "src/bd/3 - VOO BH-BRA.txt";
                break;
            default:
                caminho = "Nenhum arquivo encontrado";
                break;
        }
        return caminho;
    }
    public String getCaminhoEspera() {
        String caminhoEspera;
        switch (num_Voo) {
            case 1:
                caminhoEspera = "src/bd/ListaEsperaSP.txt";
                break;
            case 2:                
                caminhoEspera = "src/bd/ListaEsperaRIO.txt";
                break;
            case 3:
                caminhoEspera = "src/bd/ListaEsperaBRA.txt";
                break;
            default:
                caminhoEspera = "Nenhum arquivo encontrado";
                break;
        }
        return caminhoEspera;
    }

    public void CadastrarPassageiro() {
        Passageiro Passageiro = new Passageiro();
        Passageiro = Passageiro.criarNovoPassageiro(num_Voo);
        if (Lista_Passageiros.size() < 10) {
            Lista_Passageiros.add(Passageiro);
            System.out.println("Passageiro cadastrado com sucesso!");
            salvarEmArquivo(getCaminho(), Lista_Passageiros);
        } else { 

            if (Lista_Espera.size() < 5) {
                Lista_Espera.add(Passageiro);
                System.out.println("Voo cheio! Passageiro cadastrado na lista de espera!");
                salvarEmArquivo(getCaminhoEspera(),Lista_Espera);
            } else {
                System.out.println("Fila Cheia, a reserva não pode ser feita.");
            }

        }
    }
    
    /**
     * Esse método carrega um passageiro do banco de dados e o adiciona na lista respectiva do voo dele
     * @param passageiro
     */
    public void SetarPassageiro(Passageiro passageiro) {
       
        if (Lista_Passageiros.size() < 10) {
            Lista_Passageiros.add(passageiro);
            System.out.println("Passageiro cadastrado com sucesso!");
        } else { 

            if (Lista_Espera.size() < 5) {
                Lista_Espera.add(passageiro);
                System.out.println("Voo cheio! Passageiro cadastrado na lista de espera!");
            } else {
                System.out.println("Fila Cheia, a reserva não pode ser feita.");
            }

        }
    }

    /**
     * Esse metodo tira um passageiro da lista de voo (pelo CPF) e coloca o primeiro
     * da lista de espera, se houver um.
     * Depois salva tudo no txt correspondente.
     * 
     * @param passageiro
     */
    public void substituirPassageiro(String Cpf) {

        for (int i = 0; i < Lista_Passageiros.size(); i++) {

            String _CPF = Lista_Passageiros.get(i).getCpf();

            if (_CPF.equalsIgnoreCase(Cpf)) {

                Passageiro passageiro = Lista_Passageiros.get(i);
                int pos = Lista_Passageiros.indexOf(passageiro);
                if (pos != -1) {
                    if (!Lista_Espera.isEmpty()) {
                        Passageiro passageiroEspera = Lista_Espera.get(0);
                        Lista_Passageiros.set(pos, passageiroEspera);
                        Lista_Espera.remove(0);
                        System.out.println("Passageiro substituido com sucesso!");
                        salvarEmArquivo(getCaminho(), Lista_Passageiros);
                        salvarEmArquivo(getCaminhoEspera(), Lista_Espera);
                    } else {
                        Lista_Passageiros.remove(pos);
                        System.out.println("Passageiro removido com sucesso!");
                        salvarEmArquivo(getCaminho(), Lista_Passageiros);
                    }
                }
            }
        }

    }

    /**
     * Mostra a lista de espera do voo
     */
    public void MostrarListaEspera() {
        System.out.println("Lista de Espera de Passageiros: ");
        for (int i = 0; i < Lista_Espera.size(); i++) {
            System.out.println(Lista_Espera.get(i));
        }
    }


    /**
     * Esse método salva os dados de um passageiro em um arquivo.txt
     * @param caminhoArquivo
     * @param lista
     */
    public static void salvarEmArquivo(String caminhoArquivo, ArrayList<Passageiro> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            // Escreve cada informação no arquivo
            for (Passageiro informacao : lista) {
                writer.write(informacao.toString3());
                /* writer.newLine(); */ // Adiciona uma nova linha para cada informação
            }
        } catch (IOException e) {
            // Trata possíveis erros de IO, como problemas ao criar ou escrever no arquivo
            e.printStackTrace();
        }
    }
}