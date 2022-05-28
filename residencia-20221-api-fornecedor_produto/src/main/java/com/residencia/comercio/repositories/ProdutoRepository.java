package com.residencia.comercio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.residencia.comercio.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
