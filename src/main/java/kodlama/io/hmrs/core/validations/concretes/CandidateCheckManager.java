package kodlama.io.hmrs.core.validations.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hmrs.core.validations.abstracts.CandidateCheckService;
import kodlama.io.hmrs.dataAccess.abstracts.UserDao;
import kodlama.io.hmrs.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService {
	private UserDao userDao;
	
	
	@Autowired
	public CandidateCheckManager(UserDao userDao) {
		
		this.userDao=userDao;
		
	}
	
	
	public boolean checkCandidate(Candidate candidate) {
		
		if(candidate.getFirstName().trim().equals("")
		  || candidate.getLastName().trim().equals("")
		  || candidate.getEmail().trim().equals(null)
		  || candidate.getPassword().trim().equals(null)
		  || candidate.getIdentityNumber().trim().equals("")
		  )
		  {
			
			return false;
		}else {
			return true;
		}

	}
	
	public boolean regexMailCheck(Candidate candidate) {
	
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEmail());
		if (matcher.matches()==true) {
			return true;
		}else {
			return false;
			
		}
		
	
	
	
	
	
	
	
	}
}
