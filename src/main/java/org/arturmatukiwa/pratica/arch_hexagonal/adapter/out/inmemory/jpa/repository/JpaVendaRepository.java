package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.repository;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaVendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVendaRepository extends JpaRepository<JpaVendaEntity, Long> {

}
