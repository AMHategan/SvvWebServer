package exception;

public class MaintenanceFailWebServerException extends Exception{

	public MaintenanceFailWebServerException() {
		super("Maintenance Fail for the Web Server");
	}
}
