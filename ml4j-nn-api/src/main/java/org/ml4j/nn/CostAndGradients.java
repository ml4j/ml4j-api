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

package org.ml4j.nn;

import java.util.List;

import org.ml4j.nn.axons.AxonsGradient;

/**
 * Encapsulates the total and average costs and gradients associated with a
 * forward propagation through a FeedForwardNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface CostAndGradients {

	/**
	 * @return The total cost.
	 */
	float getTotalCost();

	/**
	 * @return The average cost.
	 */
	float getAverageCost();

	/**
	 * @return The total gradients.
	 */
	List<AxonsGradient> getTotalTrainableAxonsGradients();

	/**
	 * @return The average gradients.
	 */
	List<AxonsGradient> getAverageTrainableAxonsGradients();

	void close();
}
