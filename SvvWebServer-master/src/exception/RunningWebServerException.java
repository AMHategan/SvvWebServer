package exception;

public class RunningWebServerException extends Exception{
	
	public RunningWebServerException() {
		super("Up and Running WebServer already");
	}
}
