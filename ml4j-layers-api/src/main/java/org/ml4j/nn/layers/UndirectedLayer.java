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

package org.ml4j.nn.layers;

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.synapses.UndirectedSynapses;

/**
 * Represents an Undirected Layer of a NeuralNetwork - a Layer through which information propagates
 * from input neurons to output neurons in both directions.
 * 
 * @author Michael Lavelle
 * 
 * @param <A> The type of Axons within this UndirectedLayer
 * @param <L> The type of UndirectedLayer
 */
public interface UndirectedLayer<A extends Axons<?,?,?>, L extends UndirectedLayer<A, L>>
    extends Layer<A, UndirectedSynapses<?, ?>, L> {
  
	 /**
	   * Duplicates this Layer.
	   * 
	   * @return A deep clone of this Layer
	   */
	  L dup();
}
