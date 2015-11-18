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

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class ValidationHolder<F extends ValidationHolder<F>> {

    protected final Validation validation;
    protected String field;

    public ValidationHolder(final Validation pValidation) {
        validation = pValidation;
    }

    public final F inField(final String pField) {
        field = pField;
        return (F) this;
    }
}
