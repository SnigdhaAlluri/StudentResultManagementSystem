package com.example.studentresultmanagementsystem.repository;

import com.example.studentresultmanagementsystem.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {

}
