package com.seguros_vehiculos.gestion_empleados.Repository;

import com.seguros_vehiculos.gestion_empleados.Repository.crudRepository.SedeCrud;
import com.seguros_vehiculos.gestion_empleados.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SedeRepository {

    @Autowired
    private SedeCrud sedeCrud;

    public List<Sede> getAll(){
        return (List<Sede>) sedeCrud.findAll();
    }

    public Optional<Sede> getSede(int id){
        return sedeCrud.findById(id);
    }

    public Sede save(Sede sede){
        return sedeCrud.save(sede);
    }

    public void delete(Sede sede){
        sedeCrud.delete(sede);
    }
}
