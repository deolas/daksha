/*******************************************************************************
 * Copyright 2015-18 Test Mile Software Testing Pvt Ltd
 * 
 * Website: www.TestMile.com
 * Email: support [at] testmile.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package daksha.ex.config;

import java.io.File;

public class AppConfig {
	public static String DRIVER_DIR = System.getProperty("user.dir") 
			+ File.separator
			+ "drivers"
			+ File.separator;
			
	public static String CHROME_DRIVER_PATH = DRIVER_DIR + "chromedriver";
	public static String GECKO_DRIVER_PATH = DRIVER_DIR + "geckodriver";
	public static String WP_URL = "http://192.168.56.101";
	public static String WP_ADMIN_URL = WP_URL + "/wp-admin";
	public static String USER_NAME = "user";
	public static String PASSWORD = "bitnami";
	public static String WP_LOGOUT_URL = WP_URL + "/wp-login.php?action=logout";
	
	public static String APP_PKG = "org.wordpress.android";
	public static String APP_ACTIVITY = APP_PKG + ".ui.WPLaunchActivity";

}
