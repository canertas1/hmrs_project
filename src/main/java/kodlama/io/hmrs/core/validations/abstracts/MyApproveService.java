package kodlama.io.hmrs.core.validations.abstracts;

import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.entities.concretes.Employer;

public interface MyApproveService {
	public Result isApprovedUs(Employer employer);

}
