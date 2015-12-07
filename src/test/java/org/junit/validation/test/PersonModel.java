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

import java.util.List;
import org.niaouli.validation.Validable;
import org.niaouli.validation.Validation;

/**
 * Validable object for the Object check test.
 *
 * @author Arnaud Rolly
 */
public class PersonModel implements Validable {

  private String name;
  private UnitModel unit;
  private List<GroupModel> groups;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UnitModel getUnit() {
    return unit;
  }

  public void setUnit(UnitModel unit) {
    this.unit = unit;
  }

  public List<GroupModel> getGroups() {
    return groups;
  }

  public void setGroups(List<GroupModel> groups) {
    this.groups = groups;
  }

  @Override
  public void validate(Validation validation) {
    validation.verifyThat(name).inField("name").isNotBlank();
    validation.verifyThatValidable(unit).inField("unit").isNotNull().isValid();
    validation.verifyThatValidables(groups).inField("groups").areAllValid();
  }
}
