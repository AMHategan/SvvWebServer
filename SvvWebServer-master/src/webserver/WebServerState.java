package webserver;

import exception.InactiveWebServerException;
import exception.MaintenanceFailWebServerException;
import exception.RunningWebServerException;

public class WebServerState {

    
     //0 stopped,1 running,2 maintenance
     
    private static int webServerState=0;

    public static int getWebServerState(){
        return webServerState;
    }

    public static void startWebServer() throws RunningWebServerException {
        if(webServerState == 1)
            throw new RunningWebServerException();
        webServerState = 1;
    }


    public static void stopWebServer() throws InactiveWebServerException {
        if(webServerState == 0)
            throw new InactiveWebServerException();
        webServerState = 0;
    }


    public static void maintenanceWebServer() throws MaintenanceFailWebServerException {
        if(webServerState != 1)
            throw new MaintenanceFailWebServerException();
        webServerState = 2;
    }

}
