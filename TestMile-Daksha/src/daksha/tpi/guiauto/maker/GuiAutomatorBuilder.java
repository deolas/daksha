package daksha.tpi.guiauto.maker;

import daksha.core.batteries.config.TestContext;
import daksha.tpi.guiauto.enums.GuiAutomationContext;

public abstract class GuiAutomatorBuilder {
	private TestContext testContext = null;
	private GuiAutomationContext automationContext = null;
	
	public GuiAutomatorBuilder(TestContext testContext) throws Exception{
		this.testContext = testContext;
		this.automationContext = testContext.getAutomationContext();
	}
	
	protected TestContext getTestContext() {
		return this.testContext;
	}
	
	protected GuiAutomationContext getAutomationContext() {
		return this.automationContext;
	}

}
