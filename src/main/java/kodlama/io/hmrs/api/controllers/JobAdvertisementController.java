package kodlama.io.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hmrs.business.abstracts.JobAdvertisementService;
import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementManager;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementManager) {
		
		this.jobAdvertisementManager=jobAdvertisementManager;
	}
	
	
	@PostMapping("/save")
	public Result save(@RequestBody JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementManager.save(jobAdvertisement);
		
		return new SuccessResult("başarıyla eklendi");
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		
		
		return this.jobAdvertisementManager.getAll();
	}
	
	@GetMapping("/getAllSortedByDate")
	public DataResult<List<JobAdvertisement>> getAllSortedByDate(){
		
		
		return this.jobAdvertisementManager.getAllSortedByDate();
	}
	
	@GetMapping("/getAllStatusTrue")
	
	public DataResult<List<JobAdvertisement>> getAllStatusTrue(){
		
		return this.jobAdvertisementManager.getAllStatusTrue();
	}
	
	
	
	

}
