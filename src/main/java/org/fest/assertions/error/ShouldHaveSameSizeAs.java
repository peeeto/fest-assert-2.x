/*
 * Created on Apr 27, 2012
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
 * Copyright @2010-2012 the original author or authors.
 */
package org.fest.assertions.error;

/**
 * Creates an error message indicating that an assertion that verifies that a value have certain size failed.
 *
 * @author Nicolas François
 */
public class ShouldHaveSameSizeAs extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldHaveSameSizeAs}</code>.
   * @param actual the actual value in the failed assertion.
   * @param actualSize the size of {@code actual}.
   * @param expectedSize the expected size.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldHaveSameSizeAs(Object actual, Object actualSize, Object expectedSize) {
    return new ShouldHaveSameSizeAs(actual, actualSize, expectedSize);
  }

  private ShouldHaveSameSizeAs(Object actual, Object actualSize, Object expectedSize) {
    super("expecting:\n actual and expected should have same size but actual size is:<%s> while expected is:<%s>, actual was:<%s>",
        actualSize, expectedSize, actual);
  }
}
