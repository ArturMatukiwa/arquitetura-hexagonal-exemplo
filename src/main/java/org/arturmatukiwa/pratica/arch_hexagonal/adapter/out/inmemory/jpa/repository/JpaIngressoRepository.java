package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.repository;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaIngressoEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Categoria;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaIngressoRepository extends JpaRepository<JpaIngressoEntity, Long> {
    @Query("""
            SELECT  i  FROM JpaIngressoEntity i
              WHERE  i.categoria   = :categoria
              AND    i.setor       = :setor
              AND    (i.quantidadeTotal - i.quantidadeVendida) >= :quantidade
            """)
    Optional<JpaIngressoEntity> findQuantityByCategoryAndSector(@Param("categoria") Categoria categoria,
                                                       @Param("setor") Setor setor,
                                                       @Param("quantidade") Integer quantidade);

    boolean existsByCategoriaAndSetorAndMeiaEntrada(Categoria categoria, Setor setor, Boolean meiaEntrada);

    Optional<JpaIngressoEntity> findByCategoriaAndSetorAndMeiaEntrada(Categoria categoria, Setor setor, Boolean meiaEntrada);
}
