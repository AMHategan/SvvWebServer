package parsers;

public class RequestParser {

	private String[] requests;
	private String[] requestsComponents;
	
	public RequestParser(String request) {
		this.requests = request.split("\r\n");
		this.requestsComponents = this.requests[0].split(" ");
	}
	
	public String getResource() {
		String resource = this.requestsComponents[1];
		return resource;
	}
	
	public String getHTTP() {
		String HTTP = this.requestsComponents[2];
		return HTTP;
	}
	
	public String getHost() {
		String host = this.requestsComponents[1].split(":")[1];
		return host;
	}
	
	public String getMethod() {
		String method = this.requestsComponents[0];
		return method;
	}
}
