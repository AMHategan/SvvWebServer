package providers;

import java.io.IOException;
import java.io.File;
import java.nio.file.*;

import exception.InvalidRootDirException;

public class HTMLProvider extends ContentProvider {

	@Override
	public byte[] provide(String url) throws InvalidRootDirException, IOException {
		 Path path = Paths.get(persist.getRootDirectory() + File.separatorChar +"pages" + File.separatorChar + url);
	        return Files.readAllBytes(path);
	}

	public byte[] provide404() throws IOException {
        Path notFound = Paths.get(persist.getNotFoundPage());
        return Files.readAllBytes(notFound);
    }

    public byte[] provideDefault() throws IOException {
        Path def = Paths.get(persist.getDefaultPage());
        return Files.readAllBytes(def);
    }
}
