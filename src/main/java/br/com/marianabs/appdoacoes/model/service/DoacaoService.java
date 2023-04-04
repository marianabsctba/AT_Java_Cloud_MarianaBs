package br.com.marianabs.appdoacoes.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marianabs.appdoacoes.model.domain.Doacao;
import br.com.marianabs.appdoacoes.model.repository.DoacaoRepository;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    public Optional<Doacao> findById(Integer id) {
        return doacaoRepository.findById(id);
    }

    public Doacao incluir(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }
        

    public void excluir(Integer id) {
        doacaoRepository.deleteById(id);
    }
    
    public Doacao editar(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }
   

}