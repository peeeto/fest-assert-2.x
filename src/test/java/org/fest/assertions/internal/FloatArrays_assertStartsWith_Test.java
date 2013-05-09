/*
 * Created on Dec 20, 2010
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

import static org.fest.assertions.error.ShouldStartWith.shouldStartWith;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.fest.assertions.description.Description;
import org.fest.assertions.error.ShouldNotBeNull;
import org.fest.assertions.error.ShouldStartWith;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link FloatArrays#assertStartsWith(Description, float[], float[])}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class FloatArrays_assertStartsWith_Test {

  @Rule
  public ExpectedException thrown = none();

  private FloatArrays arrays;
  private Description description;
  private Failures failures;

  @Before
  public void setUp() {
    arrays = new FloatArrays();
    description = new TestDescription("testing");
    failures = spy(new Failures());
    Arrays parent = Arrays.instance();
    parent.failures = failures;
  }

  @Test
  public void should_fail_if_actual_is_null() {
    float[] sequence = new float[1];
    String message = ShouldNotBeNull.shouldNotBeNull().create(description);
    thrown.expect(AssertionError.class, message);
    arrays.assertStartsWith(description, null, sequence);
  }

  @Test
  public void should_fail_if_sequence_is_null() {
    float[] actual = new float[2];
    thrown.expect(NullPointerException.class, "The array of values to look for should not be null");
    arrays.assertStartsWith(description, actual, null);
  }

  @Test
  public void should_fail_if_sequence_is_empty() {
    float[] actual = new float[2];
    float[] sequence = {};
    thrown.expect(IllegalArgumentException.class, "The array of values to look for should not be empty");
    arrays.assertStartsWith(description, actual, sequence);
  }

  @Test
  public void should_fail_if_the_size_of_sequence_is_greater_than_the_size_of_actual() {
    float[] actual = new float[3];
    float[] sequence = new float[5];
    try {
      arrays.assertStartsWith(description, actual, sequence);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldStartWith(actual, sequence));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_does_not_start_with_sequence() {
    float[] actual = { 1f, 2f, 3f, 4f, 5f };
    float[] sequence = { 1f, 1f, 2f, 3f };
    try {
      arrays.assertStartsWith(description, actual, sequence);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldStartWith(actual, sequence));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_starts_with_given_sequence_with_duplicates() {
    float[] actual = { 1f, 2f, 3f, 4f, 5f };
    float[] sequence = { 1f, 2f, 2f };
    try {
      arrays.assertStartsWith(description, actual, sequence);
    } catch (AssertionError e) {
      verify(failures).failure(description, ShouldStartWith.shouldStartWith(actual, sequence));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_pass_if_actual_starts_with_given_sequence() {
    float[] actual = { 1f, 2f, 3f, 4f, 5f };
    float[] sequence = { 1f, 2f };
    arrays.assertStartsWith(description, actual, sequence);
  }
}
