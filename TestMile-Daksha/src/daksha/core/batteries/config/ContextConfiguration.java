package daksha.core.batteries.config;

import java.util.Map;

public class ContextConfiguration extends BaseConfiguration{
	
	 public ContextConfiguration(CentralConfiguration centralConf, Map<String, String> contextOptions) throws Exception {
		 super(centralConf);
		 this.add(contextOptions);
	 }

}
