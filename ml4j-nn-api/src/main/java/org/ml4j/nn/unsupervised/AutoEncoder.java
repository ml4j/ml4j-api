/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.unsupervised;

import org.ml4j.nn.CostAndGradients;
import org.ml4j.nn.LayeredFeedForwardNeuralNetwork;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * An AutoEncoder is an UnsupervisedNeuralNetwork consisting of
 * FeedForwardLayers.
 * 
 * @author Michael Lavelle
 */
public interface AutoEncoder extends UnsupervisedNeuralNetwork<AutoEncoderContext, AutoEncoder>,
		LayeredFeedForwardNeuralNetwork<AutoEncoderContext, AutoEncoder> {

	/**
	 * Encode the specified activations.
	 * 
	 * @param unencoded The activations we wish to encode.
	 * @param context   The AutoEncoder context under which we perform this encode.
	 * @return The encoded activations.
	 */
	NeuronsActivation encode(NeuronsActivation unencoded, AutoEncoderContext context);

	/**
	 * Decode the specified activations.
	 * 
	 * @param encoded The activations we wish to decode.
	 * @param context The AutoEncoder context under which we perform this decode.
	 * @return The decoded activations.
	 */
	NeuronsActivation decode(NeuronsActivation encoded, AutoEncoderContext context);

	/**
	 * Obtains the cost and weight gradients calculated for the outputs of this
	 * AutoEncoder.
	 * 
	 * @param inputActivations The NeuronsActivation produced by the input data
	 * 
	 * @param trainingContext  The NeuralNetworkContext used for training
	 * @return The CostAndGradients for the provided parameters.
	 */
	public CostAndGradients getCostAndGradients(NeuronsActivation inputActivations, AutoEncoderContext trainingContext);
}
