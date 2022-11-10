package kodlama.io.hmrs.core.utilities;

public class SuccessResult extends Result{
	
	public SuccessResult() {
		super(true);
		
	}
	
	public SuccessResult(String message) {
		
		super(true,message);
		
		}

}
