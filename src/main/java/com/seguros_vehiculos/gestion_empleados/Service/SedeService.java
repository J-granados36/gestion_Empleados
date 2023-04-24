package com.seguros_vehiculos.gestion_empleados.Service;

import com.seguros_vehiculos.gestion_empleados.Repository.SedeRepository;
import com.seguros_vehiculos.gestion_empleados.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {
    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> getAll(){
        return sedeRepository.getAll();
    }

    public Optional<Sede> getSede(int id){
        return sedeRepository.getSede(id);
    }

    public Sede save(Sede sede){
        if (sede.getIdSede()==null){
            return sedeRepository.save(sede);
        }else {
            Optional<Sede> sedeOptional = sedeRepository.getSede(sede.getIdSede());
            if (sedeOptional.isEmpty()){
                return sedeRepository.save(sede);
            }else {
                return sede;
            }
        }
    }

    public Sede update(Sede sede){
        if (sede.getIdSede()!=null){
            Optional<Sede> optionalSede= sedeRepository.getSede(sede.getIdSede());
            if (!optionalSede.isEmpty()){
                if (sede.getIdSede()!=null){
                    optionalSede.get().setIdSede(sede.getIdSede());
                }
                if (sede.getNombre()!=null){
                    optionalSede.get().setNombre(sede.getNombre());
                }
                if (sede.getCiudad()!=null){
                    optionalSede.get().setCiudad(sede.getCiudad());
                }
                if (sede.getTelefono()!=null){
                    optionalSede.get().setTelefono(sede.getTelefono());
                }
                sedeRepository.save(optionalSede.get());
                return optionalSede.get();
            }else {
                return sede;
            }
        }else {
            return sede;
        }
    }

    public boolean deleteSede(int id){
        Boolean deleteSede = getSede(id).map(sede -> {
            sedeRepository.delete(sede);
            return true;
        }).orElse(false);
        return deleteSede;
    }



}
