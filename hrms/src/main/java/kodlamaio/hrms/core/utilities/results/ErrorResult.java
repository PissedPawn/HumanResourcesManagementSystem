package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result {

	public ErrorResult(String message) {
		super(message, false);
		// TODO Auto-generated constructor stub
	}
	
	public ErrorResult()
	{
		super(false);
	}
}
