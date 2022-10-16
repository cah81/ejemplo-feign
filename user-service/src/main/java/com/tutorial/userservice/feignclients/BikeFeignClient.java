package com.tutorial.userservice.feignclients;

import com.tutorial.userservice.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name ="bike-service",url = "http://localhost:8003/bike")
public interface BikeFeignClient {


    @PostMapping()
    Bike save(@RequestBody Bike bike);

    @GetMapping("/{id}")
    Bike getById(@PathVariable("id") Integer id);
}
