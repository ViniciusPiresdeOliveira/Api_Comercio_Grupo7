package com.residencia.comercio.dtos;

public class ProdutoDTO {

	private Integer idProduto;
	private String sku;
	private String nomeProduto;
	private FornecedorDTO fornecedorDTO;
	private CategoriaDTO categoriaDTO;

	@Override
	public String toString() {
		return "ProdutoDTO [idProduto=" + idProduto + ", sku=" + sku + ", nomeProduto=" + nomeProduto
				+ ", fornecedorDTO=" + fornecedorDTO + ", categoriaDTO=" + categoriaDTO + "]";
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public FornecedorDTO getFornecedorDTO() {
		return fornecedorDTO;
	}

	public void setFornecedorDTO(FornecedorDTO fornecedorDTO) {
		this.fornecedorDTO = fornecedorDTO;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

}
