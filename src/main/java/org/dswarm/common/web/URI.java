package org.dswarm.common.web;

/**
 * @author tgaengler
 */
public class URI {

	public static final  String HASH                = "#";
	public static final  String SLASH               = "/";

	private final String localName;
	private final String namespaceURI;

	public URI(final String uriString) {

		// TODO: do parameter check

		final String lastPartDelimiter;

		if (uriString.lastIndexOf(HASH) > 0) {

			lastPartDelimiter = HASH;
		} else if (uriString.lastIndexOf(SLASH) > 0) {

			lastPartDelimiter = SLASH;
		} else {

			lastPartDelimiter = null;
		}

		if (lastPartDelimiter != null) {

			localName = uriString.substring(uriString.lastIndexOf(lastPartDelimiter) + 1, uriString.length());
			namespaceURI = uriString.substring(0, uriString.lastIndexOf(lastPartDelimiter) + 1);
		} else {

			localName = uriString;
			namespaceURI = null;
		}
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
}
