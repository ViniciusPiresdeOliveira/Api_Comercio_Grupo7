package com.residencia.comercio.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.comercio.dtos.CadastroEmpresaCepDTO;
import com.residencia.comercio.dtos.CadastroEmpresaReceitaDTO;
import com.residencia.comercio.dtos.FornecedorDTO;
import com.residencia.comercio.entities.Fornecedor;
import com.residencia.comercio.exceptions.NoSuchElementFoundException;
import com.residencia.comercio.services.FornecedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/fornecedor")
@Tag(name = "Fornecedores", description = "Endpoints")
public class FornecedorController {
	@Autowired
	FornecedorService fornecedorService;

	@GetMapping
	@Operation(summary = "Listar todos os Fornecedores.")
	public ResponseEntity<List<Fornecedor>> findAllFornecedor() {
		List<Fornecedor> fornecedorList = fornecedorService.findAllFornecedor();
		return new ResponseEntity<>(fornecedorList, HttpStatus.OK);
	}
	
	@GetMapping("/cnpj/{cnpj}")
	@Operation(summary = "Consultar CNPJ do Fornecedor.")
	public ResponseEntity<CadastroEmpresaReceitaDTO> consultarDadosPorCnpj(String cnpj) {
		CadastroEmpresaReceitaDTO cadEmpresaDTO = fornecedorService.consultarDadosPorCnpj(cnpj);
		if(null == cadEmpresaDTO)
			throw new NoSuchElementFoundException("Não foram encontrados dados para o CNPJ informado");
		else
			return new ResponseEntity<>(cadEmpresaDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{cep}")
	@Operation(summary = "Consultar CEP do Fornecedor.")
	public ResponseEntity<CadastroEmpresaCepDTO> consultarDadosPorCep(String cep) {
		CadastroEmpresaCepDTO cadEmpresaDTO = fornecedorService.consultarDadosPorCep(cep);
		if(null == cadEmpresaDTO)
			throw new NoSuchElementFoundException("Não foram encontrados dados para o CEP informado");
		else
			return new ResponseEntity<>(cadEmpresaDTO, HttpStatus.OK);
	}

	@GetMapping("/dto/{id}")
	@Operation(summary = "Consultar FornecedorDTO pelo ID.")
	public ResponseEntity<FornecedorDTO> findFornecedorDTOById(@PathVariable Integer id) {
		FornecedorDTO fornecedorDTO = fornecedorService.findFornecedorDTOById(id);
		return new ResponseEntity<>(fornecedorDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Consultar Fornecedor pelo ID.")
	public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable Integer id) {
		Fornecedor fornecedor = fornecedorService.findFornecedorById(id);
		if(null == fornecedor)
			throw new NoSuchElementFoundException("Não foi encontrado Fornecedor com o id " + id);
		else
			return new ResponseEntity<>(fornecedor, HttpStatus.OK);
	}
	
	@PostMapping
	@Operation(summary = "Postar um Fornecedor.")
	public ResponseEntity<Fornecedor> saveFornecedor(@RequestParam String cnpj) {
		Fornecedor fornecedor = new Fornecedor();
		Fornecedor novoFornecedor = fornecedorService.saveFornecedor(fornecedor);
		return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
	}

	@PostMapping("/completo")
	@Operation(summary = "Postar um Fornecedor completo.")
	public ResponseEntity<Fornecedor> saveFornecedorCompleto(@RequestBody Fornecedor fornecedor) {
		Fornecedor novoFornecedor = fornecedorService.saveFornecedor(fornecedor);
		return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
	}
	
	@PostMapping("/dto")
	@Operation(summary = "Postar um FornecedorDTO.")
	public ResponseEntity<FornecedorDTO> saveFornecedorDTO(@RequestBody FornecedorDTO fornecedorDTO) {
		FornecedorDTO novoFornecedorDTO = fornecedorService.saveFornecedorDTO(fornecedorDTO);
		return new ResponseEntity<>(novoFornecedorDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/cnpj/{cnpj}")
	@Operation(summary = "Postar um Fornecedor pelo CNPJ usando uma API externa.")
    public ResponseEntity<Fornecedor> saveFornecedorCnpj(@PathVariable String cnpj) throws ParseException {
        Fornecedor novoFornecedor = fornecedorService.saveFornecedorCnpj(cnpj);
        return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
    }
	
	@PutMapping
	@Operation(summary = "Atualizar um Fornecedor.")
	public ResponseEntity<Fornecedor> updateFornecedor(@RequestBody Fornecedor fornecedor) {
		Fornecedor novoFornecedor = fornecedorService.updateFornecedor(fornecedor);
		return new ResponseEntity<>(novoFornecedor, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar um Fornecedor pelo ID.")
	public ResponseEntity<String> deleteFornecedor(@PathVariable Integer id) {
		if(null == fornecedorService.findFornecedorById(id))
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		
		fornecedorService.deleteFornecedor(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

}
