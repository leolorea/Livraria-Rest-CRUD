package br.com.alura.livrariaRest.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String login;
	private String senha;
	private String email;
	private String nome;
	
	@ManyToMany
	@JoinTable(name="perfis_usuarios",
	joinColumns = @JoinColumn(name="usuario_id"),inverseJoinColumns = 
	@JoinColumn(name="perfil_id"))
	private List<Perfil> perfis = new ArrayList<Perfil>();
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return this.perfis;
	}

	@Override
	public String getPassword() {
	
		return senha;
	}

	

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

	public void adicionarPerfil(Perfil perfil) {
		this.perfis.add(perfil);
		
	}

	public Usuario(String login, String senha, String nome) {
		this.senha = senha;
		this.login = login;
		this.nome = nome;
	}

	public void atualizarInfo(String login, String senha, String nome) {
		this.senha = senha;
		this.login = login;
		this.nome = nome;
		
	}

	@Override
	public String getUsername() {
		return login;
	}

	

}
