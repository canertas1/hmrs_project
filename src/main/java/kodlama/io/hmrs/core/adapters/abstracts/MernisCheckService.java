package kodlama.io.hmrs.core.adapters.abstracts;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import kodlama.io.hmrs.core.utilities.Result;
import kodlama.io.hmrs.entities.concretes.Candidate;


@ComponentScan
public interface MernisCheckService {
	 Result checkIfRealPerson(Candidate candidate) throws Exception ;
		 
	 
	

}
