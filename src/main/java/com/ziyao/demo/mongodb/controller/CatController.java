package com.ziyao.demo.mongodb.controller;

import com.ziyao.demo.mongodb.entity.Cat;
import com.ziyao.demo.mongodb.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/mongodb/cat")
@RestController
@RequiredArgsConstructor
public class CatController {

	private final CatService catService;
	
	@GetMapping(path = "/getAll")
	public List<Cat> getAllCats(){
		return catService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Cat getById(@PathVariable String id){
		return catService.findById(id);
	}

	@PostMapping(path = "")
	public Cat addOrUpdate(@RequestBody Cat cat) {
		return catService.addOrUpdate(cat);
	}
	
	@DeleteMapping(path = "/{id}")
	public String delete(@PathVariable String id) {
		catService.deleteById(id);
		return "cat delete: " + id;
	}
}
