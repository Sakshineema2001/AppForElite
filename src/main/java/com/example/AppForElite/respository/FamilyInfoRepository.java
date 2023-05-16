package com.example.AppForElite.respository;

import com.example.AppForElite.entity.FamilyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyInfoRepository extends JpaRepository<FamilyInfo,Long>
{
	List<FamilyInfo> findByEliteId(Long eliteId);
}
