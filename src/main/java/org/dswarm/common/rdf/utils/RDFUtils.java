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
package org.dswarm.common.rdf.utils;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 *
 * @author tgaengler
 *
 */
public class RDFUtils {

	private static final Logger			LOG	= LoggerFactory.getLogger(RDFUtils.class);

	public static long determineDatasetSize(final Dataset dataset) {

		if (dataset == null) {

			LOG.debug("dataset is null - can't count statements");

			return -1;
		}

		final Iterator<String> graphURIs = dataset.listNames();

		if (graphURIs == null) {

			LOG.debug("there are now graphs in the dataset - can't count statements");

			return -1;
		}

		long statementCount = 0;

		while (graphURIs.hasNext()) {

			final String graphURI = graphURIs.next();

			if (!dataset.containsNamedModel(graphURI)) {

				continue;
			}

			final Model graphModel = dataset.getNamedModel(graphURI);

			if (graphModel == null) {

				continue;
			}

			statementCount += graphModel.size();
		}

		// note: don't reach long number limit :)

		return statementCount;
	}
}
