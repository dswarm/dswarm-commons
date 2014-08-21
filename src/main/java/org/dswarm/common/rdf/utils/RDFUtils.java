package org.dswarm.common.rdf.utils;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.rdf.model.Model;
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
