package model;

public class Adm {

    private String usuario = "Admin";
    private String senha = "admin@123";

    public Adm() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean verificarUsuario(String usuarioPosto) {
        return usuarioPosto.equals(this.usuario);

    }

    public boolean verificarSenha(String senhaPosta) {
        return senhaPosta.equals(this.senha);

    }

}
