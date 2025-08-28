package br.com.quintain.defensiumapi.transfer;

import br.com.quintain.defensiumapi.entity.SistemaEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequestTransfer {

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String nome;

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String usuario;

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String senha;

    @NotNull(message = "O sistema não pode nulo!")
	private SistemaEntity sistemaEntity;

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

    public SistemaEntity getSistemaEntity() {
        return sistemaEntity;
    }

    public void setSistemaEntity(SistemaEntity sistemaEntity) {
        this.sistemaEntity = sistemaEntity;
    }

}
