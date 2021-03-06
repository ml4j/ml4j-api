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

package org.ml4j.nn.activationfunctions;

import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * 
 * Encapsulates the artifacts generated by a forward propagation through an
 * ActivationFunction.
 * 
 * @author Michael Lavelle
 *
 * @param <F> The specific class of the ActivationFunction which producted this
 *            activation.
 * @param <G> The specific class of this ActivationFunctionActivation.
 */
public interface ActivationFunctionActivation<F extends ActivationFunction<F, G>, G extends ActivationFunctionActivation<F, G>> {

	/**
	 * @return The input Neuron activations.
	 */
	NeuronsActivation getInput();

	/**
	 * @return The output Neuron activations.
	 */
	NeuronsActivation getOutput();

	/**
	 * @return The ActivationFunction that generated this Activation.
	 */
	F getActivationFunction();

}
