package com.ziyao.demo.mybatisplus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/mybatisplus/rabbit")
@RestController
@RequiredArgsConstructor
public class RabbitController {

//	private final RabbitService rabbitService;
//
//	@GetMapping(path = "/getAll")
//	public List<Rabbit> getAllRabbits(){
//		return rabbitService.findAll();
//	}
//
//	@GetMapping(path = "/{id}")
//	public Rabbit getById(@PathVariable String id){
//		return rabbitService.findById(id);
//	}
//
//	@PostMapping(path = "")
//	public Rabbit addOrUpdate(@RequestBody Rabbit rabbit) {
//		return rabbitService.addOrUpdate(rabbit);
//	}
//
//	@DeleteMapping(path = "/{id}")
//	public String delete(@PathVariable String id) {
//		rabbitService.deleteById(id);
//		return "rabbit delete: " + id;
//	}
}
