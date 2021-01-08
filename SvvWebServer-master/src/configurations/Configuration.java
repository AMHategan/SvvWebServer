package configurations;

import exception.FailedLoadingConfigurationException; 
import exception.FailedSavingConfigurationException;
import validators.ConfigurationFileValidator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private String configurationFileName;
	private Properties properties;
	private static Configuration configuration;
	
	public Configuration(String configurationFileName) throws FailedLoadingConfigurationException, IOException{
		if(!ConfigurationFileValidator.validate(this.configurationFileName)) {
			throw new FailedLoadingConfigurationException();
		}
		this.configurationFileName=configurationFileName;
		this.properties = new Properties();
		this.loadConfiguration();
	}
	
	public void loadConfiguration() throws FailedLoadingConfigurationException, IOException {	
		FileReader reader = new FileReader(this.configurationFileName);
        this.properties.load(reader);
	}
	
	public void saveConfiguration() throws FailedSavingConfigurationException, IOException{	
		FileWriter writer = new FileWriter(this.configurationFileName);
        properties.store(writer, "");
		throw new FailedSavingConfigurationException();
	}
	
	public String getSetting(String key) {
		return this.properties.getProperty(key);
	}
	
	public boolean setSetting(String key, String name) {
		properties.setProperty(key, name);
		return true;
	}

	public static Configuration getConfiguration(String Configuration) {
		return configuration;
	}

}
