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
package org.dswarm.common.web;

import java.util.Optional;

/**
 * @author tgaengler
 */
public class URI {

	public static final char HASH  = '#';
	public static final char SLASH = '/';

	private final Optional<String> localName;
	private final Optional<String> namespaceURI;
	private final String fullUri;

	private URI(final String localName, final String namespaceURI) {
		this(localName, Optional.ofNullable(namespaceURI).filter(s -> !s.isEmpty()));
	}

	private URI(final String localName, final Optional<String> namespaceURI) {
		this(Optional.ofNullable(localName).filter(s -> !s.isEmpty()), namespaceURI);
	}

	private URI(final Optional<String> localName, final Optional<String> namespaceURI) {
		this.localName = localName;
		this.namespaceURI = namespaceURI;
		fullUri = namespaceURI.orElse("") + localName.orElse("");
	}

	public boolean hasNamespaceURI() {
		return namespaceURI.isPresent();
	}

	public boolean hasLocalName() {
		return localName.isPresent();
	}

	public String getLocalName() {
		return localName.get();
	}

	public String getNamespaceURI() {
		return namespaceURI.get();
	}

	@Override public String toString() {
		return fullUri;
	}

	public static URI create(final String uriString) {
		return Optional
				.ofNullable(uriString)
				.map(URI::parse)
				.orElseGet(() -> new URI(Optional.empty(), Optional.empty()));
	}

	private static URI parse(final String uri) {
		return firstLastIndexOf(uri, HASH, SLASH)
				.map(idx      -> new URI(uri.substring(idx + 1), uri.substring(0, idx + 1)))
				.orElseGet(() -> new URI(uri, Optional.empty()));
	}

	private static Optional<Integer> firstLastIndexOf(final String haystack, final char... needles) {
		for (char needle : needles) {
			final int index = haystack.lastIndexOf(needle);
			if (index >= 0) {
				return Optional.of(index);
			}
		}
		return Optional.empty();
	}
}
