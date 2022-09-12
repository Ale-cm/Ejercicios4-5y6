package com.example.Ejercios4.y6.Contoller;

import com.example.Ejercios4.y6.Persistence.entity.Laptop;
import com.example.Ejercios4.y6.Persistence.repository.LaptopRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laptop")
public class LaptopControler {
 private final LaptopRepository laptopRepository;

 public LaptopControler(LaptopRepository laptopRepository) {
  this.laptopRepository = laptopRepository;
 }

 @GetMapping
 public String helloLaptop(){
return "hola laptop";
 }

 @GetMapping("/all")
 public List<Laptop> findAll(){
  return this.laptopRepository.findAll();
 }

 @GetMapping("/id/{id}")
 public Laptop findById(@PathVariable("id") Long id){

  Optional<Laptop> laptopOpt= this.laptopRepository.findById(id);
  return laptopOpt.orElse(null);
 }

 @DeleteMapping("/delete/{id}")
 public void deleteById(@PathVariable("id") Long id){
  this.laptopRepository.deleteById(id);
 }
 @PostMapping("/create")
 public Laptop LaptopController(@RequestBody Laptop laptop){
  return this.laptopRepository.save(laptop);
 }

}
