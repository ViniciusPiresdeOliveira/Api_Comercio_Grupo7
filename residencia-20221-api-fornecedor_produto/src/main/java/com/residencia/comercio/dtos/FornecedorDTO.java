package com.residencia.comercio.dtos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

public class FornecedorDTO {
	private Integer idFornecedor;
	
	@CNPJ
	@NotBlank(message = "O CNPJ do produto não pode estar vazio")
	private String cnpj;
	
	@NotBlank(message = "O Tipo do produto não pode estar vazio")
	private String tipo;
	
	@NotBlank(message = "A Razão Social do produto não pode estar vazio")
	private String razaoSocial;
	
	@NotBlank(message = "O UF do produto não pode estar vazio")
	private String uf;
	
	@Size(min = 11, max = 15, message = "O telefone deve ter entre 11 e 15 caracteres")
	@NotBlank(message = "O Telefone do produto não pode estar vazio")
	private String telefone;
	
	@Email
	@NotBlank(message = "O Email do produto não pode estar vazio")
	private String email;

	@NotBlank(message = "O Nome Fantasia do produto não pode estar vazio")
	private String nomeFantasia;
	
	@NotBlank(message = "O Status Situação do produto não pode estar vazio")
	private String statusSituacao;
	
	@NotBlank(message = "O Bairro do produto não pode estar vazio")
	private String bairro;
	
	@NotBlank(message = "O Logradouro do produto não pode estar vazio")
	private String logradouro;
	
	private String numero;
	
	@NotBlank(message = "O Complemento do produto não pode estar vazio")
	private String complemento;
	
	@NotBlank(message = "O CEP do produto não pode estar vazio")
	private String cep;
	
	@NotBlank(message = "O Município do produto não pode estar vazio")
	private String municipio;
	
	private Date dataAbertura;
	
	//private List<ProdutoDTO> produtoDTOList;

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getStatusSituacao() {
		return statusSituacao;
	}

	public void setStatusSituacao(String statusSituacao) {
		this.statusSituacao = statusSituacao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Override
	public String toString() {
		return "FornecedorDTO [idFornecedor=" + idFornecedor + ", cnpj=" + cnpj + ", tipo=" + tipo + ", razaoSocial="
				+ razaoSocial + ", uf=" + uf + ", telefone=" + telefone + ", email=" + email + ", nomeFantasia="
				+ nomeFantasia + ", statusSituacao=" + statusSituacao + ", bairro=" + bairro + ", logradouro="
				+ logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + ", municipio="
				+ municipio + ", dataAbertura=" + dataAbertura + "]";
	}

}
