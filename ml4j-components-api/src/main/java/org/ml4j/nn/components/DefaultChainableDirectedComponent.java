package org.ml4j.nn.components;

import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultChainableDirectedComponent<A extends DefaultChainableDirectedComponentActivation, C> extends ChainableDirectedComponent<NeuronsActivation, A, C> {

	@Override
	DefaultChainableDirectedComponent<A, C> dup();	
}
