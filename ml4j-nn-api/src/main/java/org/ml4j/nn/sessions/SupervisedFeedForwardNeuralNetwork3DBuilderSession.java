/*
 * Copyright 2020 the original author or authors.
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
package org.ml4j.nn.sessions;

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.Axons3DConfigBuilder;
import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.definitions.Component3Dto3DGraphDefinition;
import org.ml4j.nn.definitions.Component3DtoNon3DGraphDefinition;
import org.ml4j.nn.layers.FeedForwardLayer;
import org.ml4j.nn.layers.builders.AveragePoolingFeedForwardLayerPropertiesBuilder;
import org.ml4j.nn.layers.builders.MaxPoolingFeedForwardLayerPropertiesBuilder;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * Session interface for the creation of SupervisedFeedForwardNeuralNetworks containing
 * misc. components, operating on 3D neurons (ie. image data)
 * 
 * @author Michael Lavelle
 *
 */
public interface SupervisedFeedForwardNeuralNetwork3DBuilderSession extends SupervisedFeedForwardNeuralNetworkBuilderSession {

	DirectedComponentFactory getDirectedComponentFactory(); 

	ConvolutionalFeedForwardLayerBuilderSession
			<SupervisedFeedForwardNeuralNetwork3DBuilderSession> withConvolutionalLayer(String layerName);
		
	
	FeedForward3DLayerBuilderSession
	<SupervisedFeedForwardNeuralNetwork3DBuilderSession, Axons3DConfigBuilder, AveragePoolingFeedForwardLayerPropertiesBuilder<SupervisedFeedForwardNeuralNetwork3DBuilderSession>> withAveragePoolingLayer(String layerName);
	

	FeedForward3DLayerBuilderSession
	<SupervisedFeedForwardNeuralNetwork3DBuilderSession, Axons3DConfigBuilder, MaxPoolingFeedForwardLayerPropertiesBuilder<SupervisedFeedForwardNeuralNetwork3DBuilderSession>> withMaxPoolingLayer(String layerName);
	
	SupervisedFeedForwardNeuralNetworkBuilderSession withComponentGraphDefinition(Component3DtoNon3DGraphDefinition definition);
	
	SupervisedFeedForwardNeuralNetwork3DBuilderSession withComponentGraphDefinition(Component3Dto3DGraphDefinition definition);
	
	SupervisedFeedForwardNeuralNetwork3DGraphBuilderSession with3DComponentGraph();
	
	<A extends Axons<Neurons3D, Neurons3D, ?>, L extends FeedForwardLayer<A, L>> SupervisedFeedForwardNeuralNetwork3DBuilderSession with3DLayer(L layer);

	
}
