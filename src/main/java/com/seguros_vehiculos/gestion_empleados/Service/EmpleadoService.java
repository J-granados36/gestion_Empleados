package com.seguros_vehiculos.gestion_empleados.Service;

import com.seguros_vehiculos.gestion_empleados.Repository.EmpleadoRepository;
import com.seguros_vehiculos.gestion_empleados.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAll(){
        return empleadoRepository.getAll();
    }

    public Optional<Empleado> getEmpleado(int id){
        return empleadoRepository.getEmpleado(id);
    }

    public Empleado save(Empleado empleado){
        if (empleado.getId()==null){
            return empleadoRepository.save(empleado);
        }else {
            Optional<Empleado> empleadoOptional = empleadoRepository.getEmpleado(empleado.getId());
            if (empleadoOptional.isEmpty()){
                return empleadoRepository.save(empleado);
            }else {
                return empleado;
            }
        }
    }

    public Empleado update(Empleado empleado){
        if (empleado.getId()!=null){
            Optional<Empleado> optionalEmpleado= empleadoRepository.getEmpleado(empleado.getId());
            if (!optionalEmpleado.isEmpty()){
                if (empleado.getId()!=null){
                    optionalEmpleado.get().setId(empleado.getId());
                }
                if (empleado.getNombre()!=null){
                    optionalEmpleado.get().setNombre(empleado.getNombre());
                }
                if (empleado.getTelefono()!=null){
                    optionalEmpleado.get().setTelefono(empleado.getTelefono());
                }
                if (empleado.getCedula()!=null){
                    optionalEmpleado.get().setCedula(empleado.getCedula());
                }
                if (empleado.getCorreo()!=null){
                    optionalEmpleado.get().setCorreo(empleado.getCorreo());
                }
                empleadoRepository.save(optionalEmpleado.get());
                return optionalEmpleado.get();
            }else {
                return empleado;
            }
        }else {
            return empleado;
        }
    }

    public boolean deleteEmpleado(int id){
        Boolean deleteEmpleado=getEmpleado(id).map(empleado -> {
            empleadoRepository.delete(empleado);
            return true;
        }).orElse(false);
        return deleteEmpleado;
    }

}
