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

/**
 *
 * @author Arnaud Rolly
 */
public class StringChecker extends ObjectChecker<String, StringChecker> {

  public static final String MSG_BLANK = "org.niaouli.validation.string.blank";

  public static final String MSG_NOT_BLANK = "org.niaouli.validation.string.notBlank";

  public static final String MSG_EMPTY = "org.niaouli.validation.string.empty";

  public static final String MSG_NOT_EMPTY = "org.niaouli.validation.string.notEmpty";

  public StringChecker(final Validation validation, final String value) {
    super(validation, value);
  }

  /**
   * Verify that the string is not blank. If the verification fails, an error is added to the
   * validation context with the message "blank".
   *
   * @return this
   */
  public StringChecker isNotBlank() {
    if (value == null || value.trim().isEmpty()) {
      addError(MSG_BLANK, null, getField());
    }
    return this;
  }

  /**
   * Verify that the string is blank. If the verification fails, an error is added to the validation
   * context with the message "notBlank".
   *
   * @return this
   */
  public StringChecker isBlank() {
    if (value != null && !value.trim().isEmpty()) {
      addError(MSG_NOT_BLANK, null, getField());
    }
    return this;
  }

  /**
   * Verify that the string is not empty. If the verification fails, an error is added to the
   * validation context with the message "empty".
   *
   * @return this
   */
  public StringChecker isNotEmpty() {
    if (value == null || value.isEmpty()) {
      addError(MSG_EMPTY, null, getField());
    }
    return this;
  }

  /**
   * Verify that the string is empty. If the verification fails, an error is added to the validation
   * context with the message "notEmpty".
   *
   * @return this
   */
  public StringChecker isEmpty() {
    if (value != null && !value.isEmpty()) {
      addError(MSG_NOT_EMPTY, null, getField());
    }
    return this;
  }

  /**
   * Returns a ValidationIntegerHolder to do some verifications on the length of the string.
   *
   * @return ValidationIntegerHolder with the string length.
   */
  public IntegerChecker length() {
    final IntegerChecker lengthValidation;
    if (value == null) {
      lengthValidation = new IntegerChecker(getValidation(), null);
    } else {
      lengthValidation = new IntegerChecker(getValidation(), value.length());
    }
    lengthValidation.inField(getField() + "[length]");
    return lengthValidation;
  }
}
