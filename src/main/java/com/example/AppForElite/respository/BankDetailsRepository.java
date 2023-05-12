package com.example.AppForElite.respository;

import com.example.AppForElite.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails,Long>
{
}
