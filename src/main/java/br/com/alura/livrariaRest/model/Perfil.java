package br.com.alura.livrariaRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name = "perfis")
public class Perfil implements GrantedAuthority{
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nome;

@Override
public String getAuthority() {
	return this.nome;
}




}
