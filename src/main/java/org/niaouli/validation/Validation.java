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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;

/**
 * Validation entry point to do the verifications.
 *
 * @author Arnaud Rolly
 */
public class Validation {

  private List<AppError> errors;
  private Stack<String> location;

  public StringChecker verifyThat(final String value) {
    return new StringChecker(this, value);
  }

  public IntegerChecker verifyThat(final Integer value) {
    return new IntegerChecker(this, value);
  }

  public <T extends Object> CollectionChecker<T, ?> verifyThat(final Collection<? extends T> value) {
    return new CollectionChecker(this, value);
  }

  public ValidableChecker verifyThatValidable(final Validable value) {
    return new ValidableChecker(this, value);
  }

  public <T extends Validable> ValidableCollectionChecker verifyThatValidables(
      final Collection<? extends T> value) {
    return new ValidableCollectionChecker(this, value);
  }

  public void addError(final String msg, final Serializable[] params, final String field) {
    if (errors == null) {
      errors = new ArrayList<AppError>();
    }
    final String finalPath;
    if (location == null || location.isEmpty()) {
      finalPath = field;
    } else {
      StringBuilder pathBuilder = new StringBuilder();
      for (String pathElem : location) {
        if (pathBuilder.length() > 0) {
          pathBuilder.append(".");
        }
        pathBuilder.append(pathElem);
      }
      pathBuilder.append(".");
      pathBuilder.append(field);
      finalPath = pathBuilder.toString();
    }
    errors.add(new AppError(msg, params, finalPath));
  }

  public void finish() throws AppException {
    if (errors != null && !errors.isEmpty()) {
      throw new AppException(errors);
    }
  }

  void pushPath(final String path) {
    if (location == null) {
      location = new Stack<String>();
    }
    location.push(path);
  }

  void popPath() {
    if (location != null) {
      location.pop();
    }
  }

}
