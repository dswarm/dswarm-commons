/*
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

import org.dswarm.graph.model.util.AttributePathUtil;

/**
 * Created by tgaengler on 29/07/14.
 */
public class AttributePath {

	private final LinkedList<Attribute> attributes;

	public AttributePath(final LinkedList<Attribute> attributesArg) {

		attributes = attributesArg;
	}

	public LinkedList<Attribute> getAttributes() {

		return attributes;
	}

	@Override
	public boolean equals(final Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final AttributePath that = (AttributePath) o;

		if (attributes != null ? !attributes.equals(that.attributes) : that.attributes != null) {

			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {

		return attributes != null ? attributes.hashCode() : 0;
	}

	@Override public String toString() {

		return AttributePathUtil.generateAttributePath(attributes);
	}
}
