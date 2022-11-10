package kodlama.io.hmrs.core.adapters.concretes;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlama.io.hmrs.core.adapters.abstracts.MernisCheckService;
import kodlama.io.hmrs.core.utilities.ErrorResult;
import kodlama.io.hmrs.core.utilities.Result;

import kodlama.io.hmrs.core.utilities.SuccessResult;
import kodlama.io.hmrs.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public Result checkIfRealPerson(Candidate candidate) throws Exception{
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
				
				candidate.getFirstName().toUpperCase(new Locale("tr","TR")), 
				candidate.getLastName().toUpperCase(new Locale("tr","TR")),
				Integer.parseInt(candidate.getBirthYear()));
		
		if(result==true) {
			return new SuccessResult();
		}else {
			return new ErrorResult();
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
		
	

}

