package configurations;

import exception.InvalidPortException;

import java.io.IOException;

import exception.FailedSavingConfigurationException;
import exception.InvalidMaintenanceDirectoryException;
import exception.InvalidRootDirectoryException;
import validators.*;

public class Persist {
	
	private Configuration configuration;
	
	public Persist(String config) {
		this.configuration = Configuration.getConfiguration(config);
	}
	
	public int getPort() {
		String port = this.configuration.getSetting("port");
		int portNumber = Integer.parseInt(port);
		return portNumber;
	}
	
	public String getRootDirectory() {
		String rootDirectory = this.configuration.getSetting("root_directory");
		return rootDirectory;
	}
	
	public String getMaintenanceDirectory() {
		String maintenanceDirectory = this.configuration.getSetting("maintenance_directory");
		return maintenanceDirectory;
	}
	
	public void setPort(int portNumber) throws InvalidPortException {
		if(!PortNumberValidator.validate(portNumber))
			throw new InvalidPortException();
		this.configuration.setSetting("port", String.valueOf(portNumber));
	}
	
	public void setRootDirectory(String rootDirectory) throws InvalidRootDirectoryException {
		if(!RootDirectoryValidator.validate(rootDirectory))
			throw new InvalidRootDirectoryException();
		this.configuration.setSetting("root_directory", rootDirectory);
	}
	
	public void setMaintenanceDirectory(String maintenanceDirectory) throws InvalidMaintenanceDirectoryException {
		if(!MaintenanceDirectoryValidator.validate(maintenanceDirectory))
			throw new InvalidMaintenanceDirectoryException();
		this.configuration.setSetting("maintenance_directory", maintenanceDirectory);
	}
	
	public String getNotFoundPage() {
		String notFoundPage = this.configuration.getSetting("not_found_page");
		return notFoundPage;
	}
	
	public void setNotFoundPage(String notFoundPage) {
		this.configuration.setSetting("not_found_page", notFoundPage);
	}
	
	public String getDefaultPage() {
		String defaultPage = this.configuration.getSetting("default_page");
		return defaultPage;
	}
	
	public void setDefaultPage(String defaultPage) {
		this.configuration.setSetting("default_page", defaultPage);
	}
	
	public void save() throws FailedSavingConfigurationException, IOException {
		this.configuration.saveConfiguration();
	}
}
