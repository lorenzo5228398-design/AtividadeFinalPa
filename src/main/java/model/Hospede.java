/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno.saolucas
 */
public class Hospede {

    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String sexo;
    private String senha;

    public Hospede() {
    }

    public Hospede(String nome, int idade, String cpf, String sexo, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
        this.senha = senha;
    }

    public Hospede(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean verificarSenhasIguais(String senha, String senhaConfirmada) {

        return senha.equals(senhaConfirmada);

    }
}
