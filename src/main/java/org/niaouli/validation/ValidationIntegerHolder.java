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

    public static final String MSG_NOT_GREATER_THAN
            = "org.niaouli.validation.integer.notGreaterThan";

    public static final String MSG_NOT_GREATER_OR_EQUALS_THAN
            = "org.niaouli.validation.integer.notGreaterOrEqualsThan";

    public static final String MSG_NOT_LOWER_THAN
            = "org.niaouli.validation.integer.notLowerThan";

    public static final String MSG_NOT_LOWER_OR_EQUALS_THAN
            = "org.niaouli.validation.integer.notLowerOrEqualsThan";

    public static final String MSG_NOT_EQUALS_TO
            = "org.niaouli.validation.integer.notEqualsTo";

    public static final String MSG_NOT_DIFFERENT_THAN
            = "org.niaouli.validation.integer.notDifferentThan";

    public ValidationIntegerHolder(final Validation pValidation,
            final Integer pValue) {
        super(pValidation, pValue);
    }

    public final ValidationIntegerHolder isGreaterThan(final int pMinValue) {
        if (value == null || value <= pMinValue) {
            addError(MSG_NOT_GREATER_THAN, new Serializable[]{pMinValue, value},
                    getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isGreaterOrEqualsThan(
            final int pMinValue) {
        if (value == null || value < pMinValue) {
            addError(MSG_NOT_GREATER_OR_EQUALS_THAN,
                    new Serializable[]{pMinValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isLowerThan(final int pMaxValue) {
        if (value == null || value >= pMaxValue) {
            addError(MSG_NOT_LOWER_THAN, new Serializable[]{pMaxValue, value},
                    getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isLowerOrEqualsThan(
            final int pMaxValue) {
        if (value == null || value > pMaxValue) {
            addError(MSG_NOT_LOWER_OR_EQUALS_THAN,
                    new Serializable[]{pMaxValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isEqualsTo(final int pExpectedValue) {
        if (value == null || !value.equals(pExpectedValue)) {
            addError(MSG_NOT_EQUALS_TO,
                    new Serializable[]{pExpectedValue, value}, getField());
        }
        return this;
    }

    public final ValidationIntegerHolder isDifferentThan(
            final int pErroneousValue) {
        if (value != null && value.equals(pErroneousValue)) {
            addError(MSG_NOT_DIFFERENT_THAN,
                    new Serializable[]{pErroneousValue}, getField());
        }
        return this;
    }

}
