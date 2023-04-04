package br.com.marianabs.appdoacoes.model.service;

import br.com.marianabs.appdoacoes.model.domain.Doacao;
import br.com.marianabs.appdoacoes.model.domain.Estoque;
import br.com.marianabs.appdoacoes.model.repository.EstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    public Optional<Estoque> findById(Integer id) {
        return estoqueRepository.findById(id);
    }

    public Estoque incluir(Estoque doacao) {
        return estoqueRepository.save(doacao);
    }
    
    public Estoque editar(Estoque doacao) {
        return estoqueRepository.save(doacao);
    }

    public void excluir(Integer id) {
        estoqueRepository.deleteById(id);
    }

}