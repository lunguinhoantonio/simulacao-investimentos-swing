import tiposInvestimento.*;
import register.Registro;
import writer.RegistroEmArquivo;

import java.util.Scanner;
import java.util.Stack;

public class Yeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Registro registros = new Registro();
        
        Stack<TesouroSelic> pilhaTSelic = new Stack<>();
        Stack<Acao> pilhaAcoes = new Stack<>();
        Stack<Poupanca> pilhaPoupanca = new Stack<>();
        Stack<CDB> pilhaCDB = new Stack<>();
        int opc;
        double capital;
        int tempo;
        do {
            System.out.println("Selecione a opcao desejada:");
            System.out.println("0 - Finalizar programa" + (!registros.isEmpty() ? " e exportar histórico" : ""));
            System.out.println("1 - Fazer investimento");
            System.out.println("2 - Listar simulações");
            System.out.println("3 - Buscar simulações");
            System.out.println("4 - Remover simulação");
            System.out.println("5 - Editar simulação");
            System.out.print("Selecao: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch(opc){
                case 0:
                    break;
                case 1:
                    int tipo;
                    do {
                        System.out.println("Selecione um tipo de investimento:");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("1 - Poupanca");
                        System.out.println("2 - CDB");
                        System.out.println("3 - Tesouro Selic");
                        System.out.println("4 - Acoes");
                        System.out.print("Tipo: ");
                        tipo = sc.nextInt();
                        sc.nextLine();
                        switch (tipo) {
                            case 0:
                                break;
                            case 1:
                                do {
                                    System.out.print("Informe o capital inicial (R$): ");
                                    capital = sc.nextDouble();
                                    if (capital <= 0) {
                                        System.out.println("O investimento inicial não deve ser menor ou igual a 0");
                                    }
                                } while (capital <= 0);
                                do {
                                    System.out.print("Informe o tempo em meses: ");
                                    tempo = sc.nextInt();
                                    if (tempo <= 0) {
                                        System.out.println("O tempo não pode ser negativo ou igual a zero!");
                                    }
                                } while (tempo <= 0);
                                pilhaPoupanca.push(new Poupanca(capital, tempo));
                                pilhaPoupanca.peek().calcValorFinal();
                                System.out.print("Resultado de " + pilhaPoupanca.peek().getTempoInvestido() + (pilhaPoupanca.peek().getTempoInvestido() == 1 ? " mês" : " meses") + ": ");
                                System.out.printf("R$%.2f\n", pilhaPoupanca.peek().getMontante());
                                System.out.printf("Rendeu %.2f%%!\n", pilhaPoupanca.peek().getPorcRendimento());
                                registros.add(pilhaPoupanca.pop());
                                break;
                            case 2:
                                do {
                                    System.out.print("Informe o capital inicial (R$): ");
                                    capital = sc.nextDouble();
                                    if (capital <= 0) {
                                        System.out.println("O investimento inicial não deve ser menor ou igual a 0");
                                    }
                                } while (capital <= 0);
                                do {
                                    System.out.print("Informe o tempo em anos: ");
                                    tempo = sc.nextInt();
                                    if (tempo <= 0) {
                                        System.out.println("O tempo não pode ser negativo ou igual a zero!");
                                    }
                                } while (tempo <= 0);
                                pilhaCDB.push(new CDB(capital, tempo));
                                pilhaCDB.peek().calcValorFinal();
                                System.out.print("Resultado de " + pilhaCDB.peek().getTempoInvestido() + (pilhaCDB.peek().getTempoInvestido() == 1 ? " ano" : " anos") + ": ");
                                System.out.printf("R$%.2f\n", pilhaCDB.peek().getMontante());
                                System.out.printf("Rendeu %.2f%%!\n", pilhaCDB.peek().getPorcRendimento());
                                registros.add(pilhaCDB.pop());
                                break;
                            case 3:
                                do {
                                    System.out.print("Informe o capital inicial (R$): ");
                                    capital = sc.nextDouble();
                                    if (capital <= 0) {
                                        System.out.println("O investimento inicial não deve ser menor ou igual a 0");
                                    }
                                } while (capital <= 0);
                                do {
                                    System.out.print("Informe o tempo em anos: ");
                                    tempo = sc.nextInt();
                                    if (tempo <= 0) {
                                        System.out.println("O tempo não pode ser negativo ou igual a zero!");
                                    }
                                } while (tempo <= 0);
                                pilhaTSelic.push(new TesouroSelic(capital, tempo));
                                pilhaTSelic.peek().calcValorFinal();
                                System.out.print("Resultado de " + pilhaTSelic.peek().getTempoInvestido() + (pilhaTSelic.peek().getTempoInvestido() == 1 ? " ano" : " anos") + ": ");
                                System.out.printf("R$%.2f\n", pilhaTSelic.peek().getMontante());
                                System.out.printf("Rendeu %.2f%%!\n", pilhaTSelic.peek().getPorcRendimento());
                                registros.add(pilhaTSelic.pop());
                                break;
                            case 4:
                                do {
                                    System.out.print("Informe o capital inicial (R$): ");
                                    capital = sc.nextDouble();
                                    if (capital <= 0) {
                                        System.out.println("O investimento inicial não deve ser menor ou igual a 0");
                                    }
                                } while (capital <= 0);
                                do {
                                    System.out.print("Informe o tempo em meses: ");
                                    tempo = sc.nextInt();
                                    if (tempo <= 0) {
                                        System.out.println("O tempo não pode ser negativo ou igual a zero!");
                                    }
                                } while (tempo <= 0);
                                pilhaAcoes.push(new Acao(capital, tempo));
                                pilhaAcoes.peek().calcValorFinal();
                                System.out.print("Resultado de " + pilhaAcoes.peek().getTempoInvestido() + (pilhaAcoes.peek().getTempoInvestido() == 1 ? " mês" : " meses") + ": ");
                                System.out.printf("R$%.2f\n", pilhaAcoes.peek().getMontante());
                                System.out.print(pilhaAcoes.peek().getPorcRendimento() < 0 ? "Desvalorizou " : "Valorizou ");
                                System.out.println(pilhaAcoes.peek().getPorcRendimento() < 0 ? String.format("%.2f", Math.abs(pilhaAcoes.peek().getPorcRendimento())) + "%" : String.format("%.2f", pilhaAcoes.peek().getPorcRendimento()) + "%");
                                registros.add(pilhaAcoes.pop());
                                break;
                            default:
                                System.out.println("Tipo inválido!");
                        }

                    } while (tipo != 0);
                    break;
                case 2:
                    if (registros.isEmpty()) {
                        System.out.println("Nenhuma simulação feita!");
                        break;
                    }

                    for (TipoInvestimento r : registros.getRegistros()) {
                        System.out.println(r);
                    }

                    break;
                case 3:
                    if (registros.isEmpty()) {
                        System.out.println("Nenhuma simulação feita!");
                        break;
                    }
                    int idProcura, indexProcura;
                    do {
                        System.out.print("Insira um ID para buscar: ");
                        idProcura = sc.nextInt();
                        indexProcura = registros.exists(idProcura);
                        if (indexProcura == -1) {
                            System.out.println("Simulação não encontrada!");
                        }
                    } while (indexProcura == -1);
                    System.out.println(registros.get(indexProcura));
                    break;
                case 4:
                    if (registros.isEmpty()) {
                        System.out.println("Nenhuma simulação feita!");
                        break;
                    }
                    int idRemove, indexRemove;
                    do {
                        System.out.print("Insira um ID para remover: ");
                        idRemove = sc.nextInt();
                        indexRemove = registros.exists(idRemove);
                        if (indexRemove == -1) {
                            System.out.println("Simulação não encontrada!");
                        }
                    } while (indexRemove == -1);
                    sc.nextLine();
                    char confirm;
                    do {
                        System.out.println("\"" + registros.get(indexRemove) + "\"");
                        System.out.print("Tem certeza que deseja remover? [S/N]: ");
                        confirm = sc.nextLine().toUpperCase().charAt(0);
                        if (confirm == 'S') {
                            registros.remove(indexRemove);
                            System.out.println("Simulação removida!");
                            break;
                        } else if (confirm != 'N') {
                            System.out.println("Opção inválida!");
                        }
                    } while (confirm != 'N');
                    break;
                case 5:
                    if (registros.isEmpty()) {
                        System.out.println("Nenhuma simulação feita!");
                        break;
                    }
                    int idEdit, indexEdit;
                    do {
                        System.out.print("Insira um ID para editar: ");
                        idEdit = sc.nextInt();
                        indexEdit = registros.exists(idEdit);
                        if (indexEdit == -1) {
                            System.out.println("Simulação não encontrada!");
                        }
                    } while (indexEdit == -1);
                    System.out.println("Digite o atributo para editar: ");
                    System.out.println("1. Capital inicial (R$)");
                    System.out.println("2. Quantidade de tempo");
                    System.out.print("Resposta: ");
                    int resp = sc.nextInt();
                    sc.nextLine();
                    switch (resp) {
                        case 1:
                            do {
                                System.out.println("Capital inicial antiga: R$" + String.format("%.2f", registros.get(indexEdit).getCapital()));
                                System.out.print("Novo capital inicial (R$): ");
                                capital = sc.nextDouble();
                                if (capital <= 0) {
                                    System.out.println("O investimento inicial não deve ser menor ou igual a 0");
                                }
                            } while (capital <= 0);
                            registros.get(indexEdit).setCapital(capital);
                            System.out.println("O investimento foi atualizado com novos valores!");
                            break;
                        case 2:

                            boolean isAnual = registros.get(indexEdit).getClass().getSuperclass().getSimpleName().equals("InvestimentoAnual");
                            do {
                                System.out.println("Tempo antigo: " + registros.get(indexEdit).getTempoInvestido() + registros.get(indexEdit).getTextoTempoInvestido());
                                System.out.print(isAnual ? "Informe o tempo em anos: " : "Informe o tempo em meses: ");
                                tempo = sc.nextInt();
                                if (tempo <= 0) {
                                    System.out.println("O tempo não pode ser negativo ou igual a zero!");
                                }
                            } while (tempo <= 0);
                            registros.get(indexEdit).setTempoInvestido(tempo);
                            System.out.println("O investimento foi atualizado com novo tempo!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }while(opc != 0);
        sc.close();

        if (!registros.isEmpty()) new RegistroEmArquivo(registros);
    }
}