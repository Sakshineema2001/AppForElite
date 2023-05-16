package com.example.AppForElite.service;

import com.example.AppForElite.entity.Cities;
import com.example.AppForElite.entity.Course;
import com.example.AppForElite.entity.Elite;
import com.example.AppForElite.entity.FamilyInfo;
import com.example.AppForElite.entity.State;

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

	Elite createFormWithBankDetails(Elite elite);

//	public List<FamilyInfo> createFamilyInfoForm(List<FamilyInfo> familyInfo);

	public List<FamilyInfo> createFamilyInfoForm(Long eliteId,List<FamilyInfo> familyInfo);

	void updateFamilyInfoForm(Long eliteId, List<FamilyInfo> familyInfo);

	List<FamilyInfo> getFamilyInfoByEliteId(Long eliteId);
}
