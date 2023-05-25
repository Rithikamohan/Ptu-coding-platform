package com.project.repository;

import com.project.domain.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AssessmentRepository extends JpaRepository<Assessment,Long> {

}

