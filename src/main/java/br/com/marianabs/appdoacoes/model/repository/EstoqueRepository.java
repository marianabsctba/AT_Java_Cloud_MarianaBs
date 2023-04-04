package br.com.marianabs.appdoacoes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marianabs.appdoacoes.model.domain.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {}