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
public class ValidableCollectionChecker extends
    CollectionChecker<Validable, ValidableCollectionChecker> {

  public ValidableCollectionChecker(final Validation validation,
      final Collection<? extends Validable> value) {
    super(validation, value);
  }

  /**
   * Verify that all the elements of the collection are valid.
   *
   * @return this
   */
  public ValidableCollectionChecker areAllValid() {
    if (value != null) {
      int pos = 0;
      for (Validable validable : value) {
        if (getField() != null) {
          getValidation().pushPath(getField() + "[" + pos + "]");
        }
        validable.validate(getValidation());
        if (getField() != null) {
          getValidation().popPath();
        }
        pos++;
      }
    }
    return this;
  }
}
