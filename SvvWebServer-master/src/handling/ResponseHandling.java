package handling;

import webserver.Request;
import webserver.Response;
import providers.*;

import java.io.IOException;
import java.nio.file.*;

import exception.InvalidRootDirException;

public class ResponseHandling {
	public static Response getResponse(Request request, Integer state) throws IOException, InvalidRootDirException {
        Response response;
        String uri = request.getURL();

        if(state == 0){
            return new Response("503","text/html",new HTMLProvider().provide404());
        }
        else if(state == 2){
            return new Response("503 Service Unavailable","text/html",new HTMLProvider().provide404());
        }


        if(uri.equals("/")) {
            response = new Response("200 OK","text/html",new HTMLProvider().provideDefault());
        }
        else if(getContentType(uri) == null){
            response = new Response("404 Not found","text/html",new HTMLProvider().provide404());
        }
        else{
            response = new Response("200 OK",getContentType(uri),provideContent(uri, getContentType(uri)));
        }

        return response;
    }

    private static byte[] provideContent(String url, String contentType) throws IOException, InvalidRootDirException {
        ContentProvider provider;

        if(contentType.contains("html"))
            provider = new HTMLProvider();
        else if (contentType.contains("css"))
            provider = new CSSProvider();
        else
            return new HTMLProvider().provide404();

        return provider.provide(url);
    }

    private static String getContentType(String resource) throws IOException {
        Path path = Paths.get(resource);
        return Files.probeContentType(path);
    }
}
