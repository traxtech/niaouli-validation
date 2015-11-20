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
public class ValidationIntegerHolder
        extends ValidationObjectHolder<Integer, ValidationIntegerHolder> {

    public ValidationIntegerHolder(Validation pValidation, Integer pValue) {
        super(pValidation, pValue);
    }

    public final ValidationIntegerHolder isGreaterThan(int minValue) {
        if (value == null || value <= minValue) {
            addError("notGreaterThan", new Serializable[]{minValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isGreaterOrEqualsThan(int minValue) {
        if (value == null || value < minValue) {
            addError("notGreaterOrEqualsThan", new Serializable[]{minValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isLowerThan(int maxValue) {
        if (value == null || value >= maxValue) {
            addError("notLowerThan", new Serializable[]{maxValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isLowerOrEqualsThan(int maxValue) {
        if (value == null || value > maxValue) {
            addError("notLowerOrEqualsThan", new Serializable[]{maxValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isEqualsTo(int expectedValue) {
        if (value == null || !value.equals(expectedValue)) {
            addError("notEqualsTo", new Serializable[]{expectedValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isDifferentThan(int erroneousValue) {
        if (value != null && value.equals(erroneousValue)) {
            addError("notDifferentThan", new Serializable[]{erroneousValue}, getField());
        }
        return this;
    }

}
