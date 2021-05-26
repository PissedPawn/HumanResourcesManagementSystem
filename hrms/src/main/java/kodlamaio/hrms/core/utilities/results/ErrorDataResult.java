package kodlamaio.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data, message, false);
		// TODO Auto-generated constructor stub
	}
	
	public ErrorDataResult(T data)
	{
		super(data, false);
	}

	public ErrorDataResult(String message)
	{
		super(null, message, false);
	}
	
	public ErrorDataResult()
	{
		super(null,null, false);
	}
	

}
