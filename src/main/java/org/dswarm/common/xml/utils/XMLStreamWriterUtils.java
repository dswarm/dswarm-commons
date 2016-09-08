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
package org.dswarm.common.xml.utils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.dswarm.common.web.URI;

/**
 * @author tgaengler
 */
public final class XMLStreamWriterUtils {

	private static final AtomicInteger	counter					= new AtomicInteger(0);
	private static final String			NAMESPACE_PREFIX_BASE	= "ns";

	public static void writeXMLElementTag(final XMLStreamWriter writer,
	                                      final URI uri,
	                                      final Map<String, String> namespacesPrefixesMap,
	                                      final Map<String, String> nameMap,
	                                      final boolean isElementOpen) throws XMLStreamException {

		if (uri.hasNamespaceURI()) {

			final String baseURI = determineBaseURI(uri);
			final boolean containsNamespace = namespacesPrefixesMap.containsKey(baseURI);
			final String prefix = getPrefix(baseURI, namespacesPrefixesMap);

			final boolean namespaceAlreadyWritten;

			if(!containsNamespace && isElementOpen) {

				writer.writeNamespace(prefix, baseURI);
				namespaceAlreadyWritten = true;
			} else {

				namespaceAlreadyWritten = false;
			}

			writer.writeStartElement(prefix, createXMLName(uri, nameMap), baseURI);

			if(!containsNamespace && !namespaceAlreadyWritten) {

				writer.writeNamespace(prefix, baseURI);
			}
		} else {

			writer.writeStartElement(createXMLName(uri, nameMap));
		}
	}

	public static void writeXMLAttribute(final XMLStreamWriter writer,
	                                     final URI uri,
	                                     final String value,
	                                     final Map<String, String> namespacesPrefixesMap,
	                                     final Map<String, String> nameMap) throws XMLStreamException {

		if (uri.hasNamespaceURI()) {

			final String baseURI = determineBaseURI(uri);
			final String prefix = getPrefix(baseURI, namespacesPrefixesMap);

			writer.writeAttribute(prefix, baseURI, createXMLName(uri, nameMap), value);
		} else {

			writer.writeAttribute(createXMLName(uri, nameMap), value);
		}
	}

	public static String getPrefix(final String namespace,
	                               final Map<String, String> namespacesPrefixesMap) {

		if (!namespacesPrefixesMap.containsKey(namespace)) {

			namespacesPrefixesMap.put(namespace, NAMESPACE_PREFIX_BASE + counter.incrementAndGet());
		}

		return namespacesPrefixesMap.get(namespace);
	}

	private static String createXMLName(final URI uri,
	                                    final Map<String, String> nameMap) {

		if (!uri.hasLocalName()) {

			// TODO: do something else here, e.g., throw an exception

			return null;
		}

		final String localName = uri.getLocalName();

		if (nameMap.containsKey(localName)) {

			return nameMap.get(localName);
		}

		final String xmlName = XMLUtils.getXMLName(localName);

		nameMap.put(localName, xmlName);

		return xmlName;
	}

	public static String determineBaseURI(final URI uri) {

		if (uri.hasNamespaceURI() && uri.getNamespaceURI().endsWith(URI.HASH)) {

			return uri.getNamespaceURI().substring(0, uri.getNamespaceURI().length() - 1);
		}

		return uri.getNamespaceURI();
	}
}
