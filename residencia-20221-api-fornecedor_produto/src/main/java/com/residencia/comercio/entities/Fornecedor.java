package com.residencia.comercio.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "fornecedor")
@JsonIdentityInfo(scope = Fornecedor.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idFornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private Integer idFornecedor;

	@CNPJ
	@NotBlank(message = "O CNPJ do produto não pode estar vazio")
	@Column(name = "cnpj")
	//@NotEmpty(message = "O número do CNPJ não pode ficar em branco.")
	//@Digits(message="O CNPJ deve conter 14 números.", fraction = 0, integer = 14)
	private String cnpj;

	@NotBlank(message = "O Tipo do produto não pode estar vazio")
	@Column(name = "tipo")
	private String tipo;

	@NotBlank(message = "A Razão Social do produto não pode estar vazio")
	@Column(name = "razao_social")
	private String razaoSocial;

	@NotBlank(message = "O UF do produto não pode estar vazio")
	@Column(name = "uf")
	private String uf;

	@Size(min = 11, max = 15, message = "O telefone deve ter entre 11 e 15 caracteres")
	@NotBlank(message = "O Telefone do produto não pode estar vazio")
	@Column(name = "telefone")
	private String telefone;

	@Email
	@NotBlank(message = "O Email do produto não pode estar vazio")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "O Nome Fantasia do produto não pode estar vazio")
	@Column(name = "nome_fantasia")
	private String nomeFantasia;

	@NotBlank(message = "O Status Situação do produto não pode estar vazio")
	@Column(name = "status_situacao")
	private String statusSituacao;

	@NotBlank(message = "O Bairro do produto não pode estar vazio")
	@Column(name = "bairro")
	private String bairro;

	@NotBlank(message = "O Logradouro do produto não pode estar vazio")
	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private Integer numero;

	@NotBlank(message = "O Complemento do produto não pode estar vazio")
	@Column(name = "complemento")
	private String complemento;

	@NotBlank(message = "O CEP do produto não pode estar vazio")
	@Column(name = "cep")
	private String cep;

	@NotBlank(message = "O Município do produto não pode estar vazio")
	@Column(name = "municipio")
	private String municipio;

	@Column(name = "data_abertura")
	private Date dataAbertura;

	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtoList;

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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

}