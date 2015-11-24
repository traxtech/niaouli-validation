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
package org.junit.validation.test;

import java.io.Serializable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;
import org.niaouli.validation.Validation;
import org.niaouli.validation.ValidationIntegerHolder;
import org.niaouli.validation.ValidationStringHolder;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class StringValidationTest {

    @Test
    public void testNotBlankVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat("john").inField("name").isNotBlank();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("name").isNotBlank();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_BLANK, "name"));
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("").inField("name").isNotBlank();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_BLANK, "name"));
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat(" ").inField("name").isNotBlank();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_BLANK, "name"));
        }

    }

    @Test
    public void testBlankVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("name").isBlank();
            validation.verifyThat((String) "").inField("name").isBlank();
            validation.verifyThat((String) "  ").inField("name").isBlank();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("john").inField("name").isBlank();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_NOT_BLANK, "name"));
        }

    }

    @Test
    public void testNotEmptyVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat("john").inField("name").isNotEmpty();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("name").isNotEmpty();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_EMPTY, "name"));
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("").inField("name").isNotEmpty();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_EMPTY, "name"));
        }
    }

    @Test
    public void testEmptyVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("name").isEmpty();
            validation.verifyThat((String) "").inField("name").isEmpty();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("john").inField("name").isEmpty();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_NOT_EMPTY, "name"));
        }

    }

    @Test
    public void testSize() {
        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("name").length().isNull();
            validation.verifyThat((String) "").inField("name").length().isEqualsTo(0);
            validation.verifyThat((String) "john").inField("name").length().isEqualsTo(4);
            validation.verifyThat((String) "john").inField("name").length().isGreaterOrEqualsThan(3);
            validation.verifyThat((String) "john").inField("name").length().isGreaterOrEqualsThan(4);
            validation.verifyThat((String) "john").inField("name").length().isLowerOrEqualsThan(255);
            validation.verifyThat((String) "john").inField("name").length().isLowerOrEqualsThan(4);
            validation.verifyThat((String) "john").inField("name").length().isDifferentThan(42);
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("FKZ").inField("countryCode").length().isEqualsTo(2);
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationIntegerHolder.MSG_NOT_EQUALS_TO, new Serializable[]{2, 3}, "countryCode[length]"));
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("countryCode").length().isEqualsTo(2);
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationIntegerHolder.MSG_NOT_EQUALS_TO, new Serializable[]{2, null}, "countryCode[length]"));
        }

    }
}
