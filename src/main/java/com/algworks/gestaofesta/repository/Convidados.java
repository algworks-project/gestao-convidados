package com.algworks.gestaofesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algworks.gestaofesta.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {
}