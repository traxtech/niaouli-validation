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
 * If not, see http://www.gnu.org/licenses/.
 */

package org.niaouli.validation;

import java.util.Map;

/**
 *
 * @author Arnaud Rolly
 */
public class ObjectChecker<T, F extends ObjectChecker<T, F>> extends Checker<F> {

  public static final String MSG_NULL = "org.niaouli.validation.object.null";

  public static final String MSG_NOT_NULL = "org.niaouli.validation.object.notNull";

  public static final String MSG_NOT_FOUND = "org.niaouli.validation.object.notFound";

  public static final String MSG_FOUND = "org.niaouli.validation.object.found";

  /**
   * Object to validate.
   */
  protected T value;

  public ObjectChecker(final Validation validation, final T initValue) {
    super(validation);
    value = initValue;
  }

  /**
   * Verify that the object is not empty. If the verification fails, an error is added to the
   * validation context with the message "null".
   *
   * @return this
   */
  public F isNotNull() {
    if (value == null) {
      addError(MSG_NULL, null, getField());
    }
    return (F) this;
  }

  /**
   * Verify that the object is null. If the verification fails, an error is added to the validation
   * context with the message "notNull".
   *
   * @return this
   */
  public F isNull() {
    if (value != null) {
      addError(MSG_NOT_NULL, null, getField());
    }
    return (F) this;
  }

  /**
   * Verify that the object is a map keys. . If the verification fails, an error is added to the
   * validation context with the message "notFound".
   *
   * @param map Map to cjeck the object agains the keys.
   * @return this
   */
  public F isInMapKeys(final Map<T, ? extends Object> map) {
    if (map == null || !map.containsKey(value)) {
      addError(MSG_NOT_FOUND, null, getField());
    }
    return (F) this;
  }

  /**
   * Verify that the object is not a map keys. . If the verification fails, an error is added to the
   * validation context with the message "duplicate".
   *
   * @param map Map to cjeck the object agains the keys.
   * @return this
   */
  public F isNotInMapKeys(final Map<T, ? extends Object> map) {
    if (map != null && map.containsKey(value)) {
      addError(MSG_FOUND, null, getField());
    }
    return (F) this;
  }

}
