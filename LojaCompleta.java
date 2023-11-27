package ProjetoCompleto;
import java.util.Scanner;

class Equipamento {
    private String nome;
    private String marca;
    private double preco;

    public Equipamento(String nome, String marca, double preco) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public double getPreco() {
        return preco;
    }
}

public class LojaCompleta {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Equipamento[] sticks = {
            new Equipamento("Stick1", "Fisher", 250.0),
            new Equipamento("Stick2", "CCM", 800.0),
            new Equipamento("Stick3", "Bauer", 1200.0)
        };

        Equipamento[] protecoes = {
            new Equipamento("Peitoral", "CCM", 500.0),
            new Equipamento("Fraldão", "CCM", 450.0),
            new Equipamento("Caneleira", "Fisher", 400.0)
        };

        Equipamento[] vestuario = {
            new Equipamento("Jersey de Treino", "Bauer", 150.0),
            new Equipamento("Meião", "Diversos", 80.0),
            new Equipamento("Calça Térmica", "Não Especificado", 100.0)
        };

        double total = 0.0;

        System.out.println("# ## ### #### #########   Bem vinde ao menu de compras hockeyBR!   ########## #### ### ## #");
        System.out.println("\n--Digite 1 para selecionar os sticks-- ");
        System.out.println("\n--Digite 2 para proteções-- ");
        System.out.println("\n--Digite 3 para vestuário-- ");
        System.out.println("\n--Digite 4 para sair-- ");

        int op;
        do {
            op = leia.nextInt();
            switch (op) {
                case 1:
                    total += escolherEquipamento(sticks);
                    break;
                case 2:
                    total += escolherEquipamento(protecoes);
                    break;
                case 3:
                    total += escolherEquipamento(vestuario);
                    break;
                case 4:
                    System.out.println("Programa encerrado. Obrigado por usar o menu de compras hockeyBR!");
                    break;
                default:
                    System.out.println("Comando inválido. Por favor, escolha uma opção válida.");
            }
        } while (op != 4);

        System.out.println("O total da compra é: R$" + total);

        leia.close();
    }

    private static double escolherEquipamento(Equipamento[] equipamentos) {
        Scanner leia = new Scanner(System.in);
        exibirOpcoesEquipamentos(equipamentos);
        System.out.println("Escolha o número do equipamento desejado:");
        int escolha = leia.nextInt();
        Equipamento equipamentoEscolhido = equipamentos[escolha - 1];
        System.out.println("Você escolheu: " + equipamentoEscolhido.getNome() + " - " + equipamentoEscolhido.getMarca() + " - R$" + equipamentoEscolhido.getPreco());
        return equipamentoEscolhido.getPreco();
    }

    private static void exibirOpcoesEquipamentos(Equipamento[] equipamentos) {
        System.out.println("Tipos de Equipamentos Disponíveis:");
        for (int i = 0; i < equipamentos.length; i++) {
            Equipamento equipamento = equipamentos[i];
            System.out.println((i + 1) + ". " + equipamento.getNome() + " - " + equipamento.getMarca() + " - R$" + equipamento.getPreco());
        }
    }
}
