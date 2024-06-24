package utils;

import java.util.ArrayList;
import java.util.Scanner;

import models.DadosContas;

public class InteracaoUsuario {
    
    private ArrayList<DadosContas> dados;
    private Verificacao veri;
    private Scanner sc;

    public InteracaoUsuario(ArrayList<DadosContas> dados, Verificacao veri, Scanner sc){
        this.dados = dados;
        this.veri = veri;
        this.sc = sc;
    }

    public int solicitarNumeroConta(){
        System.out.print("informe o numero da sua conta:");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.print("informe sua senha:");
            String senha = sc.nextLine();

            if (veri.veirficarSenha(senha, numero)) {
                return numero;
            } else {
                System.out.println("senha incorreta");
                return -1;
            }
    }
}
