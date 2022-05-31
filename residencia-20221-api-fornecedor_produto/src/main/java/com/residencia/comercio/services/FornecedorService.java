package com.residencia.comercio.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.comercio.dtos.CadastroEmpresaCepDTO;
import com.residencia.comercio.dtos.CadastroEmpresaReceitaDTO;
import com.residencia.comercio.dtos.FornecedorDTO;
import com.residencia.comercio.entities.Fornecedor;
import com.residencia.comercio.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	FornecedorRepository fornecedorRepository;
	/*List<Fornecedor> fornecedorList = fornecedorService.findAllFornecedor();
		return new ResponseEntity<>(fornecedorList, HttpStatus.OK);*/
	public List<Fornecedor> findAllFornecedor() {
		return fornecedorRepository.findAll();
	}

	public Fornecedor findFornecedorById(Integer id) {
		return fornecedorRepository.findById(id).isPresent() ? fornecedorRepository.findById(id).get() : null;
	}

	public FornecedorDTO findFornecedorDTOById(Integer id) {
		Fornecedor fornecedor = fornecedorRepository.findById(id).isPresent() ? fornecedorRepository.findById(id).get()
				: null;

		FornecedorDTO fornecedorDTO = new FornecedorDTO();
		if (null != fornecedor) {
			fornecedorDTO = converterEntidadeParaDto(fornecedor);
		}
		return fornecedorDTO;
	}

	public Fornecedor saveFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public FornecedorDTO saveFornecedorDTO(FornecedorDTO fornecedorDTO) {

		Fornecedor fornecedor = convertDTOToEntidade(fornecedorDTO);
		Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
		return converterEntidadeParaDto(novoFornecedor);
	}
	
	public Fornecedor saveFornecedorCnpj(String cnpj) throws ParseException {
        Fornecedor novoFornecedor = fornecedorCnpj(cnpj);
        return fornecedorRepository.save(novoFornecedor);
    }

	public Fornecedor updateFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public void deleteFornecedor(Integer id) {
		Fornecedor inst = fornecedorRepository.findById(id).get();
		fornecedorRepository.delete(inst);
	}

	public void deleteFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
	}

	private Fornecedor convertDTOToEntidade(FornecedorDTO fornecedorDTO) {
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setBairro(fornecedorDTO.getBairro());
		fornecedor.setCep(fornecedorDTO.getCep());
		fornecedor.setCnpj(fornecedorDTO.getCnpj());
		fornecedor.setComplemento(fornecedorDTO.getComplemento());
		fornecedor.setDataAbertura(fornecedorDTO.getDataAbertura());
		fornecedor.setEmail(fornecedorDTO.getEmail());
		fornecedor.setIdFornecedor(fornecedorDTO.getIdFornecedor());
		fornecedor.setLogradouro(fornecedorDTO.getLogradouro());
		fornecedor.setMunicipio(fornecedorDTO.getMunicipio());
		fornecedor.setNomeFantasia(fornecedorDTO.getNomeFantasia());
		fornecedor.setNumero(fornecedorDTO.getNumero());
		fornecedor.setRazaoSocial(fornecedorDTO.getRazaoSocial());
		fornecedor.setStatusSituacao(fornecedorDTO.getStatusSituacao());
		fornecedor.setTelefone(fornecedorDTO.getTelefone());
		fornecedor.setTipo(fornecedorDTO.getTipo());
		fornecedor.setUf(fornecedorDTO.getUf());
		return fornecedor;
	}

	private FornecedorDTO converterEntidadeParaDto(Fornecedor fornecedor) {
		FornecedorDTO fornecedorDTO = new FornecedorDTO();
		fornecedorDTO.setBairro(fornecedor.getBairro());
		fornecedorDTO.setCep(fornecedor.getCep());
		fornecedorDTO.setCnpj(fornecedor.getCnpj());
		fornecedorDTO.setComplemento(fornecedor.getComplemento());
		fornecedorDTO.setDataAbertura(fornecedor.getDataAbertura());
		fornecedorDTO.setEmail(fornecedor.getEmail());
		fornecedorDTO.setIdFornecedor(fornecedor.getIdFornecedor());
		fornecedorDTO.setLogradouro(fornecedor.getLogradouro());
		fornecedorDTO.setMunicipio(fornecedor.getMunicipio());
		fornecedorDTO.setNomeFantasia(fornecedor.getNomeFantasia());
		fornecedorDTO.setNumero(fornecedor.getNumero());
		fornecedorDTO.setRazaoSocial(fornecedor.getRazaoSocial());
		fornecedorDTO.setStatusSituacao(fornecedor.getStatusSituacao());
		fornecedorDTO.setTelefone(fornecedor.getTelefone());
		fornecedorDTO.setTipo(fornecedor.getTipo());
		fornecedorDTO.setUf(fornecedor.getUf());
		return fornecedorDTO;
	}

	public CadastroEmpresaReceitaDTO consultarDadosPorCnpj(String cnpj) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://www.receitaws.com.br/v1/cnpj/{cnpj}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("cnpj", cnpj);

		CadastroEmpresaReceitaDTO cadastroEmpresaReceitaDTO = restTemplate.getForObject(uri,
				CadastroEmpresaReceitaDTO.class, params);

		return cadastroEmpresaReceitaDTO;
	}

	public CadastroEmpresaCepDTO consultarDadosPorCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json";
		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);

		CadastroEmpresaCepDTO cadastroEmpresaCepDTO = restTemplate.getForObject(uri, CadastroEmpresaCepDTO.class,
				params);

		return cadastroEmpresaCepDTO;
	}

	public Fornecedor fornecedorCnpj(String cnpj) throws ParseException {
		CadastroEmpresaReceitaDTO cert = consultarDadosPorCnpj(cnpj);
		Fornecedor fornecedorCnpj = new Fornecedor();

		fornecedorCnpj.setBairro(cert.getBairro());
		fornecedorCnpj.setCep(cert.getCep());
		fornecedorCnpj.setComplemento(cert.getComplemento());
		fornecedorCnpj.setCnpj(cert.getCnpj());
		fornecedorCnpj.setEmail(cert.getEmail());
		fornecedorCnpj.setLogradouro(cert.getLogradouro());
		fornecedorCnpj.setMunicipio(cert.getMunicipio());
		fornecedorCnpj.setNomeFantasia(cert.getFantasia());
		fornecedorCnpj.setStatusSituacao(cert.getSituacao());
		fornecedorCnpj.setTipo(cert.getTipo());
		fornecedorCnpj.setTelefone(cert.getTelefone());
		fornecedorCnpj.setRazaoSocial(cert.getNome());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = formato.parse(cert.getAbertura());
		fornecedorCnpj.setDataAbertura(dataFormatada);
		fornecedorCnpj.setUf(cert.getUf());

		return fornecedorCnpj;
	}
}
