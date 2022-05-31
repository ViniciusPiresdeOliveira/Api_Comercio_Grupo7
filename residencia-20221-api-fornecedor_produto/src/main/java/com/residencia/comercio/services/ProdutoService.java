package com.residencia.comercio.services;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.residencia.comercio.dtos.CategoriaDTO;
import com.residencia.comercio.dtos.FornecedorDTO;
import com.residencia.comercio.dtos.ProdutoDTO;
import com.residencia.comercio.entities.Categoria;
import com.residencia.comercio.entities.Fornecedor;
import com.residencia.comercio.entities.Produto;
import com.residencia.comercio.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	FornecedorService fornecedorService;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(Integer id) {
		return produtoRepository.findById(id).isPresent() ? produtoRepository.findById(id).get() : null;
	}

	public ProdutoDTO findDTOById(Integer id) {
		Produto produto = produtoRepository.findById(id).isPresent() ? produtoRepository.findById(id).get() : null;
		ProdutoDTO produtoDTO = new ProdutoDTO();
        if (null != produto) {
            produtoDTO = converterEntidadeParaDto(produto);
        }
        return produtoDTO;
    
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public ProdutoDTO saveProdutoDTO(ProdutoDTO produtoDTO) {
		Produto produto = convertDTOToEntidade(produtoDTO);
		Produto produtoNovo = produtoRepository.save(produto);
		return converterEntidadeParaDto(produtoNovo);
	}

	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto updateComId(Produto produto, Integer id) {
		Produto produtoBD = produtoRepository.findById(id).isPresent() ? produtoRepository.findById(id).get() : null;

		Produto produtoAtualizado = null;
		if (produtoBD != null) {
			produtoBD.setCategoria(produto.getCategoria());
			produtoBD.setFornecedor(produto.getFornecedor());
			produtoBD.setIdProduto(produto.getIdProduto());
			produtoBD.setNomeProduto(produto.getNomeProduto());
			produtoBD.setSku(produto.getSku());

			produtoAtualizado = produtoRepository.save(produtoBD);
		}
		return produtoAtualizado;
	}

	public void deletePorId(Integer id) {
		produtoRepository.deleteById(id);
	}

	private Produto convertDTOToEntidade(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();

		produto.setIdProduto(produtoDTO.getIdProduto());
		produto.setNomeProduto(produtoDTO.getNomeProduto());
		produto.setSku(produtoDTO.getSku());
		Categoria categoria = categoriaService.findCategoriaById(produtoDTO.getCategoriaDTO().getIdCategoria());
		produto.setCategoria(categoria);
		Fornecedor fornecedor = fornecedorService.findFornecedorById(produtoDTO.getFornecedorDTO().getIdFornecedor());
		produto.setFornecedor(fornecedor);

		return produto;
	}

	private ProdutoDTO converterEntidadeParaDto(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setIdProduto(produto.getIdProduto());
		produtoDTO.setNomeProduto(produto.getNomeProduto());
		produtoDTO.setSku(produto.getSku());
		CategoriaDTO categoriaDTO = categoriaService.findCategoriaDTOById(produto.getCategoria().getIdCategoria());
		produtoDTO.setCategoriaDTO(categoriaDTO);
		FornecedorDTO fornecedorDTO = fornecedorService.findFornecedorDTOById(produto.getFornecedor().getIdFornecedor());
		produtoDTO.setFornecedorDTO(fornecedorDTO);

		return produtoDTO;
	}

}
