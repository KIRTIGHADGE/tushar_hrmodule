package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;

import java.time.LocalDate;
import java.util.List;

public interface HRService {

//    List<Employees> getAllEmployees();

	Employees addEmployee(Employees employees);

	// Employees updateEmployee(int employeeId, Employees employees);

	// didi
	// void updateEmployeeDetails(int employeeId, String position, String email,
	// String contactNo);

	// Employees updateEmployee(int employeeId, String position, String email,
	// String contactNo);

	List<String> getDailyEmployeeLogins(LocalDate date);

	List<String> getDailyEmployeeLogOut(LocalDate date);

	List<String> getMonthlyEmployeeLogins(int month);

	List<String> getMonthlyEmployeeLogout(int month);

	List<String> getEmployeeLoginBetweenDates(LocalDate startDate, LocalDate endDate);

	List<String> getEmployeeLogoutBetweenDates(LocalDate startDate, LocalDate endDate);

	/*
	 * List<String> getWeeklyEmployeeLogins(LocalDate startDate, LocalDate endDate);
	 * 
	 * List<String> getMonthlyEmployeeLogins(int month);
	 * 
	 * List<String> getQuarterlyEmployeeLogins(int quarter);
	 * 
	 * List<String> getDailyEmployeeLogout(LocalDate date);
	 * 
	 * List<String> getWeeklyEmployeeLogout(LocalDate startDate, LocalDate endDate);
	 * 
	 * List<String> getMonthlyEmployeeLogout(int month);
	 * 
	 * List<String> getQuarterlyEmployeeLogout(int quarter);
	 * 
	 * Projects getProjectById(int projectId);
	 * 
	 * Tasks getTaskById(int taskId);
	 */

}
