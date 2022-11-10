package kodlama.io.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hmrs.business.abstracts.EmployerService;
import kodlama.io.hmrs.core.utilities.Result;

import kodlama.io.hmrs.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersControllers {
	
	private EmployerService employerManager;
	
	@Autowired
	public EmployersControllers(EmployerService employerManager) {
		super();
		this.employerManager = employerManager;
	}
	
	@PostMapping("/save")
	public Result save(@RequestBody Employer employer) {
		
		 
		
		return employerManager.save(employer);
	}
	
	
	
	

}
