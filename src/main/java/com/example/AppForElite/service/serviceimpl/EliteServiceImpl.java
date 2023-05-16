package com.example.AppForElite.service.serviceimpl;

import com.example.AppForElite.entity.BankDetails;
import com.example.AppForElite.entity.Cities;
import com.example.AppForElite.entity.Course;
import com.example.AppForElite.entity.Elite;
import com.example.AppForElite.entity.FamilyInfo;
import com.example.AppForElite.entity.State;
import com.example.AppForElite.respository.BankDetailsRepository;
import com.example.AppForElite.respository.CityRepository;
import com.example.AppForElite.respository.CourseRepository;
import com.example.AppForElite.respository.EliteRepository;
import com.example.AppForElite.respository.FamilyInfoRepository;
import com.example.AppForElite.respository.StateRepository;
import com.example.AppForElite.service.EliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Autowired
	private BankDetailsRepository bankDetailsRepository;
	@Autowired
	private FamilyInfoRepository familyInfoRepository;

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

	@Transactional
	public Elite createFormWithBankDetails(Elite elite)
	{
		BankDetails bankDetails = elite.getBankDetails();
		bankDetails.setElite(elite);
		bankDetails = bankDetailsRepository.save(bankDetails);
		elite.setBankDetails(bankDetails);
		return eliteRepository.save(elite);
	}

	@Override
	public List<FamilyInfo> createFamilyInfoForm(Long eliteId,List<FamilyInfo> familyInfo)
	{
		Elite elite = eliteRepository.findEliteById(eliteId);
		List<FamilyInfo> savedFamilyInfoList = new ArrayList<>();
		for(FamilyInfo fm : familyInfo){
			fm.setElite(elite);
			FamilyInfo info = familyInfoRepository.save(fm);
			savedFamilyInfoList.add(info);
		}
		return savedFamilyInfoList;
	}

	@Override
	public void updateFamilyInfoForm(Long eliteId, List<FamilyInfo> updatedFamilyInfoList)
	{
		List<FamilyInfo> existingFamilyInfoList = familyInfoRepository.findByEliteId(eliteId);
		Map<Long, FamilyInfo> updatedFamilyInfoMap = new HashMap<>();

		for (FamilyInfo updatedFamilyInfo : updatedFamilyInfoList)
		{
			if(updatedFamilyInfo.getId() == null){
				Elite elite = eliteRepository.findEliteById(eliteId);
				updatedFamilyInfo.setElite(elite);
				updatedFamilyInfo = familyInfoRepository.save(updatedFamilyInfo);
			}
			updatedFamilyInfoMap.put(updatedFamilyInfo.getId(), updatedFamilyInfo);
		}
		for (FamilyInfo existingFamilyInfo : existingFamilyInfoList)
		{
			FamilyInfo updatedFamilyInfo = updatedFamilyInfoMap.get(existingFamilyInfo.getId());
			if (updatedFamilyInfo != null)
			{
				existingFamilyInfo.setFather(updatedFamilyInfo.getFather());
				existingFamilyInfo.setMother(updatedFamilyInfo.getMother());
				existingFamilyInfo.setSiblingsNo(updatedFamilyInfo.getSiblingsNo());
				existingFamilyInfo.setFatherOccupation(updatedFamilyInfo.getFatherOccupation());
				familyInfoRepository.save(existingFamilyInfo);
			}
		}
	}
	@Override
	public List<FamilyInfo> getFamilyInfoByEliteId(Long eliteId)
	{
		return familyInfoRepository.findByEliteId(eliteId);
	}
}
