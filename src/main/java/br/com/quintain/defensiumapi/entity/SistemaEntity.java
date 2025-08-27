package br.com.quintain.defensiumapi.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sistema", schema = "public")
public class SistemaEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code", updatable = false, nullable = false)
	private Long code;

	@Column(name = "code_public", updatable = false, nullable = false)
	private UUID codePublic;

    @Column(name = "codigo_integracao", unique = true)
    private String codigoIntegracao;

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

    @Column(name = "url", unique = true)
    private String url;

	@Column(name = "data_criacao", updatable = false, nullable = false)
	private LocalDateTime dataCriacao;

	@Column(name = "data_edicao")
	private LocalDateTime dataEdicao;

	@Column(name = "data_delecao", updatable = false)
	private LocalDateTime dataDelecao;

	@Column(name = "active", nullable = false)
	private Boolean active;

    public SistemaEntity() {
        this.codePublic = UUID.randomUUID();
		this.dataCriacao = LocalDateTime.now();
		this.active = true;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public UUID getCodePublic() {
        return codePublic;
    }

    public void setCodePublic(UUID codePublic) {
        this.codePublic = codePublic;
    }

    public String getCodigoIntegracao() {
        return codigoIntegracao;
    }

    public void setCodigoIntegracao(String codigoIntegracao) {
        this.codigoIntegracao = codigoIntegracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(LocalDateTime dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public LocalDateTime getDataDelecao() {
        return dataDelecao;
    }

    public void setDataDelecao(LocalDateTime dataDelecao) {
        this.dataDelecao = dataDelecao;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
