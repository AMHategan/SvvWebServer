package webserver;

import java.io.BufferedReader; 
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

public class WebServerUtils {

	public String getRequest(BufferedReader reader) throws IOException {
        String inputLine;
        StringBuilder request = new StringBuilder();

        while ((inputLine = reader.readLine()) != null) {
            System.out.println(inputLine);
            request.append(inputLine);

            if (inputLine.trim().equals(""))
                break;
        }
        return request.toString();
    }


    public String[] buildResponse(){
        return null;
    }


    public void sendResponse(OutputStream out) throws IOException {
        out.write(("HTTP/1.1 200 OK\r\n").getBytes());
        out.write(("ContentType: " + "text/html\r\n").getBytes());
        out.write("\r\n\r\n".getBytes());
        out.flush();
    }
}
