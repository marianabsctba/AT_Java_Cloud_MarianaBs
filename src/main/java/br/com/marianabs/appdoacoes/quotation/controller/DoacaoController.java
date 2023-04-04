package br.com.marianabs.appdoacoes.quotation.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.marianabs.appdoacoes.model.domain.Doacao;
import br.com.marianabs.appdoacoes.model.service.DoacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna a lista de doações"),
		@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
@RequestMapping("/api/doacoes")
public class DoacaoController {

	@Autowired
	private DoacaoService doacaoService;
	
	//Usando isPresent para validação
	
	
	@ApiOperation(value = "Editar", response = Doacao.class)
	@PutMapping("/{id}")
	public ResponseEntity<Doacao> update(@PathVariable Integer id, @RequestBody Doacao doacao) {
		Optional<Doacao> doacaoOp = doacaoService.findById(id);
		if (doacaoOp.isPresent()) {
			doacao.setId(id);
			Doacao doacaoSalva = doacaoService.editar(doacao);
			return new ResponseEntity<>(doacaoSalva, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Criar", response = Doacao.class)
	@PostMapping
	public ResponseEntity<Doacao> create(@RequestBody Doacao doacao) {
		Doacao doacaoSalva = doacaoService.incluir(doacao);
		return new ResponseEntity<>(doacaoSalva, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Excluir")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		Optional<Doacao> doacaoOp = doacaoService.findById(id);
		if (doacaoOp.isPresent()) {
			doacaoService.excluir(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Listar", response = List.class)
	@GetMapping
	public List<Doacao> findAll() {
		return doacaoService.findAll();

	}


	@ApiOperation(value = "Buscar por id", response = Doacao.class)
	@GetMapping("/{id}")
	public ResponseEntity<Doacao> findById(@PathVariable Integer id) {
		Optional<Doacao> doacao = doacaoService.findById(id);
		if (doacao.isPresent()) {
			return new ResponseEntity<>(doacao.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
