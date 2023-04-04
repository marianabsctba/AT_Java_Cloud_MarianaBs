package br.com.marianabs.appdoacoes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marianabs.appdoacoes.model.domain.Doacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {}