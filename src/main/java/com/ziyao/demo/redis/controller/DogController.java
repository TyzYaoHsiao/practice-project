package com.ziyao.demo.redis.controller;

import com.ziyao.demo.redis.entity.Dog;
import com.ziyao.demo.redis.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/redis/dog")
@RestController
@RequiredArgsConstructor
public class DogController {

	private final DogService dogService;
	
	@GetMapping(path = "/getAll")
	public List<Dog> getAllDogs(){
		return dogService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Dog getById(@PathVariable String id){
		return dogService.findById(id);
	}

	@PostMapping(path = "")
	public Dog addOrUpdate(@RequestBody Dog Dog) {
		return dogService.addOrUpdate(Dog);
	}
	
	@DeleteMapping(path = "/{id}")
	public String delete(@PathVariable String id) {
		dogService.deleteById(id);
		return "user delete: " + id;
	}
}
