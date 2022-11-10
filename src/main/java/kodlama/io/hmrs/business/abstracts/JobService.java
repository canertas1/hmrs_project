package kodlama.io.hmrs.business.abstracts;

import java.util.List;

import kodlama.io.hmrs.core.utilities.DataResult;
import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.entities.concretes.Job;

public interface JobService {
	DataResult<List<Job>> getAll();
	Result add(Job job);
}
