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

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;
import org.niaouli.validation.CollectionChecker;
import org.niaouli.validation.Validation;

/**
 *
 * @author Arnaud Rolly
 */
public class CollectionCheckerTest {

    @Test
    public void testNotEmptyVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat(Arrays.asList("linux")).inField("os").isNotEmpty();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }
        try {
            Validation validation = new Validation();
            validation.verifyThat((List<String>) null).inField("os").isNotEmpty();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(CollectionChecker.MSG_EMPTY, "os"));
        }
        try {
            Validation validation = new Validation();
            validation.verifyThat(Arrays.asList()).inField("os").isNotEmpty();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(CollectionChecker.MSG_EMPTY, "os"));
        }
    }

    @Test
    public void testEmptyVerification() {
        try {
            Validation validation = new Validation();
            validation.verifyThat(Arrays.asList()).inField("os").isEmpty();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }
        try {
            Validation validation = new Validation();
            validation.verifyThat((List<String>) null).inField("os").isEmpty();
            validation.finish();
        } catch (AppException ex) {
            fail();
        }
        try {
            Validation validation = new Validation();
            validation.verifyThat(Arrays.asList("Solaris")).inField("os").isEmpty();
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(CollectionChecker.MSG_NOT_EMPTY, "os"));
        }
    }

}
