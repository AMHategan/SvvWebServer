package providers;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import exception.InvalidRootDirException;

public class CSSProvider extends ContentProvider{
	
	@Override
	public byte[] provide(String url) throws InvalidRootDirException, IOException {
        Path path = Paths.get(persist.getRootDirectory() + File.separatorChar +"css" + File.separatorChar + url);

        if(!Files.exists(path)) return "".getBytes();
        return Files.readAllBytes(path);
    }

}
