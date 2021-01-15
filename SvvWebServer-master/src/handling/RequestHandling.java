package handling;

import java.io.BufferedReader;  
import java.io.IOException;
import exception.InvalidRequestException;
import parsers.RequestParser;
import webserver.Request;
import webserver.Channel;

public class RequestHandling {
	public static Request getRequest(Channel channel) throws IOException, InvalidRequestException {
        String request = readRequest(channel.getClientEnd());

        RequestParser parser = new RequestParser(request);
        Request r = new Request(parser.getMethod(),parser.getResource(),parser.getHost(),parser.getHTTP());
        return r;
    }

    private static String readRequest(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder request = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            request.append(inputLine + "\r\n");
            if (inputLine.trim().equals(""))
                break;
        }
        
        return request.toString();
    }
}
