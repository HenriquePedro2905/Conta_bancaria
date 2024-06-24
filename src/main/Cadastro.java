    package main;

    import java.util.Scanner;
    import java.util.ArrayList;
    import interfaces.*;
    import models.DadosContas;
    import utils.InteracaoUsuario;
    import utils.SalvarDados;
    import utils.Verificacao;

    public class Cadastro {
        
        static Scanner sc = new Scanner(System.in);
        static Telas telas = new Telas();
        static ArrayList<DadosContas> dados = new ArrayList<>();
        static Verificacao veri = new Verificacao(dados);
        static InteracaoUsuario interacaoUsuario = new InteracaoUsuario(dados, veri, sc);
        static SalvarDados salvarDados = new SalvarDados(dados);
        public static void main(String[] args) {
            boolean isRuning = true;
            
            salvarDados.carregarDados(dados);

            do {
            telas.menu1();
            System.out.print("Iforme uma opcao:");
            int op = sc.nextInt();
                switch (op) {
                    case 1:
                        criarConta();
                        break;
                    
                    case 2:
                        depositar();
                        break;
                    case 3:
                        veirficarSaldo();
                        break;
                    
                    case 4:
                        sacar();
                        break;

                    case 5:
                        System.out.println("saindo do sistema");
                        isRuning = false;
                    default:
                        break;
                }
                
            } while (isRuning);

            salvarDados.salvar(dados);
        }

        static void criarConta(){
            float valor = 0;

            System.out.print("iforme o nome do titular da conta:");
            sc.nextLine();
            String titular = sc.nextLine();
            System.out.print("crie uma senha segura para sua conta:");
            String senha = sc.nextLine();

            int numConta = dados.size() - 1;

            System.out.print("Deseja depositar algum valor em sua nova conta:");
            String resposta = sc.nextLine();

            if (resposta.toLowerCase().equals("sim")) {
                System.out.print("informe o valor depositado:");
                valor = sc.nextFloat();
            }else{
                valor = 0;
            }

            DadosContas dado = new DadosContas();
            dado.setTitular(titular);
            dado.setSenha(senha);
            dado.setNumeroDaConta(numConta);
            dado.deposito(valor);

            if (dado.isValid()) {
                dados.add(dado);
                System.out.println("Cadastro concluido com sucesso");
                System.out.println("numero da sua conta:" + (dados.size() - 1) );
            } else {
                System.out.println("erro ao tentar criar sua conta tente novamente");
            }
        }

        static void depositar(){
            int numero = interacaoUsuario.solicitarNumeroConta();

            if (numero == -1) return;
                System.out.print("infrome o valor do deposito:");
                float valor = sc.nextFloat();
                dados.get(numero).deposito(valor);
        }

        static void veirficarSaldo(){
            int numero = interacaoUsuario.solicitarNumeroConta();
            if (numero == -1) return;
            System.out.println("saldo:" + dados.get(numero).getSaldo());
            
        }

        static void sacar(){
            int numero = interacaoUsuario.solicitarNumeroConta();

            if (numero == -1) return;
                System.out.print("infrome o valor do saque:");
                float valorSaque = sc.nextFloat();
                dados.get(numero).saque(valorSaque);
        }

    }
