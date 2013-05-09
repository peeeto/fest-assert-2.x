/*
 * Created on Oct 24, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.api.character;

import static org.mockito.Mockito.verify;

import org.fest.assertions.api.CharacterAssert;
import org.fest.assertions.api.CharacterAssertBaseTest;

/**
 * Tests for <code>{@link CharacterAssert#isEqualTo(char)}</code>.
 * 
 * @author Alex Ruiz
 */
public class CharacterAssert_isEqualTo_char_Test extends CharacterAssertBaseTest {

  @Override
  protected CharacterAssert invoke_api_method() {
    return assertions.isEqualTo('b');
  }

  @Override
  protected void verify_internal_effects() {
    verify(characters).assertEqualTo(getInfo(assertions), getActual(assertions), 'b');
  }
}
