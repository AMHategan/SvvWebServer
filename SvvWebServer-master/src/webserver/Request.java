package webserver;

import java.util.Objects;

public class Request {
	private String method;
	private String URL;
	private String HTTP;
	private String host;
	
	public Request(String method,String URL,String HTTP,String host){
		this.method = method;
		this.URL = URL;
		this.HTTP = HTTP;
		this.host = host;
		}

	public String getMethod() {
		return method;
	}

	public String getURL() {
		return URL;
	}

	public String getHost() {
		return host;
	}

	public String getHTTP() {
		return HTTP;
	}

	@Override
	public String toString() {
		return "Request{"+"method='"+method+'\''+", URL='"+URL+'\''+", HTTP='"+HTTP+'\''+", host='"+host+'\''+'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Request request = (Request) o;
		return Objects.equals(method, request.method) && Objects.equals(URL, request.URL) &&
			   Objects.equals(HTTP, request.HTTP) && Objects.equals(host, request.host);
	}

	@Override
	public int hashCode() {
		return Objects.hash(method, URL, HTTP, host);
	}

}
