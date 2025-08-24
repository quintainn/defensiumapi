package br.com.quintain.defensiumapi.transfer;

public class ExceptionTransfer {

    private String mensagemSistema;

    private String erro;

    private Integer situacao;

    private String dataHoraRequisicao;

    public ExceptionTransfer() { }

    public String getMensagemSistema() {
        return mensagemSistema;
    }

    public void setMensagemSistema(String mensagemSistema) {
        this.mensagemSistema = mensagemSistema;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public String getDataHoraRequisicao() {
        return dataHoraRequisicao;
    }

    public void setDataHoraRequisicao(String dataHoraRequisicao) {
        this.dataHoraRequisicao = dataHoraRequisicao;
    }

}
