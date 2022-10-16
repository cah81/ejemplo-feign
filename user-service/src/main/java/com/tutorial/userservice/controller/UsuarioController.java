package com.tutorial.userservice.controller;

import com.tutorial.userservice.model.Bike;
import com.tutorial.userservice.model.Car;
import com.tutorial.userservice.service.UsuarioService;
import com.tutorial.userservice.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = usuarioService.getALl();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(usuarios);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Integer id){
        Usuario usuario = usuarioService.getUserById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario usuarioNew = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioNew);
    }
    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId,@RequestBody Car car){
        Car carNew = usuarioService.saveCar(userId,car);
        return ResponseEntity.ok(carNew);

    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Integer id){
        Car car = usuarioService.getCarById(id);
        if(car==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @PostMapping("/savebike/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable("userId") int userId,@RequestBody Bike bike){
        Bike bikeNew = usuarioService.saveBike(userId,bike);
        return ResponseEntity.ok(bikeNew);
    }

    @GetMapping("bike/{id}")
    public ResponseEntity<Bike> getBikeByid(@PathVariable("id") Integer id){
        Bike bike = usuarioService.getBikeById(id);
        if(bike== null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(bike);
    }

}
