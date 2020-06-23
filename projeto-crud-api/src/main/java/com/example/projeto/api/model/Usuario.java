package com.example.projeto.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuario")
    private Integer codigo;

    @Column(name = "nm_usuario", length = 200)
    private String nome;

    @Column(name = "dtnasc_usuario", length = 11)
    private Date dtnasc;
    
    @Column(name = "rg_usuario", length = 9)
    private int rg;
    
    @Column(name = "cpf_usuario", length = 11)
    private String cpf;
    
    @Column(name = "sexo_usuario", length = 1)
    private String sexo;
    
    @Column(name = "estcivil_usuario", length = 100)
    private String estcivil;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstcivil() {
		return estcivil;
	}

	public void setEstcivil(String estcivil) {
		this.estcivil = estcivil;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", dtnasc=" + dtnasc + ", rg=" + rg + ", cpf=" + cpf
				+ ", sexo=" + sexo + ", estcivil=" + estcivil + "]";
	}
    
    

}
