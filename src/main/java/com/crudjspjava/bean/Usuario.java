package com.crudjspjava.bean;

public class Usuario {

	private int id;
	private String nome;
	private String sexo;
	private String cidade;
	private String hobby;
	private String datanascimento;

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String date) {
		this.datanascimento = date;
	}

}