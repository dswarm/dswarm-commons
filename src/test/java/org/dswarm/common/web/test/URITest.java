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
package org.dswarm.common.web.test;

import org.junit.Assert;
import org.junit.Test;

import org.dswarm.common.web.URI;

/**
 * @author tgaengler
 */
public class URITest {

	@Test
	public void testSlashURI() {

		final String namespaceURI = "http://example.com/ontology/";
		final String localName = "myattribute";
		final String uriString = namespaceURI + localName;

		testURI(uriString, namespaceURI, localName);
	}

	@Test
	public void testHashURI() {

		final String namespaceURI = "http://example.com/ontology#";
		final String localName = "myattribute";
		final String uriString = namespaceURI + localName;

		testURI(uriString, namespaceURI, localName);
	}

	private void testURI(final String uriString, final String namespaceURI, final String localName) {

		final URI uri = new URI(uriString);

		Assert.assertTrue(uri.hasNamespaceURI());
		Assert.assertTrue(uri.hasLocalName());
		Assert.assertEquals(namespaceURI, uri.getNamespaceURI());
		Assert.assertEquals(localName, uri.getLocalName());
	}
}
