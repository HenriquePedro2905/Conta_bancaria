package models;

public class DadosContas {
    
    private String titular;
    private float saldo;
    private String senha;
    private int numeroDaConta;

    public void setTitular(String titular){
        if (!titular.isEmpty()) {
            this.titular = titular;   
        } else {
            System.out.println("preencha o campo titular corretamente");
        }
    }

    public void deposito(float saldo){
        if (saldo >= 0) {
            this.saldo += saldo;
        } else {
            System.out.println("preencha o campo saldo corretamente corretamente");
        }
    }

    public void setSenha(String senha){
        if (!senha.isEmpty()) {
            this.senha = senha;
        } else {
            System.out.println("preencha o campo senha corretamente");
        }
    }

    public void saque(float saque){
        this.saldo -= saque;
    }
   
    public void setNumeroDaConta(int numero){
        this.numeroDaConta = numero;
    }

    public String getTitular(){
        return titular;
    }

    public float getSaldo(){
        return saldo;
    }

    public String getSenha(){
        return senha;
    }

    public int getNumeroDaConta(){
        return numeroDaConta;
    }

    public boolean isValid(){
        return titular != null && !titular.isEmpty() && senha != null && !senha.isEmpty();
    }
}
