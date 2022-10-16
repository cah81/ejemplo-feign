package com.tutorial.userservice.feignclients;

import com.tutorial.userservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "car-service", url ="http://localhost:8002/car")
public interface CarFeignClient {

    @PostMapping()
    Car save(@RequestBody Car car);

    @GetMapping("/{id}")
    Car getById(@PathVariable("id") Integer id);

}
