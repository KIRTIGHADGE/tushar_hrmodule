package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.repos.HRRepository;
import com.franchiseworld.taskmanager.repos.ProjectsRepo;
import com.franchiseworld.taskmanager.repos.TaskRepo;
import com.franchiseworld.taskmanager.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HRServiceImpl implements HRService {

	@Autowired
	private HRRepository hrRepository;

	@Autowired
	private EmployeesRepo employeeRepo;

	@Autowired
	private ProjectsRepo projectRepository;

	@Autowired
	private TaskRepo taskRepository;

//    @Override
//    public List<Employees> getAllEmployees() {
//        return employeeRepo.findAll();
//    }

	@Override
	public Employees addEmployee(Employees employees) {
		return employeeRepo.save(employees);
	}

//    @Override
//    public Employees updateEmployee(int employeeId, Employees employees) {
//        Employees existingEmployee = employeeRepo.findById(Math.toIntExact(employeeId))
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        // Update fields
//        existingEmployee.setPosition(employees.getPosition());
//        existingEmployee.setEmail(employees.getEmail());
//        existingEmployee.setContactNo(employees.getContactNo());
//
//        // Save and return updated employee
//        return employeeRepo.save(existingEmployee);
//    }

	// didi
//    @Transactional
//    public void updateEmployeeDetails(int employeeId, String position, String email, String contactNo) {
//        hrRepository.updateEmployeeDetails(employeeId, position, email, contactNo);
//    }

	@Override
	public List<String> getDailyEmployeeLogins(LocalDate date) {
		return hrRepository.findDailyEmployeeLoginByDate(date);
	}

	public List<String> getDailyEmployeeLogOut(LocalDate date) {
		return hrRepository.findDailyEmployeeLogoutByDate(date);
	}

	@Override
	public List<String> getMonthlyEmployeeLogins(int month) {
		return hrRepository.findMonthlyEmployeeLoginByMonth(month);
	}

	@Override
	public List<String> getMonthlyEmployeeLogout(int month) {

		return hrRepository.findMonthlyEmployeeLogoutByMonth(month);
	}

	@Override
	public List<String> getEmployeeLoginBetweenDates(LocalDate startDate, LocalDate endDate) {
		return hrRepository.findEmployeeLoginBetweenDates(startDate, endDate);
	}

	@Override
	public List<String> getEmployeeLogoutBetweenDates(LocalDate startDate, LocalDate endDate) {
		return hrRepository.findEmployeeLogoutBetweenDates(startDate, endDate);
	}

	/*
	 * @Override public List<String> getWeeklyEmployeeLogins(LocalDate startDate,
	 * LocalDate endDate) { // return
	 * hrRepository.findWeeklyEmployeeLoginByDates(startDate, endDate); return null;
	 * }
	 * 
	 * @Override public List<String> getMonthlyEmployeeLogins(int month) { // return
	 * hrRepository.findMonthlyEmployeeLoginByMonth(month); return null; }
	 * 
	 * @Override public List<String> getQuarterlyEmployeeLogins(int quarter) {
	 * //return hrRepository.findQuarterlyEmployeeLoginByQuarter(quarter); return
	 * null; }
	 * 
	 * 
	 * @Override public List<String> getDailyEmployeeLogout(LocalDate date) {
	 * //return hrRepository.findDailyEmployeeLogoutByDate(date); return null; }
	 * 
	 * @Override public List<String> getWeeklyEmployeeLogout(LocalDate startDate,
	 * LocalDate endDate) { //return
	 * hrRepository.findWeeklyEmployeeLogoutByDates(startDate, endDate); return
	 * null; }
	 * 
	 * @Override public List<String> getMonthlyEmployeeLogout(int month) { //return
	 * hrRepository.findMonthlyEmployeeLogoutByMonth(month); return null; }
	 * 
	 * @Override public List<String> getQuarterlyEmployeeLogout(int quarter) { //
	 * return hrRepository.findQuarterlyEmployeeLogoutByQuarter(quarter); return
	 * null; }
	 * 
	 * @Override public Projects getProjectById(int projectId) { return
	 * projectRepository.findById(projectId) .orElseThrow(() -> new
	 * RuntimeException("Project not found")); }
	 * 
	 * @Override public Tasks getTaskById(int taskId) { return
	 * taskRepository.findById(taskId) .orElseThrow(() -> new
	 * RuntimeException("Task not found")); }
	 */

}
