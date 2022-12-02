package model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="alunos")
public class Aluno {
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String dataNascimento;
	private String naturalidade;
	private String endereco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String toString() {
		return "id: " + this.id + " | " + "Nome: " + this.nome + " | " + "Email: " + this.email + " | " 
	+ "Cpf: " + this.cpf + " | " + "Nascimento: " + this.dataNascimento + " | " + "Naturalidade: " + this.naturalidade 
	+ " | " + "Endereco: " + this.endereco;
	}
}
