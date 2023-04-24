package com.seguros_vehiculos.gestion_empleados.Repository;

import com.seguros_vehiculos.gestion_empleados.Repository.crudRepository.EmpleadoCrud;
import com.seguros_vehiculos.gestion_empleados.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepository {
    @Autowired
    private EmpleadoCrud empleadoCrud;

    public List<Empleado> getAll(){
        return (List<Empleado>) empleadoCrud.findAll();
    }

    public Optional<Empleado> getEmpleado(int id){
        return empleadoCrud.findById(id);
    }

    public Empleado save(Empleado empleado){
        return empleadoCrud.save(empleado);
    }

    public void delete(Empleado empleado){
        empleadoCrud.delete(empleado);
    }

}
