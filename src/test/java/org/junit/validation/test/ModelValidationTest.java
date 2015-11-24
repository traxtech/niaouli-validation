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
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;
import org.niaouli.validation.Validation;
import org.niaouli.validation.ValidationStringHolder;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class ModelValidationTest {

    @Test
    public void testNoErrors() throws AppException {
        Validation validation = new Validation();
        PersonModel person = buildValidPerson();
        person.validate(validation);
        validation.finish();
    }

    @Test
    public void testFieldError() throws AppException {
        Validation validation = new Validation();
        PersonModel person = buildValidPerson();
        person.setName(null);
        person.validate(validation);
        try {
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_BLANK, "name"));
        }
    }

    @Test
    public void testNestedFieldError() throws AppException {
        Validation validation = new Validation();
        PersonModel person = buildValidPerson();
        person.getUnit().setName(null);
        person.validate(validation);
        try {
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_BLANK, "unit.name"));
        }
    }

    @Test
    public void testCollectionError() throws AppException {
        Validation validation = new Validation();
        PersonModel person = buildValidPerson();
        person.getGroups().get(0).setName(null);
        person.validate(validation);
        try {
            validation.finish();
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(ValidationStringHolder.MSG_BLANK, "groups[0].name"));
        }
    }

    private PersonModel buildValidPerson() {
        PersonModel person = new PersonModel();
        person.setName("john");
        UnitModel unit = new UnitModel();
        unit.setName("R&D");
        person.setUnit(unit);
        GroupModel grp1 = new GroupModel();
        grp1.setName("users");
        GroupModel grp2 = new GroupModel();
        grp2.setName("scm");
        person.setGroups(Arrays.asList(grp1, grp2));
        return person;
    }
}
