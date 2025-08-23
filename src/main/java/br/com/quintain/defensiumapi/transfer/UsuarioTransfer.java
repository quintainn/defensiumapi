package br.com.quintain.defensiumapi.transfer;

import jakarta.validation.constraints.NotBlank;

public class UsuarioTransfer {

	private String codePublic;

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String nome;

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String usuario;

    @NotBlank(message = "A senha não pode ser nula ou vazia!")
	private String senha;

	private String dataCriacao;

	private String dataEdicao;

	private String dataDelecao;

	private String active;

    public UsuarioTransfer() { }

    public String getCodePublic() {
        return codePublic;
    }

    public void setCodePublic(String codePublic) {
        this.codePublic = codePublic;
    }

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

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public String getDataDelecao() {
        return dataDelecao;
    }

    public void setDataDelecao(String dataDelecao) {
        this.dataDelecao = dataDelecao;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    

}
