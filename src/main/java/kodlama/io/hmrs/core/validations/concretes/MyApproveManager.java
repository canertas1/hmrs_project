package kodlama.io.hmrs.core.validations.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.core.validations.abstracts.MyApproveService;
import kodlama.io.hmrs.entities.concretes.Employer;

@Service
public class MyApproveManager implements MyApproveService {

	@Override
	public Result isApprovedUs(Employer employer) {
		
		return new SuccessResult();
	}

}
