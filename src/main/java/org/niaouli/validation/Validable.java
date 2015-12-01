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

/**
 * Interface to implements to be validable.
 *
 * @author Arnaud Rolly
 */
public interface Validable {

  /**
   * Validate the object.
   *
   * @param pValidation Validation context.
   */
  void validate(Validation validation);
}
