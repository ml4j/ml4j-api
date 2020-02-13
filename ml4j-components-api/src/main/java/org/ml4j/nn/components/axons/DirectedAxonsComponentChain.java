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
package org.ml4j.nn.components.axons;

import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.components.generic.DirectedComponentChain;
import org.ml4j.nn.components.generic.DirectedComponentChainActivation;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedAxonsComponentChain<L extends Neurons, R extends Neurons> extends
		DirectedComponentChain<NeuronsActivation, DirectedAxonsComponent<L, R, ?>, DirectedAxonsComponentActivation, DirectedComponentChainActivation<NeuronsActivation, DirectedAxonsComponentActivation>, DirectedComponentFactory> {

	@Override
	DirectedAxonsComponentChain<L, R> dup(DirectedComponentFactory directedComponentFactory);
}
