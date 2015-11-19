/**
 * This file is part of Niaouli Validation.
 *
 * Niaouli Validation is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * Niaouli Validation is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Niaouli Validation. If not, see <http://www.gnu.org/licenses/>.
 */
package org.niaouli.validation;

import java.io.Serializable;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class ValidationStringHolder
        extends ValidationObjectHolder<String, ValidationStringHolder> {

    public ValidationStringHolder(final Validation pValidation,
            final String pValue) {
        super(pValidation, pValue);
    }

    /**
     * Verify that the string is not blank. If the verification fails, an error
     * is added to the validation context with the message "blank".
     *
     * @return this
     */
    public final ValidationStringHolder isNotBlank() {
        if (value == null || value.trim().isEmpty()) {
            addError("blank", null, getField());
        }
        return this;
    }

    /**
     * Verify that the string is blank. If the verification fails, an error is
     * added to the validation context with the message "notBlank".
     *
     * @return this
     */
    public final ValidationStringHolder isBlank() {
        if (value != null && !value.trim().isEmpty()) {
            addError("notBlank", null, getField());
        }
        return this;
    }

    /**
     * Verify that the string is not empty. If the verification fails, an error
     * is added to the validation context with the message "empty".
     *
     * @return this
     */
    public final ValidationStringHolder isNotEmpty() {
        if (value == null || value.isEmpty()) {
            addError("empty", null, getField());
        }
        return this;
    }

    /**
     * Verify that the string is empty. If the verification fails, an error is
     * added to the validation context with the message "notEmpty".
     *
     * @return this
     */
    public final ValidationStringHolder isEmpty() {
        if (value != null && !value.isEmpty()) {
            addError("notEmpty", null, getField());
        }
        return this;
    }

    /**
     * Verify that the string has a given size. If the verification fails, an
     * error is added to the validation context with the message "size" and two
     * parameters : the expected size and the actual size.
     *
     * @param size Expected size
     * @return this
     */
    public final ValidationStringHolder hasSize(int size) {
        if (value == null) {
            addError("size", new Serializable[]{size, 0}, getField());
        }
        if (value.length() != size) {
            addError("size", new Serializable[]{size, value.length()},
                    getField());
        }
        return this;
    }
}
