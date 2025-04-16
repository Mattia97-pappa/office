package com.example.ufficio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.example.ufficio.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
@NativeQuery("SELECT * FROM employees WHERE employees.firstName LIKE %?1% OR employees.lastName LIKE %?1%")
List<Employees>findByPatternLike(String pattern);
List<Employees> findByLastName(String lastName);

}
 