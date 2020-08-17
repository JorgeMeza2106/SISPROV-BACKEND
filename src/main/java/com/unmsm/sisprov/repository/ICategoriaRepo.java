package com.unmsm.sisprov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unmsm.sisprov.entity.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer>{

}
