/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ml4j.nn.synapses;

import org.ml4j.nn.activationfunctions.ActivationFunction;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.neurons.Neurons;

/**
 * UndirectedSynapses are undirected containers for Axons and
 * ActivationFunctions
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the left of these UndirectedSynapses.
 * @param <R> The type of Neurons on the right of these UndirectedSynapses.
 */
public interface UndirectedSynapses<L extends Neurons, R extends Neurons> extends Synapses<UndirectedSynapses<L, R>> {

	/**
	 * @return The Axons within these UndirectedSynapses.
	 */
	Axons<?, ?, ?> getAxons();

	/**
	 * @return The Neurons on the left hand side of these UndirectedSynapses.
	 */
	L getLeftNeurons();

	/**
	 * @return The ActivationFunction for the output on the left hand side of these
	 *         UndirectedSynapses.
	 */
	ActivationFunction<?, ?> getLeftActivationFunction();

	/**
	 * @return The Neurons on the right hand side of these UndirectedSynapses.
	 */
	R getRightNeurons();

	/**
	 * @return The ActivationFunction for the output on the right hand side of these
	 *         UndirectedSynapses.
	 */
	ActivationFunction<?, ?> getRightActivationFunction();

	/**
	 * Push data from left to right through these UndirectedSynapses.
	 * 
	 * @param leftHandNeuronsInput                  The input on the left hand side
	 *                                              of these UndirectedSynapses
	 * @param previousRightToLeftSynapsesActivation If this push from left to right
	 *                                              depends on a previous push from
	 *                                              right to left, the previous
	 *                                              right-to-left activation should
	 *                                              be provided as an input here. It
	 *                                              is up to concrete
	 *                                              implementations of
	 *                                              UndirectedSynapses to determine
	 *                                              whether this input is required
	 *                                              or not and to validate this is
	 *                                              present - if not required this
	 *                                              input can be left as null.
	 * @param synapsesContext                       The context.
	 * @return The activation output on the right hand side of these
	 *         UndirectedSynapses.
	 */
	UndirectedSynapsesActivation pushLeftToRight(UndirectedSynapsesInput leftHandNeuronsInput,
			UndirectedSynapsesActivation previousRightToLeftSynapsesActivation,
			UndirectedSynapsesContext synapsesContext);

	/**
	 * Push data from right to left through these UndirectedSynapses.
	 * 
	 * @param rightHandNeuronsInput                 The input on the right hand side
	 *                                              of these UndirectedSynapses
	 * @param previousLeftToRightSynapsesActivation If this push from right to left
	 *                                              depends on a previous push from
	 *                                              left to right, the previous
	 *                                              left-to-right activation should
	 *                                              be provided as an input here. It
	 *                                              is up to concrete
	 *                                              implementations of
	 *                                              UndirectedSynapses to determine
	 *                                              whether this input is required
	 *                                              or not and to validate this is
	 *                                              present - if not required this
	 *                                              input can be left as null.
	 * @param synapsesContext                       The context.
	 * @return The activation output on the left hand side of these
	 *         UndirectedSynapses.
	 */
	UndirectedSynapsesActivation pushRightToLeft(UndirectedSynapsesInput rightHandNeuronsInput,
			UndirectedSynapsesActivation previousLeftToRightSynapsesActivation,
			UndirectedSynapsesContext synapsesContext);
	
	
	/**
	 * @return A deep copy of these Synapses.
	 */
	UndirectedSynapses<L, R> dup();

}
