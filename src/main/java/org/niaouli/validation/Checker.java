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
 * Base class to implements checkers from.
 *
 * @author Arnaud Rolly
 */
public class Checker<F extends Checker<F>> {

  private final Validation validation;
  private String field;

  public Checker(final Validation initValidation) {
    validation = initValidation;
  }

  public F inField(final String initField) {
    field = initField;
    return (F) this;
  }

  protected Validation getValidation() {
    return validation;
  }

  protected void addError(final String msg, final Serializable[] params, final String field) {
    validation.addError(msg, params, field);
  }

  protected String getField() {
    return field;
  }
}
