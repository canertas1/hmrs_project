package kodlama.io.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hmrs.business.abstracts.CandidateService;
import kodlama.io.hmrs.core.utilities.Result;

import kodlama.io.hmrs.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate")
public class CandidateControllers {
	
	private CandidateService candidateManager;
	
	@Autowired
	public CandidateControllers(CandidateService candidateManager) {
		super();
		this.candidateManager = candidateManager;
	}
	
	@PostMapping("/save")
	public Result save(@RequestBody Candidate candidate) throws Exception {
		
		
		 
		 return candidateManager.save(candidate);
	}
	

}
