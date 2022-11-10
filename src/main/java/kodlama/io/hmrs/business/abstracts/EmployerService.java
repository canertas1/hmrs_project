package kodlama.io.hmrs.business.abstracts;

import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.entities.concretes.Employer;

public interface EmployerService {

	Result save(Employer employer);
}
