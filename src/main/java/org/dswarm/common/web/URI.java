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
package org.dswarm.common.web;

import org.dswarm.common.types.Tuple;

/**
 * @author tgaengler
 */
public class URI {

	public static final String HASH  = "#";
	public static final String SLASH = "/";

	private final String localName;
	private final String namespaceURI;
	private final String uriString;

	public URI(final String uriStringArg) {

		// TODO: do parameter check

		uriString = uriStringArg;

		final Tuple<String, String> uriParts = determineParts(uriString);
		namespaceURI = uriParts.v1();
		localName = uriParts.v2();
	}

	public boolean hasNamespaceURI() {

		return hasPart(namespaceURI);
	}

	public boolean hasLocalName() {

		return hasPart(localName);
	}

	public String getLocalName() {

		return localName;
	}

	public String getNamespaceURI() {

		return namespaceURI;
	}

	private boolean hasPart(final String uriPart) {

		return uriPart != null && !uriPart.trim().isEmpty();
	}

	@Override public String toString() {

		return uriString;
	}

	/**
	 *
	 *
	 * @param uriString
	 * @return a tuple where the first part ist the namespace URI and the second part ist the local name
	 */
	public static Tuple<String, String> determineParts(final String uriString) {

		final String lastPartDelimiter;

		if (uriString.lastIndexOf(HASH) > 0) {

			lastPartDelimiter = HASH;
		} else if (uriString.lastIndexOf(SLASH) > 0) {

			lastPartDelimiter = SLASH;
		} else {

			lastPartDelimiter = null;
		}

		final String localName;
		final String namespaceURI;

		if (lastPartDelimiter != null) {

			localName = uriString.substring(uriString.lastIndexOf(lastPartDelimiter) + 1, uriString.length());
			namespaceURI = uriString.substring(0, uriString.lastIndexOf(lastPartDelimiter) + 1);
		} else {

			localName = uriString;
			namespaceURI = "";
		}

		return Tuple.tuple(namespaceURI, localName);
	}
}
