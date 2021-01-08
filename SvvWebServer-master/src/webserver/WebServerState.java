package webserver;

import exception.InactiveWebServerException;
import exception.MaintenanceFailWebServerException;
import exception.RunningWebServerException;

public class WebServerState {

    
     //0 stopped,1 running,2 maintenance
     

    private int webServerState;

    public WebServerState(){
        this.webServerState = 1;
    }

    public int getWebServerState(){
        return this.webServerState;
    }

    public void startWebServer() throws RunningWebServerException {
        if(this.webServerState == 1)
            throw new RunningWebServerException();
        this.webServerState = 1;
    }


    public void stopWebServer() throws InactiveWebServerException {
        if(this.webServerState == 0)
            throw new InactiveWebServerException();
        this.webServerState = 0;
    }


    public void maintenanceWebServer() throws MaintenanceFailWebServerException {
        if(this.webServerState != 1)
            throw new MaintenanceFailWebServerException();
        this.webServerState = 2;
    }

}
