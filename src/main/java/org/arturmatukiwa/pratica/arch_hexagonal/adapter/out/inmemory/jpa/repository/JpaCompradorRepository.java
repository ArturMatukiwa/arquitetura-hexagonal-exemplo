package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.repository;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaCompradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaCompradorRepository extends JpaRepository<JpaCompradorEntity, Long> {
    @Query("SELECT c FROM JpaCompradorEntity  c WHERE c.cpf = :cpf")
    Optional<JpaCompradorEntity> findByCpf(@Param("cpf") String cpf);

    boolean existsByCpf(String cpf);
}


