package com.project.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.model.*;
public interface CodeRepository extends JpaRepository<Code, Integer> {

}
