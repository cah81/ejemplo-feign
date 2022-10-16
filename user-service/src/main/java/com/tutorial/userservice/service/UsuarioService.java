package com.tutorial.userservice.service;

import com.tutorial.userservice.entity.Usuario;
import com.tutorial.userservice.feignclients.BikeFeignClient;
import com.tutorial.userservice.feignclients.CarFeignClient;
import com.tutorial.userservice.model.Bike;
import com.tutorial.userservice.model.Car;
import com.tutorial.userservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CarFeignClient carFeignClient;

    @Autowired
    BikeFeignClient bikeFeignClient;

    public List<Usuario> getALl(){
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    public Car saveCar (int userId ,Car car){
        car.setUserId(userId);
        return carFeignClient.save(car);
    }

    public Car getCarById(Integer id){
         return carFeignClient.getById(id);

    }

    public Bike saveBike(int userId ,Bike bike){
        bike.setUserId(userId);
        return bikeFeignClient.save(bike);
    }

    public Bike getBikeById(Integer id){
        return bikeFeignClient.getById(id);
    }
}
