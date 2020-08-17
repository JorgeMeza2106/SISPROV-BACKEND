package com.unmsm.sisprov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unmsm.sisprov.entity.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
