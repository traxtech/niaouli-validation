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

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;
import org.niaouli.validation.Validation;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class ObjectValidationTest {

    @Test
    public void testNotNullVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat("john").inField("name").isNotNull();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("name").isNotNull();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError("null", "name"));
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).isNotNull();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError("null"));
        }
    }

    @Test
    public void testNullVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat((String) null).inField("name").isNull();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("john").inField("name").isNull();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError("notNull", "name"));
        }

    }

    @Test
    public void testIsInMapVerification() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("2", 2);

        try {
            Validation validation = new Validation();
            validation.verifyThat("1").inField("val").isInMapKeys(map);
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("3").inField("val").isInMapKeys(map);
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError("notFound", "val"));
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("3").inField("val").isInMapKeys(null);
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError("notFound", "val"));
        }

    }

    @Test
    public void testIsNotInMapVerification() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("2", 2);

        try {
            Validation validation = new Validation();
            validation.verifyThat("3").inField("val").isNotInMapKeys(map);
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("3").inField("val").isNotInMapKeys(null);
            validation.finish();
        } catch (AppException ex) {
            fail();
        }

        try {
            Validation validation = new Validation();
            validation.verifyThat("1").inField("val").isNotInMapKeys(map);
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError("duplicate", "val"));
        }

    }

}
