package br.com.quintain.defensiumapi.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario", schema = "public")
@FilterDef(
    name = "sistemaFilter",
    parameters = @ParamDef(name = "id_sistema", type = Long.class)
)
@Filter(name = "sistemaFilter", condition = "id_sistema = :id_sistema")
public class UsuarioEntity implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code", updatable = false, nullable = false)
	private Long code;

	@Column(name = "code_public", updatable = false, nullable = false)
	private UUID codePublic;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sistema", nullable = false)
	private SistemaEntity sistemaEntity;

	@Column(name = "nome", length = 200, nullable = false)
	private String nome;

	@Column(name = "usuario", length = 100, nullable = false)
	private String usuario;

	@Column(name = "senha", length = 255, nullable = false)
	private String senha;

	@JsonIgnore
	@OneToMany(mappedBy = "usuarioEntity", fetch = FetchType.EAGER)
	private List<UsuarioPerfilEntity> usuarioPerfilEntityList;

	@Column(name = "data_criacao", updatable = false, nullable = false)
	private LocalDateTime dataCriacao;

	@Column(name = "data_edicao")
	private LocalDateTime dataEdicao;

	@Column(name = "data_delecao", updatable = false)
	private LocalDateTime dataDelecao;

	@Column(name = "active", nullable = false)
	private Boolean active;

	public UsuarioEntity() {
		this.codePublic = UUID.randomUUID();
		this.dataCriacao = LocalDateTime.now();
		this.active = true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.usuarioPerfilEntityList == null || this.usuarioPerfilEntityList.isEmpty()) {
			return List.of();
		}
		return usuarioPerfilEntityList
			.stream()
			.map(UsuarioPerfilEntity::getPerfilEntity)
			.map(PerfilEntity::getDescricao)
			.map(descricao -> new SimpleGrantedAuthority("ROLE_" + descricao.toUpperCase()))
			.toList();
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.usuario;
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

	public List<UsuarioPerfilEntity> getUsuarioPerfilEntityList() {
		return usuarioPerfilEntityList;
	}

	public void setUsuarioPerfilEntityList(List<UsuarioPerfilEntity> usuarioPerfilEntityList) {
		this.usuarioPerfilEntityList = usuarioPerfilEntityList;
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

	public SistemaEntity getSistemaEntity() {
		return sistemaEntity;
	}

	public void setSistemaEntity(SistemaEntity sistemaEntity) {
		this.sistemaEntity = sistemaEntity;
	}

}
