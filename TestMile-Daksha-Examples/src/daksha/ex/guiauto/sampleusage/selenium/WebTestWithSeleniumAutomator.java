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

package daksha.ex.guiauto.sampleusage.selenium;

import static org.testng.Assert.assertTrue;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import daksha.Daksha;
import daksha.core.guiauto.automator.proxy.GuiAutomatorProxy;
import daksha.core.guiauto.enums.OSType;
import daksha.ex.config.AppConfig;
import daksha.tpi.guiauto.element.GuiElement;
import daksha.tpi.guiauto.element.GuiMultiElement;
import daksha.tpi.guiauto.maker.GuiAutomatorFactory;
import daksha.tpi.guiauto.maker.selenium.SeleniumBuilder;
import daksha.tpi.testng.TestNGBaseTest;

public class WebTestWithSeleniumAutomator extends TestNGBaseTest{
	private ThreadLocal<GuiAutomatorProxy> threadWiseAutomator = new ThreadLocal<GuiAutomatorProxy>();
	
	protected void setCentralOptions() throws Exception {
		Daksha.setOSType(OSType.MAC);
	}
	
	@BeforeClass
	public void createAutomator(ITestContext testContext) throws Exception {
		SeleniumBuilder builder = GuiAutomatorFactory.getSeleniumBuilder(Daksha.getTestContext(this.getTestContextName()));
		this.threadWiseAutomator.set(builder.build());
	}
	
	@Test
	public void test() throws Exception{
		GuiAutomatorProxy automator = this.threadWiseAutomator.get();
		automator.goTo(AppConfig.WP_ADMIN_URL);	
		
		GuiElement userTextBox = automator.elementWithId("user_login");
		userTextBox.waitUntilPresent();
		userTextBox.enterText(AppConfig.USER_NAME);
		automator.elementWithId("user_pass").enterText(AppConfig.PASSWORD);
		automator.elementWithId("wp-submit").click();
		
		automator.elementWithCss(".dashicons-admin-post").hover();
		automator.elementWithLinkText("Categories").click();
		
		GuiMultiElement tags = automator.elementsWithName("delete_tags[]");
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

		GuiElement roleDropDown = automator.elementWithId("default_role").asDropDown();
		roleDropDown.selectText("Author");
		assertTrue(roleDropDown.hasSelectedText("Author"), "Check Author Role Selected");
		roleDropDown.selectAtIndex(0);
		assertTrue(roleDropDown.hasSelectedIndex(0), "Check Author Role Selected");
		roleDropDown.selectValue("author");
		assertTrue(roleDropDown.hasSelectedValue("author"), "Check Author Role Selected");
		
		automator.goTo(AppConfig.WP_LOGOUT_URL);
	}
	
	@AfterClass
	public void closeAutomator(ITestContext testContext) throws Exception {
		this.threadWiseAutomator.get().close();
	}
}
