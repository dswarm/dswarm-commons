/**
 * Copyright (C) 2013 – 2017 SLUB Dresden & Avantgarde Labs GmbH (<code@dswarm.org>)
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
package org.dswarm.common.model.deserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import org.dswarm.common.model.Attribute;
import org.dswarm.common.model.AttributePath;
import org.dswarm.common.model.ContentSchema;
import org.dswarm.common.model.util.AttributePathUtil;
import org.dswarm.common.model.util.ContentSchemaUtil;

/**
 * Created by tgaengler on 29/07/14.
 */
public class ContentSchemaDeserializer extends JsonDeserializer<ContentSchema> {

	private Map<String, Attribute>     attributeMap     = new HashMap<>();
	private Map<String, AttributePath> attributePathMap = new HashMap<>();

	@Override
	public ContentSchema deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {

		final ObjectCodec oc = jp.getCodec();

		if (oc == null) {

			return null;
		}

		final JsonNode node = oc.readTree(jp);

		if (node == null) {

			return null;
		}

		final JsonNode recordIdentifierAttributePathNode = node.get(ContentSchemaUtil.RECORD_IDENTIFIER_ATTRIBUTE_PATH);
		final AttributePath recordIdentifierAttributePath = AttributePathUtil.parseAttributePathNode(recordIdentifierAttributePathNode, attributeMap,
				attributePathMap);

		final JsonNode keyAttributePathsNode = node.get(ContentSchemaUtil.KEY_ATTRIBUTE_PATHS);
		final LinkedList<AttributePath> keyAttributePaths = AttributePathUtil.parseAttributePathsNode(keyAttributePathsNode, attributeMap,
				attributePathMap);

		final JsonNode valueAttributePathNode = node.get(ContentSchemaUtil.VALUE_ATTRIBUTE_PATH);
		final AttributePath valueAttributePath = AttributePathUtil.parseAttributePathNode(valueAttributePathNode, attributeMap, attributePathMap);

		return new ContentSchema(recordIdentifierAttributePath, keyAttributePaths, valueAttributePath);
	}

}
