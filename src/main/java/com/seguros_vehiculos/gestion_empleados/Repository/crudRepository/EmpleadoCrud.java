package com.seguros_vehiculos.gestion_empleados.Repository.crudRepository;

import com.seguros_vehiculos.gestion_empleados.model.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoCrud extends CrudRepository<Empleado,Integer> {
}
