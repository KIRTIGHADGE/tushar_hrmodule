package com.franchiseworld.taskmanager.controller;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.service.EmployeeService;
import com.franchiseworld.taskmanager.service.HRService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/hr")
public class HRController {

	@Autowired
	private HRService hrService;

//    @GetMapping("/getallemployees")
//    public ResponseEntity<List<Employees>> getAllEmployees() {
//        List<Employees> employees = hrService.getAllEmployees();
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

	@PostMapping("/addnewemployees")
	public ResponseEntity<Employees> addEmployee(@Valid @RequestBody Employees employees) {
		Employees addedEmployee = hrService.addEmployee(employees);
		return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
	}

	// didi
//    @PutMapping("/updateemployees/{eId}")
//    public ResponseEntity<?> updateEmployeeDetails(@PathVariable int employeeId, @RequestBody Employees employees) {
//        // Validate request and handle error scenarios
//        
//        // Call service method to update employee details
//        hrService.updateEmployeeDetails(employeeId, employees.getPosition(), employees.getEmail(), employees.getContactNo());
//        
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping("/employees/logindaily")
//    public ResponseEntity<List<String>> getDailyEmployeeLogins(@RequestParam LocalDate date) {
//        //LocalDate localDate = LocalDate.parse(date);
//        List<String> dailyLogins = hrService.getDailyEmployeeLogins(date);
//        return new ResponseEntity<>(dailyLogins, HttpStatus.OK);
//    }
//	@GetMapping("/employees/logindaily")
//	public ResponseEntity<?> getDailyEmployeeLogins(
//			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//		if (date == null) {
//			return ResponseEntity.badRequest().body("Date parameter is required");
//		}
//
//		List<String> dailyLogins = hrService.getDailyEmployeeLogins(date);
//		return ResponseEntity.ok(dailyLogins);
//	}

	@GetMapping("/employees/dailylogins")
	public ResponseEntity getDailyEmployeeLogins(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
		if (startDate == null) {
			return ResponseEntity.badRequest().body("date parameter is required!");
		}
		List<String> dailyLogins = hrService.getDailyEmployeeLogins(startDate);
		return ResponseEntity.ok(dailyLogins);
	}

	@GetMapping("/employees/dailylogout")
	public ResponseEntity getDailyEmployeeLogOuts(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		if (date == null) {
			return ResponseEntity.badRequest().body("date parameter is required!");
		}

		List<String> dailyLogOut = hrService.getDailyEmployeeLogOut(date);
		return ResponseEntity.ok(dailyLogOut);
	}

	@GetMapping("/employees/loginmonthly/{month}")
	public ResponseEntity<List<String>> getMonthlyEmployeeLogins(@PathVariable int month) {
		List<String> monthlyLogins = hrService.getMonthlyEmployeeLogins(month);
		return new ResponseEntity<>(monthlyLogins, HttpStatus.OK);
	}

	@GetMapping("/employees/logoutmonthly/{month}")
	public ResponseEntity<List<String>> getMonthlyEmployeeLogout(@PathVariable int month) {
		List<String> monthlyLogouts = hrService.getMonthlyEmployeeLogout(month);
		return new ResponseEntity<>(monthlyLogouts, HttpStatus.OK);
	}

	@GetMapping("/employees/loginrange")
	public ResponseEntity<List<String>> getEmployeeLoginBetweenDates(@RequestParam String startDate,
			@RequestParam String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		List<String> logins = hrService.getEmployeeLoginBetweenDates(start, end);
		return new ResponseEntity<>(logins, HttpStatus.OK);
	}

	@GetMapping("/employees/logoutrange")
	public ResponseEntity<List<String>> getEmployeeLogoutBetweenDates(@RequestParam String startDate,
			@RequestParam String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		List<String> logouts = hrService.getEmployeeLogoutBetweenDates(start, end);
		return new ResponseEntity<>(logouts, HttpStatus.OK);
	}

