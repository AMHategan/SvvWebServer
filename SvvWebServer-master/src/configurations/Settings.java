package configurations;

public class Settings {

	public static Persist persist;

	static {
		persist = new Persist("src/configurations/properties");
	}
}
