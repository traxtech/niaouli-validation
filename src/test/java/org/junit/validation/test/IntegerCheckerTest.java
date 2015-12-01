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

package org.junit.validation.test;

import java.io.Serializable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;
import org.niaouli.validation.IntegerChecker;
import org.niaouli.validation.Validation;

/**
 *
 * @author Arnaud Rolly
 */
public class IntegerCheckerTest {

  @Test
  public void testGreaterThan() {
    // Checks that 34 is greater than 18 : must not fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(34).inField("age").isGreaterThan(18);
      validation.finish();
    } catch (AppException ex) {
      fail();
    }
    // Checks that 10 is greater that 21 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(10).inField("age").isGreaterThan(21);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_GREATER_THAN, new Serializable[] {21, 10}, "age"));
    }
    // Checks that null is greater that 21 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat((Integer) null).inField("age").isGreaterThan(21);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_GREATER_THAN, new Serializable[] {21, null}, "age"));
    }
  }

  @Test
  public void testGreaterOrEqualsThan() {
    // Checks that 34 is greater or equals than 18, and that 18 is greater
    // or equals than 18 : must not fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(34).inField("age").isGreaterOrEqualsThan(18);
      validation.verifyThat(18).inField("age").isGreaterOrEqualsThan(18);
      validation.finish();
    } catch (AppException ex) {
      fail();
    }
    // Checks that 10 is greater or equals that 21 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(10).inField("age").isGreaterOrEqualsThan(21);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_GREATER_OR_EQUALS_THAN, new Serializable[] {21, 10},
              "age"));
    }
    // Checks that null is greater or equals that 21 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat((Integer) null).inField("age").isGreaterOrEqualsThan(21);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_GREATER_OR_EQUALS_THAN,
              new Serializable[] {21, null}, "age"));
    }
  }

  @Test
  public void testLowerThan() {
    // Checks that 34 is lower than 65 : must not fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(34).inField("age").isLowerThan(65);
      validation.finish();
    } catch (AppException ex) {
      fail();
    }
    // Checks that 73 is lower that 65 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(73).inField("age").isLowerThan(65);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_LOWER_THAN, new Serializable[] {65, 73}, "age"));
    }
    // Checks that null is lower that 21 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat((Integer) null).inField("age").isLowerThan(21);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_LOWER_THAN, new Serializable[] {21, null}, "age"));
    }
  }

  @Test
  public void testLowerOrEqualsThan() {
    // Checks that 34 is lower or equals than 65, and that 65 is lower
    // or equals than 65 : must not fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(34).inField("age").isLowerOrEqualsThan(65);
      validation.verifyThat(65).inField("age").isLowerOrEqualsThan(65);
      validation.finish();
    } catch (AppException ex) {
      fail();
    }
    // Checks that 73 is lower or equals that 65 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(73).inField("age").isLowerOrEqualsThan(65);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_LOWER_OR_EQUALS_THAN, new Serializable[] {65, 73},
              "age"));
    }
    // Checks that null is lower or equals to 21 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat((Integer) null).inField("age").isLowerOrEqualsThan(21);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_LOWER_OR_EQUALS_THAN, new Serializable[] {21, null},
              "age"));
    }
  }

  @Test
  public void testEqualsTo() {
    // Checks that 42 is equals to 42 : must not fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(34).inField("mojo").isEqualsTo(34);
      validation.finish();
    } catch (AppException ex) {
      fail();
    }
    // Checks that 101010 is equals to 42 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(101010).inField("mojo").isEqualsTo(42);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_EQUALS_TO, new Serializable[] {42, 101010}, "mojo"));
    }
    // Checks that null is equals to 42 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat((Integer) null).inField("mojo").isEqualsTo(42);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_EQUALS_TO, new Serializable[] {42, null}, "mojo"));
    }
  }

  @Test
  public void testDifferentThan() {
    // Checks that 42 is different than 101010 : must not fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(42).inField("mojo").isDifferentThan(101010);
      validation.finish();
    } catch (AppException ex) {
      fail();
    }
    // Checks that 42 is different than 42 : must fail
    try {
      Validation validation = new Validation();
      validation.verifyThat(42).inField("mojo").isDifferentThan(42);
      validation.finish();
      fail();
    } catch (AppException ex) {
      assertThat(ex.getErrors()).containsExactly(
          new AppError(IntegerChecker.MSG_NOT_DIFFERENT_THAN, new Serializable[] {42}, "mojo"));
    }
    // Checks that null is different than 42 : must not fail
    try {
      Validation validation = new Validation();
      validation.verifyThat((Integer) null).inField("mojo").isDifferentThan(42);
      validation.finish();
    } catch (AppException ex) {
      fail();
    }
  }

}
