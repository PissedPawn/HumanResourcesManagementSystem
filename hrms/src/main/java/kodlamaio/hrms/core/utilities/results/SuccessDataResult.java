package kodlamaio.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	
	public SuccessDataResult(T data, String message) {
		super(data, message, true);
		// TODO Auto-generated constructor stub
	}
	
	public SuccessDataResult(T data)
	{
		super(data, true);
	}
	
	public SuccessDataResult(String message)
	{
		super(null, message, true);
	}
	
	public SuccessDataResult()
	{
		super(null, null, true);
	}
}

