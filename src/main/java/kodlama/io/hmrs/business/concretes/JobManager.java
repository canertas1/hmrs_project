package kodlama.io.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hmrs.business.abstracts.JobService;
import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.core.utilities.SuccessDataResult;
import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.dataAccess.abstracts.JobDao;
import kodlama.io.hmrs.entities.concretes.Job;

@Service
public class JobManager implements JobService {
	
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	
	public DataResult<List<Job>> getAll(){
		
		
		 return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Data has been listed");
	}

	
	public Result add(Job job) {
		
		
		jobDao.save(job);
		return new SuccessResult();
	}


	
	
	
	

}
