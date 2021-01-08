package handling;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import exception.InvalidRequestException;
import parsers.RequestParser;
import webserver.Request;

public class RequestHandling {
	private Request newRequest;
    private BufferedReader in;

    public RequestHandling(Socket clientSocket) throws IOException {
        this.in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
    }

    public Request handleRequests() throws IOException, InvalidRequestException {
        String request = this.getRequest();
        this.createNewRequest(request);
        return this.newRequest;
    }

    public void close() throws IOException {
        this.in.close();
    }

    private String getRequest() throws IOException {
        String input;
        StringBuilder request = new StringBuilder();

        while ((input = in.readLine()) != null) {
            System.out.println(input);
            request.append(input + "\r\n");

            if (input.trim().equals(""))
                break;
        }
        return request.toString();
    }


    private void createNewRequest(String request) throws InvalidRequestException {
        RequestParser parser = new RequestParser(request);
        this.newRequest = new Request(parser.getMethod(),parser.getResource(),parser.getHost(),parser.getHTTP());
    }

}
