package br.com.marianabs.appdoacoes.quotation.controller;

import br.com.marianabs.appdoacoes.model.domain.Estoque;
import br.com.marianabs.appdoacoes.model.service.DoacaoService;
import br.com.marianabs.appdoacoes.model.service.EstoqueService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a lista de estoques"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})

@RequestMapping("/api/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;


    @ApiOperation(value = "Criar", response = Estoque.class)
    @PostMapping
    public ResponseEntity<Estoque> create(@RequestBody Estoque estoque) {
        try {
            Estoque estoqueSalvo = estoqueService.incluir(estoque);
            return new ResponseEntity<>(estoqueSalvo, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @ApiOperation(value = "Editar", response = Estoque.class)
    @PutMapping("/{id}")
    public ResponseEntity<Estoque> update(@PathVariable Integer id, @RequestBody Estoque estoque) {
        Optional<Estoque> doacaoOp = estoqueService.findById(id);
        if (doacaoOp.isPresent()) {
            estoque.setId(id);
            
            Estoque doacaoSalva = estoqueService.editar(estoque);
            return new ResponseEntity<>(doacaoSalva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Excluir")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Optional<Estoque> doacaoOp = estoqueService.findById(id);
        if (doacaoOp.isPresent()) {
            estoqueService.excluir(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(value = "Listar", response = List.class)
    @GetMapping
    public List<Estoque> findAll() {
        return estoqueService.findAll();
    }

    @ApiOperation(value = "Buscar por id", response = Estoque.class)
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> findById(@PathVariable Integer id) {
        Optional<Estoque> estoque = estoqueService.findById(id);
        if (estoque.isPresent()) {
            return new ResponseEntity<>(estoque.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
