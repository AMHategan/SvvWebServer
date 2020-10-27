package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import configurations.Configuration;
import exception.FailedLoadingConfigurationException;
import exception.FailedSavingConfigurationException;

public class ConfigTest {
	
	Configuration config;
	
	@Test
	public void testSetSetting() {
		config = new Configuration("valid");
		
		assertEquals("true", config.setSetting("Port number", "8080"));
		assertEquals("true", config.setSetting("Root Directory", "/www_root"));
		assertEquals("true", config.setSetting("Maintenance Directory", "/maintn"));
	}
	
	@Test
	public void testLoadinfConfiguration1() throws FailedLoadingConfigurationException {
		config = new Configuration("valid");
		
		config.loadConfiguration("file.txt");
	}
	
	@Test
	public void testLoadinfConfiguration2() throws FailedLoadingConfigurationException {
		config = new Configuration("valid");
		
		config.loadConfiguration("folder1\\fiLE1.txt");
	}
	
	@Test(expected = FailedLoadingConfigurationException.class)
	public void testInvalidLoadConfiguration1() throws FailedLoadingConfigurationException {
		config = new Configuration("valid");
		
		config.loadConfiguration(null);
	}
	
	@Test(expected = FailedLoadingConfigurationException.class)
	public void testInvalidLoadConfiguration2() throws FailedLoadingConfigurationException {
		config = new Configuration("valid");
		
		config.loadConfiguration("12aaa");
	}
	
	@Test(expected = FailedLoadingConfigurationException.class)
	public void testInvalidLoadConfiguration3() throws FailedLoadingConfigurationException {
		config = new Configuration("valid");
		
		config.loadConfiguration("text:c|a");
	}
	
	@Test(expected = FailedSavingConfigurationException.class)
	public void testInvalidSavingConfiguration() throws FailedSavingConfigurationException{
		config = new Configuration("valid");
		
		config.saveConfiguration();
	}
	
	
}
