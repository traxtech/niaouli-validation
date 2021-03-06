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

import java.util.Collection;

/**
 *
 * @author Arnaud Rolly
 */
public class CollectionChecker<T, F extends CollectionChecker<? extends T, F>> extends
    ObjectChecker<Collection<? extends T>, F> {

  public static final String MSG_EMPTY = "org.niaouli.validation.collection.empty";

  public static final String MSG_NOT_EMPTY = "org.niaouli.validation.collection.notEmpty";

  public CollectionChecker(final Validation validation, final Collection<? extends T> value) {
    super(validation, value);
  }

  /**
   * Verify that the collection is not empty. If the verification fails, an error is added to the
   * validation context with the message "empty".
   *
   * @return this
   */
  public F isNotEmpty() {
    if (value == null || value.isEmpty()) {
      addError(MSG_EMPTY, null, getField());
    }
    return (F) this;
  }

  /**
   * Verify that the collection is empty. If the verification fails, an error is added to the
   * validation context with the message "notEmpty".
   *
   * @return this
   */
  public F isEmpty() {
    if (value != null && !value.isEmpty()) {
      addError(MSG_NOT_EMPTY, null, getField());
    }
    return (F) this;
  }

}
