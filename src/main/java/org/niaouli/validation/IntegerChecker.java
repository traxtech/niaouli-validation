/**
 * This file is part of Niaouli Validation.
 *
 * Niaouli Validation is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Niaouli Validation is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Niaouli Validation.
 * If not, see http://www.gnu.org/licenses/ .
 */

package org.niaouli.validation;

import java.io.Serializable;

/**
 *
 * @author Arnaud Rolly
 */
public class IntegerChecker extends ObjectChecker<Integer, IntegerChecker> {

  public static final String MSG_NOT_GREATER_THAN = "org.niaouli.validation.integer.notGreaterThan";

  public static final String MSG_NOT_GREATER_OR_EQUALS_THAN =
      "org.niaouli.validation.integer.notGreaterOrEqualsThan";

  public static final String MSG_NOT_LOWER_THAN = "org.niaouli.validation.integer.notLowerThan";

  public static final String MSG_NOT_LOWER_OR_EQUALS_THAN =
      "org.niaouli.validation.integer.notLowerOrEqualsThan";

  public static final String MSG_NOT_EQUALS_TO = "org.niaouli.validation.integer.notEqualsTo";

  public static final String MSG_NOT_DIFFERENT_THAN =
      "org.niaouli.validation.integer.notDifferentThan";

  public IntegerChecker(final Validation validation, final Integer value) {
    super(validation, value);
  }

  public IntegerChecker isGreaterThan(final int minValue) {
    if (value == null || value <= minValue) {
      addError(MSG_NOT_GREATER_THAN, new Serializable[] {minValue, value}, getField());
    }
    return this;
  }

  public IntegerChecker isGreaterOrEqualsThan(final int minValue) {
    if (value == null || value < minValue) {
      addError(MSG_NOT_GREATER_OR_EQUALS_THAN, new Serializable[] {minValue, value}, getField());
    }
    return this;
  }

  public IntegerChecker isLowerThan(final int maxValue) {
    if (value == null || value >= maxValue) {
      addError(MSG_NOT_LOWER_THAN, new Serializable[] {maxValue, value}, getField());
    }
    return this;
  }

  public IntegerChecker isLowerOrEqualsThan(final int maxValue) {
    if (value == null || value > maxValue) {
      addError(MSG_NOT_LOWER_OR_EQUALS_THAN, new Serializable[] {maxValue, value}, getField());
    }
    return this;
  }

  public IntegerChecker isEqualsTo(final int expectedValue) {
    if (value == null || !value.equals(expectedValue)) {
      addError(MSG_NOT_EQUALS_TO, new Serializable[] {expectedValue, value}, getField());
    }
    return this;
  }

  public IntegerChecker isDifferentThan(final int erroneousValue) {
    if (value != null && value.equals(erroneousValue)) {
      addError(MSG_NOT_DIFFERENT_THAN, new Serializable[] {erroneousValue}, getField());
    }
    return this;
  }

}
