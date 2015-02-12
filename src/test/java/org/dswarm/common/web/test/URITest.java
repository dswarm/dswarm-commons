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
