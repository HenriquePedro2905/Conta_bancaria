package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import models.DadosContas;

public class SalvarDados {
    
    static final String FILENAME = "src\\models\\dados.txt";
    private ArrayList<DadosContas> dados;
    public SalvarDados(ArrayList<DadosContas> dados){
        this.dados = dados;
    }

    public void salvar(ArrayList<DadosContas> dados) {
        // Abre um BufferedWriter para escrever em um arquivo (FILENAME é uma variável ou constante com o nome do arquivo)
        try (BufferedWriter writer =  new BufferedWriter(new FileWriter(FILENAME))){
            for(DadosContas dado : dados){
                writer.write(dado.getTitular() + "," + dado.getSaldo() + "," + dado.getNumeroDaConta() + "," + dado.getSenha()); 
                writer.newLine();;
            }
            System.out.println("dados cadastrado com sucesso1");
        } catch (IOException e) {
            System.out.println("erro ao carregar dados" + e.getMessage());
        }
    }

    public void carregarDados(ArrayList<DadosContas> dados) {
       // Abre um BufferedReader para ler o arquivo (FILENAME é uma variável ou constante com o nome do arquivo)
        try(BufferedReader reader = new BufferedReader(new FileReader(FILENAME))){
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] informa = linha.split(",");
                if(informa.length == 4){
                    DadosContas dado = new DadosContas();
                    dado.setTitular(informa[0]);
                    dado.deposito(Float.parseFloat(informa[1]));
                    dado.setNumeroDaConta(Integer.parseInt(informa[2]));
                    dado.setSenha(informa[3]);
                    dados.add(dado);
                }
            }
            System.out.println("dados carregados com scucesso");
        } catch (FileNotFoundException e) {
            System.out.println("o arquivos de dados nao encontrado. inicicando com lista vazia");
        } catch (IOException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
    }
}
