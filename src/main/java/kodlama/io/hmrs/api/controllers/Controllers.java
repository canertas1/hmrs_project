package kodlama.io.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.hmrs.entities.concretes.Job;
import kodlama.io.hmrs.business.abstracts.JobService;
import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.Result;


@RestController
@RequestMapping("/api/job")
public class Controllers {
	private JobService jobService;
	@Autowired
	public Controllers(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping("/getall")
	DataResult<List<Job>> getJob(){
		return this.jobService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		
		
		return this.jobService.add(job);
	}
	
	

}
