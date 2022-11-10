package kodlama.io.hmrs.business.abstracts;

import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.entities.concretes.Candidate;

public interface CandidateService {
	
	Result save(Candidate candidate) throws Exception;

}
