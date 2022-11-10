package kodlama.io.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlama.io.hmrs.business.abstracts.CandidateService;
import kodlama.io.hmrs.core.adapters.abstracts.MernisCheckService;
import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.ErrorResult;
import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.core.utilities.SuccessDataResult;
import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.core.validations.abstracts.CandidateCheckService;
import kodlama.io.hmrs.core.validations.concretes.CandidateCheckManager;
import kodlama.io.hmrs.dataAccess.abstracts.UserDao;
import kodlama.io.hmrs.entities.concretes.Candidate;
import kodlama.io.hmrs.entities.concretes.Employer;

@Service

public class CandidateManager implements CandidateService{

	private UserDao userDao;
	private MernisCheckService mernisCheckManager;
	private CandidateCheckManager candidateCheckManager;
	
	
	
	
	@Autowired
	public CandidateManager(UserDao userDao ,MernisCheckService mernisCheckManager,CandidateCheckManager candidateCheckManager) {
		this.userDao = userDao;
		this.mernisCheckManager = mernisCheckManager;
		this.candidateCheckManager=candidateCheckManager;
		
	}
	
	
	
	
	
	
    public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.userDao.findAll(),"Data Listelendi");
	}
	
	
	
	
	
	 public Result save(Candidate candidate) throws Exception  {
		 
		 Result checkedPerson = mernisCheckManager.checkIfRealPerson(candidate);
		 boolean nullCheckCandidate = candidateCheckManager.checkCandidate(candidate);
		
		if(checkedPerson.isSuccess() == true || nullCheckCandidate == true )
		{
			userDao.save(candidate);
		 return new SuccessResult();
			
		}else {
			return new ErrorResult();
		}
	
	}
	
	
}
