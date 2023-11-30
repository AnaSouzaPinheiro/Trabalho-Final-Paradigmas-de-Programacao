import java.util.Scanner;

public class Main {
    public static Scanner teclado = new Scanner(System.in);
    private static int numVoo;
    private static Voo voo1 = new Voo(1, "SP");
    private static Voo voo2 = new Voo(2, "RJ");
    private static Voo voo3 = new Voo(3, "BRA");
    private static Voo _voo;
    private static String _cpf;

    public static void main(String[] args) {
        try (
                Scanner SP = new Scanner(Main.class.getResourceAsStream("bd/1 - VOO BH-SP.txt"));
                Scanner RIO = new Scanner(Main.class.getResourceAsStream("bd/2 - VOO BH-RIO.txt"));
                Scanner BRA = new Scanner(Main.class.getResourceAsStream("bd/3 - VOO BH-BRA.txt"));
                Scanner listaEsperaSP = new Scanner(Main.class.getResourceAsStream("bd/ListaEsperaSP.txt"));
                Scanner listaEsperaRIO = new Scanner(Main.class.getResourceAsStream("bd/ListaEsperaRIO.txt"))) {

            System.out.println("SP:");
            readData(SP, 10, voo1);

            System.out.println("RIO:");
            readData(RIO, 10, voo2);

            System.out.println("BRA:");
            readData(BRA, 10, voo3);

            System.out.println("Espera SP:");
            readData(listaEsperaSP, 5, voo1);

            System.out.println("Espera RIO:");
            readData(listaEsperaRIO, 5, voo2);

        } catch (Exception e) {
            System.out.println("ALGUMA LISTA DE PASSAGEIROS NÃO ESTAVA COM 10 PASSAGEIROS A BORDO OU 5 NA LISTA DE ESPERA");
        }

        int op = 0;
        while (op >= 0) {
            perguntaVoo();
            op = menuPrincipal();
            menuSecundario(op);
        }

    }

    public static int perguntaVoo() {
        System.out.println("\n========== VOO ==========");
        System.out.println("1 - VOO BH-SP");
        System.out.println("2 - VOO BH-RIO");
        System.out.println("3 - VOO BH-BRA");
        System.out.print("\nInforme o número do voo: ");
        numVoo = teclado.nextInt();
        return numVoo;
    }

    public static String VerificaVoo() {
        switch (numVoo) {
            case 1:
                _voo = voo1;

                return "VOO BH-SP";
            case 2:
                _voo = voo2;

                return "VOO BH-RIO";
            case 3:
                _voo = voo3;

                return "VOO BH-BRA";
            default:
                return "Voo não encontrado";
        }
    }

    public static int menuPrincipal() {
        teclado.nextLine();
        int op;
        System.out.println("\nEMPRESA AÉREA QUEDA LIVRE - " + VerificaVoo());
        System.out.println("MENU DE OPÇÕES");
        System.out.println("1. Lista de passageiros de um voo");
        System.out.println("2. Pesquisar passageiro por CPF");
        System.out.println("3. Pesquisar passageiro por nome");
        System.out.println("4. Cadastrar passageiro");
        System.out.println("5. Excluir passageiro");
        System.out.println("6. Lista de espera");
        System.out.println("9. Sair");
        System.out.print("Digite sua opção: ");
        op = teclado.nextInt();
        return op;
    }

    public static void menuSecundario(int op) {
        switch (op) {
            case 1:
                System.out.println("\nLista de passageiros: ");
                _voo.ListaCompleta();
                break;
            case 2:
            teclado.nextLine();
                System.out.println("Pesquisar passageiros pelo CPF: ");
                _cpf = teclado.nextLine();
                _voo.PesquisarPassageiroCPF(_cpf);
                break;
            case 3:
                teclado.nextLine();
                System.out.println("Pesquisar passageiros pelo nome");
                System.out.print("Digite o nome do passageiro: ");
                String _nome = teclado.nextLine();
                _voo.PesquisarPassageiroNome(_nome);
                break;
            case 4:
                System.out.println("Cadastrar passageiro no voo: ");
                _voo.CadastrarPassageiro();

                break;
            case 5:
                System.out.println("Excluir passageiro do voo pelo CPF: ");
                teclado.nextLine();
                _cpf = teclado.nextLine();
                _voo.substituirPassageiro(_cpf);

                break;
            case 6:
                System.out.println("Lista de espera");
                _voo.MostrarListaEspera();

                break;
            case 9:
                teclado.close();
                System.out.println("Saindo...");
                System.exit(0);

                break;
            default:
                menuPrincipal();
        }
    }

    /**
     * Esse método lê os dados do objeto arquivo e os armazena em um objeto do tipo
     * Voo
     * 
     * @param scanner
     * @param linesToRead
     * @param voo
     */
    public static void readData(Scanner scanner, int linesToRead, Voo voo) {
        for (int aux = 1; aux <= linesToRead; aux++) {
            String cpf = scanner.nextLine();
            String nome = scanner.nextLine();
            String endereco = scanner.nextLine();
            String telefone = scanner.nextLine();
            String numPoltrona = scanner.nextLine();
            String numPassagem = scanner.nextLine();
            String numVoo = scanner.nextLine();
            String horario = scanner.nextLine();
            String destino = scanner.nextLine();

            Passageiro passageiro = new Passageiro();
            passageiro.setCpf(cpf);
            passageiro.setNome(nome);
            passageiro.setEndereco(endereco);
            passageiro.setTelefone(telefone);
            passageiro.setNumeroPoltrona(numPoltrona);
            passageiro.setNumeroPassagem(numPassagem);
            passageiro.setNumeroVoo(numVoo);
            passageiro.setHorario(horario);
            passageiro.setDestino(destino);

            voo.SetarPassageiro(passageiro);
        }
    }
}