	/*
	 * 
	 * @GetMapping("/employees/loginweekly") public ResponseEntity<List<String>>
	 * getWeeklyEmployeeLogins(@RequestParam String startDate,
	 * 
	 * @RequestParam String endDate) { LocalDate localStartDate =
	 * LocalDate.parse(startDate); LocalDate localEndDate =
	 * LocalDate.parse(endDate); List<String> weeklyLogins =
	 * hrService.getWeeklyEmployeeLogins(localStartDate, localEndDate); return new
	 * ResponseEntity<>(weeklyLogins, HttpStatus.OK); }
	 * 
	 * 
	 * 
	 * @GetMapping("/employees/loginmonthly") public ResponseEntity<List<String>>
	 * getMonthlyEmployeeLogins(@RequestParam int month) { List<String>
	 * monthlyLogins = hrService.getMonthlyEmployeeLogins(month); return new
	 * ResponseEntity<>(monthlyLogins, HttpStatus.OK); }
	 * 
	 * @GetMapping("/employees/loginquarterly") public ResponseEntity<List<String>>
	 * getQuarterlyEmployeeLogins(@RequestParam int quarter) { List<String>
	 * quarterlyLogins = hrService.getQuarterlyEmployeeLogins(quarter); return new
	 * ResponseEntity<>(quarterlyLogins, HttpStatus.OK); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // --------------------- FOR LOGOUT ------------------------
	 * 
	 * @GetMapping("/employees/logoutdaily") public ResponseEntity<List<String>>
	 * getDailyEmployeeLogout(@RequestParam String date) { // Convert date string to
	 * LocalDate if needed LocalDate localDate = LocalDate.parse(date); List<String>
	 * dailyLogouts = hrService.getDailyEmployeeLogout(localDate); return new
	 * ResponseEntity<>(dailyLogouts, HttpStatus.OK); }
	 * 
	 * 
	 * 
	 * 
	 * @GetMapping("/employees/logout-weekly") public ResponseEntity<List<String>>
	 * getWeeklyEmployeeLogout(@RequestParam String startDate,
	 * 
	 * @RequestParam String endDate) { // Convert date strings to LocalDate if
	 * needed LocalDate localStartDate = LocalDate.parse(startDate); LocalDate
	 * localEndDate = LocalDate.parse(endDate); List<String> weeklyLogouts =
	 * hrService.getWeeklyEmployeeLogout(localStartDate, localEndDate); return new
	 * ResponseEntity<>(weeklyLogouts, HttpStatus.OK); }
	 * 
	 * @GetMapping("/employees/logout-monthly") public ResponseEntity<List<String>>
	 * getMonthlyEmployeeLogout(@RequestParam int month) { List<String>
	 * monthlyLogouts = hrService.getMonthlyEmployeeLogout(month); return new
	 * ResponseEntity<>(monthlyLogouts, HttpStatus.OK); }
	 * 
	 * @GetMapping("/employees/logout-quarterly") public
	 * ResponseEntity<List<String>> getQuarterlyEmployeeLogout(@RequestParam int
	 * quarter) { List<String> quarterlyLogouts =
	 * hrService.getQuarterlyEmployeeLogout(quarter); return new
	 * ResponseEntity<>(quarterlyLogouts, HttpStatus.OK); }
	 * 
	 * @GetMapping("/projects/{projectId}") public ResponseEntity<Projects>
	 * getProjectById(@PathVariable int projectId) { Projects project =
	 * hrService.getProjectById(projectId); return new ResponseEntity<>(project,
	 * HttpStatus.OK); }
	 * 
	 * @GetMapping("/tasks/{taskId}") public ResponseEntity<Tasks>
	 * getTaskById(@PathVariable int taskId) { Tasks tasks =
	 * hrService.getTaskById(taskId); return new ResponseEntity<>(tasks,
	 * HttpStatus.OK); }
	 */
//    @GetMapping("/tasks")
//    public ResponseEntity<List<Tasks>> getAllTasks() {
//        List<Tasks> tasks = hrService.getAllTasks();
//        return new ResponseEntity<>(tasks, HttpStatus.OK);
//    }
//
//    // Example endpoint for fetching project by ID
//    @GetMapping("/projects/{projectId}")
//    public ResponseEntity<Projects> getProjectById(@PathVariable Long projectId) {
//        Projects projects = hrService.getProjectById(projectId);
//        return new ResponseEntity<>(projects, HttpStatus.OK);
//    }

}
