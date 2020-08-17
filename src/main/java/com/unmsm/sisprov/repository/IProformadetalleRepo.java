package com.unmsm.sisprov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unmsm.sisprov.entity.Proformadetalle;
import com.unmsm.sisprov.entity.ProformadetalleId;

public interface IProformadetalleRepo extends JpaRepository<Proformadetalle, ProformadetalleId>{

}
