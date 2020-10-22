import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marcelo Baraldi
 * PUC-PR - Análise e Desenvolvimento de Sistemas
 * Introdução à POO
 * Maio 2020
 *
 * Prof Tutor: Lucas Oliveira
 */

public class FolhaPagamento {

public static ArrayList<Funcionario> funcionarios;



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(" -------------------------------------------------");
        System.out.println("| BEM VINDO AO SISTEMA DE REGISTRO DE PROFESSORES |");
        System.out.println(" -------------------------------------------------");

        System.out.println("\nDigite o número de funcionários para serem registrados:");
        int qteFuncionarios = scan.nextInt();scan.nextLine();

        //Inicia listas
        funcionarios = new ArrayList<>();


        //Leitura de dados
        for(int i = 0; i < qteFuncionarios; i++) {
            System.out.println("\nCadastro " + (i + 1) + " de " + qteFuncionarios);
            System.out.println("Digite o código do funcionário:");
            int codigoFuncionario = scan.nextInt();
            System.out.println("Digite (1) para Funcionário Concursado ou (2) para Funcionário Temporário");
            int tipoFuncionario = scan.nextInt();
            System.out.println("Digite o salário base:");
            float salarioBase = scan.nextInt();
            System.out.println("Deseja adicionar dependentes? (1) Sim (2) Não");
            int addDependente = scan.nextInt();

            //lista temporária de dependentes
            ArrayList<Dependente> Dependentes = new ArrayList<>();

            //Processo de adição de dependentes
            int qteDependentes = 1;
            while (addDependente == 1){
                System.out.println("Digite a idade do " + qteDependentes + "o dependente");
                int idadeDependente = scan.nextInt();scan.nextLine();

                //instanciando novo dependente
                Dependente depAdicionado = new Dependente(idadeDependente);

                //levando novo dependente para arraylist Dependentes
                Dependentes.add(depAdicionado);

                qteDependentes ++;
                if (qteDependentes == 6) {
                    System.out.println("Quantidade máxima de dependentes alcançada");
                    break;
                }

                System.out.println("Deseja adicionar mais um dependente? (1) Sim (2) Não");
                addDependente = scan.nextInt();
            }
            // FIM DA ENTRADA DE DADOS INICIAL

            //PROCESSAMENTO PARA CONCURSADOS
            if(tipoFuncionario==1){
                System.out.println("Digite a quantidade de anos de serviço na empresa");
                int tempoContrato = scan.nextInt();
                //instanciação do novo funcionário
                FuncionarioConcursado funcionario = new FuncionarioConcursado(codigoFuncionario, salarioBase, tempoContrato);
                //trazendo o objeto dependente para dentro do funcionário
                for(Dependente d: Dependentes) {
                    funcionario.adicionaDependente(d);
                }
                //adicionando funcionário ao ArrayList
                funcionarios.add(funcionario);

            //PROCESSAMENTO PARA TEMPORÁRIOS
            } else if (tipoFuncionario == 2){
                System.out.println("Digite a quantidade de meses do contrato");
                int tempoContrato = scan.nextInt();
                //instanciação do novo funcionário
                FuncionarioTemporario funcionario = new FuncionarioTemporario(codigoFuncionario, salarioBase, tempoContrato);
                //trazendo o objeto dependente para dentro do funcionário
                for(Dependente d: Dependentes) {
                    funcionario.adicionaDependente(d);
                }
                //adicionando funcionário ao ArrayList
                funcionarios.add(funcionario);

            }
        }

        // impressão de dados
        System.out.println("\n\n FUNCIONÁRIOS CADASTRADOS COM ÊXITO \n");
        for(Funcionario func : funcionarios) {
            func.imprimirDados();
        }

        //fechamento
        System.out.println("\n\nObrigado por utilizar o nosso sistema.");
    }
}