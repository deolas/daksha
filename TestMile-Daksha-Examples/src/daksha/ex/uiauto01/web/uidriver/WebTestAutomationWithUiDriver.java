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

package daksha.ex.uiauto01.web.uidriver;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import daksha.Daksha;
import daksha.core.leaping.enums.OSType;
import daksha.ex.config.AppConfig;
import daksha.tpi.leaping.automator.GuiAutomator;
import daksha.tpi.leaping.element.GuiElement;
import daksha.tpi.leaping.element.MultiGuiElement;
import daksha.tpi.leaping.generator.GuiAutomatorFactory;
import daksha.tpi.leaping.generator.selenium.SeleniumBuilder;

public class WebTestAutomationWithUiDriver {
	
	@Test
	public void test() throws Exception{
		Daksha.init();
		Daksha.setOSType(OSType.MAC);
		Daksha.freezeCentralConfig();
		
		SeleniumBuilder builder = GuiAutomatorFactory.getSeleniumBuilder(Daksha.getDefaultTestContext());
		GuiAutomator<WebDriver,WebElement> automator = builder.build();
		automator.goTo(AppConfig.WP_ADMIN_URL);		

		GuiElement userTextBox = automator.elementWithId("user_login");
		userTextBox.waitUntilPresent();
		userTextBox.enterText(AppConfig.USER_NAME);
		automator.elementWithId("user_pass").enterText(AppConfig.PASSWORD);
		automator.elementWithId("wp-submit").click();
		
		automator.elementWithCss(".dashicons-admin-post").hover();
		automator.elementWithLinkText("Categories").click();
		
		MultiGuiElement tags = automator.elementsWithName("delete_tags[]");
		tags.getInstanceAtOrdinal(2).check();
		tags.getInstanceAtIndex(1).uncheck();
		
		for (GuiElement element: tags.getAllInstances()){
			element.check();
			element.uncheck();
		}
		
		// Tests for alternate instance methods
		tags.getFirstInstance().check();
		tags.getFirstInstance().uncheck();
		
		tags.getLastInstance().check();
		tags.getLastInstance().uncheck();
		
		
		tags.getRandomInstance().check();
		tags.getRandomInstance().uncheck();
	
		automator.elementWithCss(".dashicons-admin-settings").hover();
		automator.elementWithLinkText("General").click();
		
		GuiElement blogNameTextBox = automator.elementWithId("blogname");
		blogNameTextBox.enterText("Hello");
		blogNameTextBox.enterText("Hello");
		blogNameTextBox.setText("Hello");
		
		automator.elementWithId("users_can_register").check();

		// Experiments with Select control - Selection using different attributes
		GuiElement roleDropDown = automator.elementWithId("default_role").asDropDown();
		roleDropDown.selectText("Author");
		assertTrue(roleDropDown.hasSelectedText("Author"), "Check Author Role Selected");
		roleDropDown.selectAtIndex(0);
		assertTrue(roleDropDown.hasSelectedIndex(0), "Check Author Role Selected");
		roleDropDown.selectValue("author");
		assertTrue(roleDropDown.hasSelectedValue("author"), "Check Author Role Selected");
		
		automator.goTo(AppConfig.WP_LOGOUT_URL);
		automator.close();
	}
}