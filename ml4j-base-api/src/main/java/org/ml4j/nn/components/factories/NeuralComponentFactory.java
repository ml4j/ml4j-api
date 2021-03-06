/*
 * Copyright 2019 the original author or authors.
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
package org.ml4j.nn.components.factories;

import java.util.List;

import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.BatchNormAxonsConfig;
import org.ml4j.nn.axons.BiasVector;
import org.ml4j.nn.axons.ConvolutionalAxonsConfig;
import org.ml4j.nn.axons.FullyConnectedAxonsConfig;
import org.ml4j.nn.axons.PoolingAxonsConfig;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.components.manytoone.PathCombinationStrategy;
import org.ml4j.nn.neurons.Neurons;

/**
 * 
 * Factory interface whose implementations are responsible for creating
 * differentiable components required by DirectedNeuralNetworks
 * 
 * @author Michael Lavelle
 *
 */
public interface NeuralComponentFactory<T extends NeuralComponent<?>> {

	/**
	 * @param name The name of the component.
	 * @param leftNeurons The neurons on the LHS of the component.
	 * @param rightNeurons The neurons on the RHS of the component.
	 * @param neuralComponentType The type of component
	 * @return A component based on the provided parameters.
	 */
	T createComponent(String name, Neurons leftNeurons, Neurons rightNeurons,
			NeuralComponentType neuralComponentType);

	/**
	 * 
	 * @param name                          The name of the component.
	 * @param axonsConfig                   The left and right neurons configuration
	 *                                      for this component, and optionally an
	 *                                      AxonsContextConfigurer.
	 * @param connectionWeights             Optionally specify the connection
	 *                                      weights of the axons - if not provided
	 *                                      the weights will be initialised to
	 *                                      defaults.
	 * @param biases                        Optionally specify the left-to-right
	 *                                      biases of the axons - if not provided
	 *                                      the biases will be initialised to
	 *                                      defaults if the LHS neurons have a bias
	 *                                      unit.
	 * @return A fully-connected axons component, connecting leftNeurons to
	 *         rightNeurons via connectionWeights.
	 */
	T createFullyConnectedAxonsComponent(String name, FullyConnectedAxonsConfig axonsConfig,
			WeightsMatrix connectionWeights, BiasVector biases);

	/**
	 * 
	 * @param name                          The name of the component.
	 * @param config                        The ConvolutionalAxonsConfig
	 * @param connectionWeights             Specify the convolutional connection
	 *                                      weights of the axons. To default the
	 *                                      connection weights specify a
	 *                                      WeightsMatrix with the matrix null but
	 *                                      the WeightsFormat provided.
	 * @param biases                        Optionally specify the left-to-right
	 *                                      biases of the axons - if not provided
	 *                                      the biases will be initialised to
	 *                                      defaults if the LHS neurons have a bias
	 *                                      unit.
	 * @return A convolutional component connecting leftNeurons to rightNeurons
	 *         convolutionally via convolutional connectionWeights.
	 */
	T createConvolutionalAxonsComponent(String name, ConvolutionalAxonsConfig config, WeightsMatrix connectionWeights,
			BiasVector biases);

	/**
	 * Create a max-pooling axons component.
	 * 
	 * @param name 		   The name of the component.
	 * @param config       The PoolingAxonsConfig.
	 * @param scaleOutputs Whether to scale the output of the max pooling axons by a
	 *                     scaling factor to compensate for the max-pooling dropout.
	 * @return A max-pooling axons component.
	 */
	T createMaxPoolingAxonsComponent(String name, PoolingAxonsConfig config,
			boolean scaleOutputs);

	/**

	 * Create an average-pooling axons component.
	 * 
	 * @param name 		   The name of the component.
	 * @param config       The PoolingAxonsConfig.
	 * @return An average-pooling axons component.
	 */
	T createAveragePoolingAxonsComponent(String name, PoolingAxonsConfig config);

	/**
	 * Create a batch-norm directed axons component
	 * 
	 * @param <N>                           The type of neurons on the LHS/RHS of
	 *                                      these axons.
	 * @param name                          The name of the component.
	 * @param batchNormAxonsConfig               The config for this component
	 * @return A batch-norm directed axons component.
	 */
	<N extends Neurons> T createBatchNormAxonsComponent(String name, BatchNormAxonsConfig<N> batchNormAxonsConfig);

	/**
	 * Construct a pass-through (no-op) axons component - used within residual
	 * networks for skip-connections.
	 * 
	 * @param <N>          The type of neurons on the LHS/RHS of the pass-through
	 *                     axons.
	 * 
	 * @param name         The name of the component.
	 * @param leftNeurons  The neurons on the LHS of these pass-through axons.
	 * @param rightNeurons The neurons on the RHS of these pass-through axons.
	 * @return A pass-through (no-op) axons component
	 */
	<N extends Neurons> T createPassThroughAxonsComponent(String name, N leftNeurons, N rightNeurons);

	/**
	 * Construct a DifferentiableActivationFunctionComponent.
	 * 
	 * @param name 								The name of the component.
	 * @param neurons                          The neurons at which the
	 *                                         DifferentiableActivationFunctionComponent
	 *                                         will activate.
	 * @param differentiableActivationFunction The differentiable activation
	 *                                         function to be wrapped by this
	 *                                         component.
	 * @return A DifferentiableActivationFunctionComponent.
	 */
	T createDifferentiableActivationFunctionComponent(String name, Neurons neurons,
			DifferentiableActivationFunction differentiableActivationFunction);

	/**
	 * Construct a DifferentiableActivationFunctionComponent.
	 * 
	 * @param name 				     The name of the component.
	 * @param neurons                The neurons at which the
	 *                               DifferentiableActivationFunctionComponent will
	 *                               activate.
	 * @param activationFunctionType The activation function type.
	 * @param activationFunctionProperties The properties we wish to set on the activation function.
	 * @return A DifferentiableActivationFunctionComponent.
	 */
	T createDifferentiableActivationFunctionComponent(String name, Neurons neurons, ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties);

	/**
	 * Construct a DefaultDirectedComponentChain instance.
	 * 
	 * @param sequentialComponents A list of the sequential
	 *                             DefaultChainableDirectedComponents that this
	 *                             chain will contain
	 * @return The DefaultDirectedComponentChain instance
	 */
	T createDirectedComponentChain(List<T> sequentialComponents);

	/**
	 * Construct a DefaultDirectedComponentBipoleGraph instance.
	 * 
	 * @param name					  The component name.
	 * @param inputNeurons            The neurons on the LHS of the bipole graph.
	 * @param outputNeurons           The neurons on the RHS of the bipole graph.
	 * @param parallelComponents      The list of parallel components, connecting the
	 *                                input neurons to the output neurons.
	 * @param pathCombinationStrategy The strategy specifying how the outputs of the
	 *                                parallel chains are combined to produce the
	 *                                output.
	 * @return A DefaultDirectedComponentBipoleGraph instance.
	 */
	T createDirectedComponentBipoleGraph(String name, Neurons inputNeurons, Neurons outputNeurons, List<T> parallelComponents,
			PathCombinationStrategy pathCombinationStrategy);

}
