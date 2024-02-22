package resource;

import java.util.ListResourceBundle;

public class Settings extends ListResourceBundle {
	
	private static final Object[][] RESOURCE = {
			{"theme","dark"},
			{"app-version","1.0"},
			{"java-version","17"},
			{"packing","jar"},
			{"type","DynamicWebProject"}
	};
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return RESOURCE ;
	}
	
}
