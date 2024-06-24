package utils;

import java.util.ArrayList;

import models.*;

public class Verificacao {
    private ArrayList<DadosContas> dados;

    public Verificacao(ArrayList<DadosContas> dados){
        this.dados = dados;
    }
    
    public boolean veirficarSenha(String senha, int numero) {
        if (senha.equals(dados.get(numero).getSenha())) {
            return true;
        }else {
            return false;
        }
    }
}
