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
package daksha.core.cleanup.actions.element;

import java.util.List;

import daksha.core.cleanup.element.proxy.UiElementProxy;
import daksha.tpi.cleanup.element.UiElement;

public interface MultiElementHandler {	
	// Get wrapped object from raw object, already identified ones
	UiElement getInstanceAtIndex(int index) throws Exception;
	UiElement get(int index) throws Exception;
	UiElement getInstanceAtOrdinal(int ordinal) throws Exception;
	UiElement getRandomInstance() throws Exception;
	UiElement getFirstInstance() throws Exception;
	UiElement getLastInstance() throws Exception;
	int getElementCount() throws Exception;
	UiElement getInstanceByText(String text) throws Exception;
	UiElement getInstanceByTextContent(String text) throws Exception;
	List<UiElementProxy> getAllInstances() throws Exception;
}
