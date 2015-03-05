/**
 * Copyright (C) 2013 – 2015 SLUB Dresden & Avantgarde Labs GmbH (<code@dswarm.org>)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * This file is part of d:swarm graph extension.
 *
 * d:swarm graph extension is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * d:swarm graph extension is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with d:swarm graph extension.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.dswarm.common.model;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.dswarm.common.model.deserializer.ContentSchemaDeserializer;

/**
 * Created by tgaengler on 29/07/14.
 */
@JsonDeserialize(using = ContentSchemaDeserializer.class)
public class ContentSchema {

	@JsonProperty("record_identifier_attribute_path")
	private final AttributePath recordIdentifierAttributePath;

	@JsonProperty("key_attribute_paths")
	private final LinkedList<AttributePath> keyAttributePaths;

	@JsonProperty("value_attribute_path")
	private final AttributePath valueAttributePath;

	public ContentSchema(final AttributePath recordIdentifierAttributePathArg, final LinkedList<AttributePath> keyAttributePathsArg,
			final AttributePath valueAttributePathArg) {

		recordIdentifierAttributePath = recordIdentifierAttributePathArg;
		keyAttributePaths = keyAttributePathsArg;
		valueAttributePath = valueAttributePathArg;
	}

	public AttributePath getRecordIdentifierAttributePath() {

		return recordIdentifierAttributePath;
	}

	public LinkedList<AttributePath> getKeyAttributePaths() {

		return keyAttributePaths;
	}

	public AttributePath getValueAttributePath() {

		return valueAttributePath;
	}

	@Override
	public boolean equals(final Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final ContentSchema that = (ContentSchema) o;

		if (keyAttributePaths != null ? !keyAttributePaths.equals(that.keyAttributePaths) : that.keyAttributePaths != null) {
			return false;
		}
		if (recordIdentifierAttributePath != null ? !recordIdentifierAttributePath.equals(that.recordIdentifierAttributePath)
				: that.recordIdentifierAttributePath != null) {
			return false;
		}
		if (valueAttributePath != null ? !valueAttributePath.equals(that.valueAttributePath) : that.valueAttributePath != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {

		int result = recordIdentifierAttributePath != null ? recordIdentifierAttributePath.hashCode() : 0;
		result = 31 * result + (keyAttributePaths != null ? keyAttributePaths.hashCode() : 0);
		result = 31 * result + (valueAttributePath != null ? valueAttributePath.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {

		// TODO:

		return null;
	}

}
