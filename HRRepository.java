package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.HR;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HRRepository extends JpaRepository<Employees, Integer> {

	@Query(value = "SELECT e.userName FROM employees e WHERE DATE(e.createdAt) = :date", nativeQuery = true)
	List<String> findDailyEmployeeLoginByDate(@Param("date") LocalDate date);

	@Query(value = "SELECT e.userName FROM employees e WHERE DATE(e.updatedAt)=:date", nativeQuery = true)
	List<String> findDailyEmployeeLogoutByDate(@Param("date") LocalDate date);

	@Query(value = "SELECT e.userName FROM employees e WHERE MONTH(e.createdAt) = :month", nativeQuery = true)
	List<String> findMonthlyEmployeeLoginByMonth(@Param("month") int month);

	@Query(value = "SELECT e.userName FROM employees e WHERE MONTH(e.updatedAt) = :month", nativeQuery = true)
	List<String> findMonthlyEmployeeLogoutByMonth(int month);

	@Query(value = "SELECT e.userName FROM employees e WHERE e.createdAt BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<String> findEmployeeLoginBetweenDates(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

	@Query(value = "SELECT e.userName FROM employees e WHERE e.updatedAt BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<String> findEmployeeLogoutBetweenDates(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

	/*
	 * 
	 * List<String> findWeeklyEmployeeLoginByDates(LocalDate startDate, LocalDate
	 * endDate);
	 * 
	 * List<String> findMonthlyEmployeeLoginByMonth(int month);
	 * 
	 * List<String> findQuarterlyEmployeeLoginByQuarter(int quarter);
	 * 
	 * List<String> findDailyEmployeeLogoutByDate(LocalDate date);
	 * 
	 * List<String> findWeeklyEmployeeLogoutByDates(LocalDate startDate, LocalDate
	 * endDate);
	 * 
	 * List<String> findMonthlyEmployeeLogoutByMonth(int month);
	 * 
	 * List<String> findQuarterlyEmployeeLogoutByQuarter(int quarter);
	 * 
	 * Projects getProjectById(int projectId);
	 * 
	 * Tasks getTaskById(int taskId);
	 * 
	 */
//    @Modifying
//    @Transactional
//    @Query("UPDATE Employees e SET e.position = :position, e.email = :email, e.contactNo = :contactNo WHERE e.employeeId = :employeeId")
//    void updateEmployeeDetails(@Param("employeeId") int employeeId,
//                               @Param("position") String position,
//                               @Param("email") String email,
//                               @Param("contactNo") String contactNo);

//    @Modifying
//    @Query("UPDATE Employees e SET e.position = :position, e.email = :email, e.contactNo = :contactNo WHERE e.employeeId = :employeeId")
//    void updateEmployeeDetails(@Param("employeeId") int employeeId,
//                               @Param("position") String position,
//                               @Param("email") String email,
//                               @Param("contactNo") String contactNo);
}
