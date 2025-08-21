package br.com.quintain.defensiumapi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario_perfil", schema = "public")
public class UsuarioPerfilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code", updatable = false, nullable = false)
	private Long code;

	@Column(name = "code_public", unique = true, updatable = false, nullable = false)
	private String codePublic;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private UsuarioEntity usuarioEntity;

	@ManyToOne
	@JoinColumn(name = "id_perfil", nullable = false)
	private PerfilEntity perfilEntity;

	@Column(name = "data_criacao", updatable = false, nullable = false)
	private LocalDateTime dataCriacao;

	@Column(name = "data_edicao")
	private LocalDateTime dataEdicao;

	@Column(name = "data_delecao", updatable = false)
	private LocalDateTime dataDelecao;

	@Column(name = "active", nullable = false)
	private Boolean active;

	public UsuarioPerfilEntity() { }

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCodePublic() {
		return codePublic;
	}

	public void setCodePublic(String codePublic) {
		this.codePublic = codePublic;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
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
