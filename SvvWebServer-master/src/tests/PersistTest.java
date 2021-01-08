package tests;

import org.junit.Test;

import configurations.Persist;
import exception.InvalidPortException;
import exception.InvalidRootDirectoryException;
import exception.InvalidMaintenanceDirectoryException;

public class PersistTest {
	
	@Test(expected = InvalidPortException.class)
	public void testInvalidPortNumber1() throws InvalidPortException {
		Persist persist = new Persist();
		
		persist.setPort(0);
	}
	
	@Test(expected = InvalidPortException.class)
	public void testInvalidPortNumber2() throws InvalidPortException {
		Persist persist = new Persist();
		
		persist.setPort(12000);
	}

	
	@Test
	public void testValidPortNumber() throws InvalidPortException {
		Persist persist = new Persist();
		
		persist.setPort(1024);
	}
	
	@Test
	public void testValidSetRootDirectory() throws InvalidRootDirectoryException {
		Persist persist = new Persist();
		
		persist.setRootDirectory("c:\\folder1\\folder2");
	}
	
	@Test(expected = InvalidRootDirectoryException.class)
	public void testInvalidSetRootDirectory1() throws InvalidRootDirectoryException {
		Persist persist = new Persist();
		
		persist.setRootDirectory("file.txt");
	}
	
	@Test(expected = InvalidRootDirectoryException.class)
	public void testInvalidSetRootDirectory2() throws InvalidRootDirectoryException {
		Persist persist = new Persist();
		
		persist.setRootDirectory("ef|fe");
	}
	
	@Test
	public void testValidMaintenanceDirectory() throws InvalidMaintenanceDirectoryException {
		Persist persist = new Persist();
		
		persist.setMaintenanceDirectory("MainFolder");
	}
	
	@Test(expected = InvalidMaintenanceDirectoryException.class)
	public void testInvalidMaintenanceDirectory1() throws InvalidMaintenanceDirectoryException {
		Persist persist = new Persist();
		
		persist.setMaintenanceDirectory("fol|der");
	}
	
	@Test(expected = InvalidMaintenanceDirectoryException.class)
	public void testInvalidMaintenanceDirectory2() throws InvalidMaintenanceDirectoryException {
		Persist persist = new Persist();
		
		persist.setMaintenanceDirectory("new.txt");
	}
}