package tests;

import exception.RunningWebServerException;

import exception.WebServerStateException;

import org.junit.Test;

import exception.InactiveWebServerException;
import exception.MaintenanceFailWebServerException;
import webserver.WebServerState;

public class WebServerStateTest {

	@Test(expected = RunningWebServerException.class)
    public void testStartRunningWebServer() throws RunningWebServerException{
        WebServerState state = new WebServerState();
        state.startWebServer();
    }


	@Test
    public void testStartInMaintenanceWebServer() throws WebServerStateException, MaintenanceFailWebServerException, RunningWebServerException{
        WebServerState state = new WebServerState();
        state.maintenanceWebServer();
        state.startWebServer();
    }


    @Test
    public void testStopInMaintenanceWebServer() throws WebServerStateException, MaintenanceFailWebServerException, InactiveWebServerException{
        WebServerState state = new WebServerState();
        state.maintenanceWebServer();
        state.stopWebServer();
    }


    @Test(expected = MaintenanceFailWebServerException.class)
    public void testMaintenanceStoppedWebServer() throws WebServerStateException, InactiveWebServerException, MaintenanceFailWebServerException{
        WebServerState state = new WebServerState();
        state.stopWebServer();
        state.maintenanceWebServer();
    }


    @Test(expected = InactiveWebServerException.class)
    public void testStopStoppedWebServer() throws WebServerStateException, InactiveWebServerException{
        WebServerState state = new WebServerState();
        state.stopWebServer();
        state.stopWebServer();
    }

}
