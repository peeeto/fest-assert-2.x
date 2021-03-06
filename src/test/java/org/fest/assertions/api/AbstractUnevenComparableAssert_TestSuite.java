/*
 * Created on Jun 24, 2013
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2013 the original author or authors.
 */
package org.fest.assertions.api;

import org.fest.assertions.api.AbstractUnevenComparableAssert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * All tests for {@link AbstractUnevenComparableAssert}.
 *
 * @author Yvonne Wang
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  AbstractUnevenComparableAssert_isEqualToByComparingTo_Test.class,
  AbstractUnevenComparableAssert_isNotEqualToByComparingTo_Test.class
})
public class AbstractUnevenComparableAssert_TestSuite {
}
