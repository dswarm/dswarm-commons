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
package org.dswarm.common.xml.utils;

import com.fasterxml.aalto.util.XmlChars;

/**
 * @author tgaengler
 */
public final class XMLUtils {

	private static final char			DEFAULT_NAME_CHAR		= '-';

	public static String getXMLName(final String name) {

		final StringBuilder sb = new StringBuilder();

		final int length = name.length();

		for (int i = 0; i < length; i++) {

			final int characterInt = (int) name.charAt(i);

			// TODO: change to 11, when we shall produce XML 1.1
			if (XmlChars.is10NameChar(characterInt)) {

				final char character = name.charAt(i);

				sb.append(character);
			} else {

				// append the default name char instead of the invalid one
				sb.append(DEFAULT_NAME_CHAR);
			}
		}

		return sb.toString();
	}
}
