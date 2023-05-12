package com.example.AppForElite.controller;

import com.example.AppForElite.entity.BankDetails;
import com.example.AppForElite.entity.Cities;
import com.example.AppForElite.entity.Course;
import com.example.AppForElite.entity.Elite;
import com.example.AppForElite.entity.State;
import com.example.AppForElite.service.EliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/elite")
public class EliteController
{
	@Autowired
	private EliteService eliteService;

	@PostMapping("/post")
	public void postForm(@RequestBody Elite elite){
      eliteService.createForm(elite);
	}

	@GetMapping("/get")
	public List<Elite> getAll(){
		return eliteService.getAll();
	}

	@GetMapping("/get/{id}")
	public Elite getEliteById(@PathVariable Long id){
		return eliteService.getEliteById(id);
	}

	@PostMapping("/post-course")
	public void postCourse(@RequestBody Course course){
		eliteService.createCourseForm(course);
	}

	@GetMapping("/get-all-course")
	public List<Course> getAllCourse(){
		return eliteService.getAllCourses();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Elite> updateElite(@PathVariable Long id, @RequestBody Elite elite){
		Elite updatedElite = eliteService.updateElite(id,elite);
		return ResponseEntity.ok(updatedElite);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteElite(@PathVariable Long id){
		eliteService.deleteElite(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/state")
	public List<State> getAllState(){
		return eliteService.getAllState();
	}

	@GetMapping("/cities/{id}")
	public List<Cities> getAllCities(@PathVariable Long id){
		return eliteService.getAllCities(id);
	}

	@PostMapping("/create")
	public Elite createUser(@RequestBody Elite elite) {
		return eliteService.createFormWithBankDetails(elite);
	}

}
