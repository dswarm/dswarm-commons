/**
 * Copyright (C) 2013 – 2016 SLUB Dresden & Avantgarde Labs GmbH (<code@dswarm.org>)
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
package org.dswarm.common.model.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.commons.lang3.StringUtils;

import org.dswarm.common.DMPStatics;
import org.dswarm.common.model.Attribute;
import org.dswarm.common.model.AttributePath;
import org.dswarm.common.model.ContentSchema;

/**
 * Created by tgaengler on 29/07/14.
 */
public final class AttributePathUtil {

	public static String generateAttributePath(final List<Attribute> attributes) {

		if (attributes == null || attributes.isEmpty()) {

			return null;
		}

		final StringBuilder sb = new StringBuilder();

		for (int i = 0; i < attributes.size(); i++) {

			sb.append(attributes.get(i));

			if (i < (attributes.size() - 1)) {

				sb.append(DMPStatics.ATTRIBUTE_DELIMITER);
			}
		}

		return sb.toString();
	}

	public static String generateAttributePath(final Collection<String> attributePath) {

		if (null == attributePath) {

			return null;
		}

		if (attributePath.isEmpty()) {

			return null;
		}

		final StringBuilder sb = new StringBuilder();

		boolean first = true;

		for (final String attribute : attributePath) {

			if (!first) {

				sb.append(DMPStatics.ATTRIBUTE_DELIMITER);
			} else {

				first = false;
			}

			sb.append(attribute);
		}

		return sb.toString();
	}

	public static Optional<AttributePath> determineCommonAttributePath(final ContentSchema contentSchema) {

		if (contentSchema.getKeyAttributePaths() == null && contentSchema.getValueAttributePath() == null) {

			return Optional.empty();
		}

		final Map<String, AttributePath> attributePaths = new HashMap<>();
		final Map<String, Attribute> attributes = new HashMap<>();

		if (contentSchema.getKeyAttributePaths() != null) {

			for (final AttributePath attributePath : contentSchema.getKeyAttributePaths()) {

				fillMaps(attributePath, attributePaths, attributes);
			}
		}

		if (contentSchema.getValueAttributePath() != null) {

			fillMaps(contentSchema.getValueAttributePath(), attributePaths, attributes);
		}

		final String commonPrefix = StringUtils.getCommonPrefix(attributePaths.keySet().toArray(new String[attributePaths.size()]));

		final String commonAttributePathString = cleanCommonPrefix(commonPrefix);

		if (attributePaths.containsKey(commonAttributePathString)) {

			return Optional.ofNullable(attributePaths.get(commonAttributePathString));
		}

		final String[] attributeURIs = commonAttributePathString.split(DMPStatics.ATTRIBUTE_DELIMITER.toString());

		final LinkedList<Attribute> apAttributes = new LinkedList<>();

		for (final String attributeURI : attributeURIs) {

			final Attribute attribute = attributes.get(attributeURI);
			apAttributes.add(attribute);
		}

		return Optional.of(new AttributePath(apAttributes));
	}

	public static LinkedList<AttributePath> parseAttributePathsNode(final JsonNode attributePathsNode) {

		return parseAttributePathsNode(attributePathsNode, null, null);
	}

	public static LinkedList<AttributePath> parseAttributePathsNode(final JsonNode attributePathsNode, final Map<String, Attribute> attributeMap, final Map<String, AttributePath> attributePathMap) {

		if (attributePathsNode == null || !ArrayNode.class.isInstance(attributePathsNode)) {

			return null;
		}

		final LinkedList<AttributePath> attributePaths = new LinkedList<>();

		for (final JsonNode attributePathNode : attributePathsNode) {

			final AttributePath attributePath = parseAttributePathNode(attributePathNode, attributeMap, attributePathMap);

			if (attributePath != null) {

				attributePaths.add(attributePath);
			}
		}

		return attributePaths;
	}

	public static AttributePath parseAttributePathNode(final JsonNode attributePathNode) {

		return parseAttributePathNode(attributePathNode, null, null);
	}

	public static AttributePath parseAttributePathNode(final JsonNode attributePathNode, final Map<String, Attribute> attributeMap, final Map<String, AttributePath> attributePathMap) {

		if (attributePathNode == null) {

			return null;
		}

		final String attributePathString = attributePathNode.asText();

		return parseAttributePathString(attributePathString, attributeMap, attributePathMap);
	}

	public static AttributePath parseAttributePathString(final String attributePathString) {

		return parseAttributePathString(attributePathString, null, null);
	}

	public static AttributePath parseAttributePathString(final String attributePathString, final Map<String, Attribute> attributeMap, final Map<String, AttributePath> attributePathMap) {

		final String[] attributes = attributePathString.split(DMPStatics.ATTRIBUTE_DELIMITER.toString());

		if (attributes.length <= 0) {

			return null;
		}

		final LinkedList<Attribute> attributeList = new LinkedList<>();

		for (final String attributeURI : attributes) {

			final Attribute attribute = getOrCreateAttribute(attributeURI, Optional.ofNullable(attributeMap));
			attributeList.add(attribute);
		}

		return getOrCreateAttributePath(attributeList, Optional.ofNullable(attributePathMap));
	}

	private static Attribute getOrCreateAttribute(final String uri, final Optional<Map<String, Attribute>> optionalAttributeMap) {

		if (!optionalAttributeMap.isPresent()) {

			return new Attribute(uri);
		}

		if (!optionalAttributeMap.get().containsKey(uri)) {

			optionalAttributeMap.get().put(uri, new Attribute(uri));
		}

		return optionalAttributeMap.get().get(uri);
	}

	private static AttributePath getOrCreateAttributePath(final LinkedList<Attribute> attributePath, final Optional<Map<String, AttributePath>> optionalAttributePathMap) {

		if (!optionalAttributePathMap.isPresent()) {

			return new AttributePath(attributePath);
		}

		final String attributePathString = AttributePathUtil.generateAttributePath(attributePath);

		if (!optionalAttributePathMap.get().containsKey(attributePathString)) {

			optionalAttributePathMap.get().put(attributePathString, new AttributePath(attributePath));
		}

		return optionalAttributePathMap.get().get(attributePathString);
	}

	private static void fillMaps(final AttributePath attributePath, final Map<String, AttributePath> attributePaths,
	                             final Map<String, Attribute> attributes) {

		attributePaths.put(attributePath.toString(), attributePath);

		for (final Attribute apAttribute : attributePath.getAttributes()) {

			attributes.put(apAttribute.getUri(), apAttribute);
		}
	}

	private static String cleanCommonPrefix(final String commonPrefix) {

		if (!commonPrefix.endsWith(DMPStatics.ATTRIBUTE_DELIMITER.toString())) {

			if (!commonPrefix.contains(DMPStatics.ATTRIBUTE_DELIMITER.toString())) {

				return commonPrefix;
			}

			return commonPrefix.substring(0, commonPrefix.lastIndexOf(DMPStatics.ATTRIBUTE_DELIMITER));
		}

		return commonPrefix.substring(0, commonPrefix.length() - 1);
	}
}
