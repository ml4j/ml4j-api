package org.ml4j.nn.components.builders.axons;

import java.util.List;

import org.ml4j.Matrix;
import org.ml4j.nn.components.DefaultChainableDirectedComponent;
import org.ml4j.nn.components.builders.BaseGraphBuilderState;
import org.ml4j.nn.components.builders.common.ComponentsContainer;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphNeurons;
import org.ml4j.nn.neurons.Neurons;

public interface AxonsBuilder extends ComponentsContainer<Neurons> {
	
	Matrix getConnectionWeights();
	ComponentsGraphNeurons<Neurons> getComponentsGraphNeurons();
	List<DefaultChainableDirectedComponent<?, ?>> getComponents();
	BaseGraphBuilderState getBuilderState();

}
