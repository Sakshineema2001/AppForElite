package com.example.AppForElite.respository;

import com.example.AppForElite.entity.Elite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EliteRepository extends JpaRepository<Elite,Long>
{
    List<Elite> findAll();

    Elite findEliteById(Long id);
}
