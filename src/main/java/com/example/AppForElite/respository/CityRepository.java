package com.example.AppForElite.respository;

import com.example.AppForElite.entity.Cities;
import com.example.AppForElite.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<Cities,Long>
{
	List<Cities> findByStateId(Long id);
}
