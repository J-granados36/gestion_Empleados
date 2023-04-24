package com.seguros_vehiculos.gestion_empleados.Controller;

import com.seguros_vehiculos.gestion_empleados.Service.EmpleadoService;
import com.seguros_vehiculos.gestion_empleados.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Empleado")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/all")
    public List<Empleado> getEmpleados(){
        return empleadoService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Empleado> getEmpleado(@PathVariable("id")int id){
        return empleadoService.getEmpleado(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado update(@RequestBody Empleado empleado){
        return empleadoService.update(empleado);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id){
        return empleadoService.deleteEmpleado(id);
    }



}
