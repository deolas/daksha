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
package daksha.core.leaping.interfaces;

import java.util.List;
import java.util.Map;

import daksha.tpi.leaping.enums.UiAutomationContext;

public interface ElementMetaData {

	boolean isRelevantForPage();

	void set(String propName, String value);

	String get(String propName);

	Map<String, String> getAllProperties();

	void addIdentifier(String key, String value);

	void process(UiAutomationContext identificationContext) throws Exception;

	List<String> getAllowedIdentifiers() throws Exception;

	List<Identifier> getIdentifiers();

	void processStrictly(UiAutomationContext automationContext) throws Exception;

}