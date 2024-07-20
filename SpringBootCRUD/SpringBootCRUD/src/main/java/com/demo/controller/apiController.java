package com.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.DTO.RegDTO;
import com.demo.service.RegisterService;

@CrossOrigin		
@RestController
@RequestMapping("/user")
public class apiController {
	@Autowired
	private RegisterService registerService;

	@GetMapping
	public ResponseEntity getUser() {
		return this.registerService.viewUser();
	}

	@PostMapping
	public ResponseEntity postUser(@RequestBody RegDTO regdto) {
		return this.registerService.saveUser(regdto);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		return this.registerService.delete(id);
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity updateUser(@RequestBody RegDTO regdto,@PathVariable int id ){
		return this.registerService.update(regdto,id);
		
	}
	
}