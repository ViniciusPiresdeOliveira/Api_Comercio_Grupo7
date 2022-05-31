package com.residencia.comercio.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.comercio.dtos.ProdutoDTO;
import com.residencia.comercio.entities.Produto;
import com.residencia.comercio.exceptions.NoSuchElementFoundException;
import com.residencia.comercio.services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/produto")
@Validated
@Tag(name = "Produtos", description = "Endpoints")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping
	@Operation(summary = "Listar todos os Produtos.")
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtoList = produtoService.findAll();
		if (produtoList.isEmpty()) {
			throw new NoSuchElementFoundException("Não foram encontrados Produtos");
		}
		return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/id")
	@Operation(summary = "Listar um Produto pelo ID.")
	public ResponseEntity<Produto> findByIdRequest(@RequestParam @NotBlank Integer id) {
		Produto produto = produtoService.findById(id);
		if (produto == null) {
			throw new NoSuchElementFoundException("Não foi encontrado Produto com o ID: " + id);
		} else {
			return new ResponseEntity<>(produto, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	@Operation(summary = "Listar um Produto pelo ID.")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto produto = produtoService.findById(id);
		if (produto == null) {
			throw new NoSuchElementFoundException("Não foi encontrado Produto com o ID: " + id);
		} else {
			return new ResponseEntity<>(produto, HttpStatus.OK);
		}
	}

	/*@GetMapping("/query")
	public ResponseEntity<Produto> findByIdQuery(
			@RequestParam @NotBlank(message = "O sku deve ser preenchido.") String sku) {
		return new ResponseEntity<>(null, HttpStatus.CONTINUE);
	}*/
	/*
	@GetMapping("/request")
	public ResponseEntity<Produto> findByIdRequest1(
			@RequestParam @NotBlank(message = "O id deve ser preenchido.") Integer id) {
		return new ResponseEntity<>(null, HttpStatus.CONTINUE);
	}*/

	@PostMapping
	@Operation(summary = "Postar um Produto.")
	public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
		Produto novoProduto = produtoService.save(produto);
		return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
	}

	@PostMapping("/dto")
	@Operation(summary = "Postar um Produto através de DTO.")
	public ResponseEntity<ProdutoDTO> saveDTO(@RequestBody ProdutoDTO produtoDTO) {
		ProdutoDTO novoProdutoDTO = produtoService.saveProdutoDTO(produtoDTO);
		return new ResponseEntity<>(novoProdutoDTO, HttpStatus.CREATED);
	}

	@PutMapping
	@Operation(summary = "Atualizar um Produto.")
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {
		Produto produtoAtualizado = produtoService.update(produto);
		return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um Produto pelo ID.")
	public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto produto) {
		Produto produtoAtualizado = produtoService.updateComId(produto, id);
		if (null == produtoAtualizado)
			return new ResponseEntity<>(produtoAtualizado, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar um Produto pelo ID.")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Produto produto = produtoService.findById(id);
        if (null == produto) {
            throw new NoSuchElementFoundException("Não foi possível excluir o Produto de id: " + id + ", ele não existe");
        } else {
            produtoService.deletePorId(id);
            return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
        }
    }
}
