package providers;

import java.io.IOException;

import configurations.Settings;
import configurations.Persist;
import exception.InvalidRootDirException;


public abstract class ContentProvider {
	
	protected Persist persist = Settings.persist;
	public abstract byte[] provide(String url) throws InvalidRootDirException, IOException;
}
