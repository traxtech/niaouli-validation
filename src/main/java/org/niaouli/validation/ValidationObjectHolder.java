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

import java.util.Map;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class ValidationObjectHolder<T, F extends ValidationObjectHolder<T, F>> extends ValidationHolder<F> {

    /**
     * Object to validate.
     */
    protected T value;

    public ValidationObjectHolder(final Validation pValidation, final T pValue) {
        super(pValidation);
        value = pValue;
    }

    /**
     * Verify that the object is not empty. If the verification fails, an error
     * is added to the validation context with the message "null".
     *
     * @return this
     */
    public final F isNotNull() {
        if (value == null) {
            validation.addError("null", null, field);
        }
        return (F) this;
    }

    /**
     * Verify that the object is null. If the verification fails, an error is
     * added to the validation context with the message "notNull".
     *
     * @return this
     */
    public final F isNull() {
        if (value != null) {
            validation.addError("notNull", null, field);
        }
        return (F) this;
    }

    /**
     * Verify that the object is a map keys. . If the verification fails, an
     * error is added to the validation context with the message "notFound".
     *
     * @param map Map to cjeck the object agains the keys.
     * @return this
     */
    public final F isInMapKeys(Map<T, ? extends Object> map) {
        if (map == null || !map.containsKey(value)) {
            validation.addError("notFound", null, field);
        }
        return (F) this;
    }

    /**
     * Verify that the object is not a map keys. . If the verification fails, an
     * error is added to the validation context with the message "duplicate".
     *
     * @param map Map to cjeck the object agains the keys.
     * @return this
     */
    public final F isNotInMapKeys(Map<T, ? extends Object> map) {
        if (map != null && map.containsKey(value)) {
            validation.addError("duplicate", null, field);
        }
        return (F) this;
    }

}
