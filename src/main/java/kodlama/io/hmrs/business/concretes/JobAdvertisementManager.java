package kodlama.io.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hmrs.business.abstracts.JobAdvertisementService;
import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.core.utilities.SuccessDataResult;
import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hmrs.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		
		this.jobAdvertisementDao = jobAdvertisementDao;
		
	}
	
	
	public Result save(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		
		
		return new SuccessResult();
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"iş ilanları listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"firstDate");
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllStatusTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllStatusTrue(),"Aktif iş ilanları listelendi.");
	}
	

	
	
	
	
}
