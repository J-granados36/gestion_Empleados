package com.seguros_vehiculos.gestion_empleados.Controller;

import com.seguros_vehiculos.gestion_empleados.Service.SedeService;
import com.seguros_vehiculos.gestion_empleados.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Sede")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SedeController {
    @Autowired
    private SedeService sedeService;

    @GetMapping("/all")
    public List<Sede> getSedes(){
        return sedeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Sede> getSede(@PathVariable("id")int id){
        return sedeService.getSede(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Sede save(@RequestBody Sede sede){
        return sedeService.save(sede);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Sede update(@RequestBody Sede sede){
        return sedeService.update(sede);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return sedeService.deleteSede(id);
    }
}
