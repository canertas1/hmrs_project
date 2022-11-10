package kodlama.io.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hmrs.business.abstracts.EmployerService;
import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.ErrorResult;
import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.core.utilities.SuccessDataResult;
import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.core.validations.abstracts.EmailCheckService;
import kodlama.io.hmrs.core.validations.abstracts.MyApproveService;
import kodlama.io.hmrs.core.validations.concretes.EmailCheckManager;
import kodlama.io.hmrs.dataAccess.abstracts.EmployerDao;
import kodlama.io.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailCheckService emailCheckManager;
	private MyApproveService myApproveManager;
	

	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailCheckService emailCheckManager,MyApproveService myApproveManager) {
		this.employerDao = employerDao;
		this.emailCheckManager = emailCheckManager;
		this.myApproveManager=myApproveManager;
		
	}
	private boolean employerControl(Employer employer) {
		if(employer.getEmail()== null || employer.getEmail().length()==0 ||
		employer.getCompanyName() == null ||	employer.getPhoneNumber()==null
		|| employer.getWebAddress()==null) {
			
			return false;
		}else {
			return true;
		}
	}
     public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data Listelendi");
	}

	
	
	
	
	@Override
	public Result save(Employer employer) {
		
		if(!employerControl(employer)) {
			return new ErrorResult("Please fill out all fields");
		}
		else if(EmailCheckManager.checkEmailDomain(employer.getWebAddress(), employer.getEmail()))
		{
			return new ErrorResult("Your web address domain is not mach your email");
		}
		else if(!this.myApproveManager.isApprovedUs(employer).isSuccess() ){
			return new ErrorResult("Your registration is not approved from hmrs personel");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("Employer saved succesfully");
		}
	}

	
	
	
	
	
	
	

}
