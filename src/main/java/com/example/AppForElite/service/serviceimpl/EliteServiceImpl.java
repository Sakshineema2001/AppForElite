package com.example.AppForElite.service.serviceimpl;

import com.example.AppForElite.entity.Cities;
import com.example.AppForElite.entity.Course;
import com.example.AppForElite.entity.Elite;
import com.example.AppForElite.entity.State;
import com.example.AppForElite.respository.CityRepository;
import com.example.AppForElite.respository.CourseRepository;
import com.example.AppForElite.respository.EliteRepository;
import com.example.AppForElite.respository.StateRepository;
import com.example.AppForElite.service.EliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EliteServiceImpl implements EliteService
{
	@Autowired
	private EliteRepository eliteRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;

	@Override
	public void createForm(Elite elite)
	{
		eliteRepository.save(elite);
	}

	@Override
	public List<Elite> getAll()
	{
		return eliteRepository.findAll();
	}

	@Override
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}

	@Override
	public void createCourseForm(Course course)
	{
		courseRepository.save(course);
	}

	@Override
	public Elite updateElite(Long id,Elite elite)
	{
		Elite elite1 = eliteRepository.findEliteById(id);
		elite1.setName(elite.getName());
		elite1.setContactNo(elite.getContactNo());
		elite1.setApproval(elite.getApproval());
		elite1.setDate(elite.getDate());
		elite1.setCourse(elite.getCourse());
		elite1.setState(elite.getState());
		elite1.setCity(elite.getCity());
		elite1.setDescription(elite.getDescription());
		elite1.setPaymentMode(elite.getPaymentMode());
		return eliteRepository.save(elite1);
	}

	@Override
	public Elite getEliteById(Long id)
	{
		return eliteRepository.findEliteById(id);
	}

	@Override
	public void deleteElite(Long id)
	{
		Elite elite = eliteRepository.findEliteById(id);
		eliteRepository.delete(elite);
	}

	@Override
	public List<State> getAllState()
	{
		return stateRepository.findAll();
	}

	@Override
	public List<Cities> getAllCities(Long id)
	{
		return cityRepository.findByStateId(id);
	}
}
