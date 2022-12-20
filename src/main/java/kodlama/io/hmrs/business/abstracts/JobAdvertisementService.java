package kodlama.io.hmrs.business.abstracts;

import java.util.List;

import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	
	Result save(JobAdvertisement jobAdvertisement) ;
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
	DataResult<List<JobAdvertisement>> getAllStatusTrue();
	
	

}
