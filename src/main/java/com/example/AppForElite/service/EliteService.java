package com.example.AppForElite.service;

import com.example.AppForElite.entity.Cities;
import com.example.AppForElite.entity.Course;
import com.example.AppForElite.entity.Elite;
import com.example.AppForElite.entity.State;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EliteService
{
	public void createForm(Elite elite);
	public List<Elite> getAll();

	List<Course> getAllCourses();

	void createCourseForm(Course course);

	Elite updateElite(Long id,Elite elite);

	Elite getEliteById(Long id);

	void deleteElite(Long id);

	List<State> getAllState();

	List<Cities> getAllCities(Long id);
}
