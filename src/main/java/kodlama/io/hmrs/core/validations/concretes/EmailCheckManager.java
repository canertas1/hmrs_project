package kodlama.io.hmrs.core.validations.concretes;


import org.springframework.stereotype.Service;

import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.core.validations.abstracts.EmailCheckService;


@Service
public class EmailCheckManager implements EmailCheckService{
	@Override
	public Result isEmailVerify() {
		return new SuccessResult();
	}
	
	
	public static boolean checkEmailDomain(String companyWebsite, String email) {
		
		
		return companyWebsite.contains(email.split("@")[1]);
	}
	


	

}
