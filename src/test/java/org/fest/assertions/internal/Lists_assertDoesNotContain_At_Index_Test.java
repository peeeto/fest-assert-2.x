/*
 * Created on Dec 2, 2010
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
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.error.ShouldNotContainAtIndex.shouldNotContainAtIndex;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.fest.util.Arrays.array;
import static org.fest.util.Collections.list;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.fest.assertions.data.Index;
import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link Lists#assertDoesNotContain(Description, List, Object, Index)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class Lists_assertDoesNotContain_At_Index_Test {

  @Rule
  public ExpectedException thrown = none();

  private final List<String> actual = list("Luke", "Yoda", "Leia");
  private Lists lists;
  private Failures failures;
  private Description description;

  @Before
  public void setUp() {
    lists = Lists.instance();
    failures = spy(new Failures());
    lists.failures = failures;
    description = new TestDescription("testing");
  }

  @Test
  public void should_pass_if_actual_does_not_contain_given_values() {
    lists.assertDoesNotContain(description, actual, array("Han"), Index.atIndex(0));
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull());
    lists.assertDoesNotContain(description, null, array("Yoda"), Index.atIndex(0));
  }

  @Test
  public void should_fail_if_actual_contains_given_values_at_given_index() {
    Object expected = "Yoda";
    try {
      lists.assertDoesNotContain(description, actual, expected, Index.atIndex(1));
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldNotContainAtIndex(actual, expected, Index.atIndex(1)));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
}
