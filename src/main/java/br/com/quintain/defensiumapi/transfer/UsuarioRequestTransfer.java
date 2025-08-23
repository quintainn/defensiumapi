package br.com.quintain.defensiumapi.transfer;

import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestTransfer {

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String nome;

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String usuario;

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String senha;

    public UsuarioRequestTransfer() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

}
