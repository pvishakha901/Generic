package base;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"file:src\\main\\resources\\config\\config.properties"})
public interface EnvironmentSetup extends Config {

	String browser();
	
	String environment();

	@Config.Key("${environment}.adminURL")
	String adminurl();

	@Config.Key("${environment}.adminUsername")
	String adminUsername();

	@Config.Key("${environment}.adminPassword")
	String adminPassword();

}
