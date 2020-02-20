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
package org.ml4j.nn.axons;

import org.ml4j.nn.neurons.Neurons;

/**
 * 
 * @author Michael Lavelle
 *
 */
public class AxonsConfigBuilder extends AxonsConfigBuilderBase<AxonsConfig<Neurons, Neurons>, AxonsConfigBuilder> {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected AxonsConfig<Neurons, Neurons> createDefaultConfig(Neurons leftNeurons, Neurons rightNeurons) {
		return new AxonsConfig<>(leftNeurons, rightNeurons);
	}

	@Override
	protected AxonsConfigBuilder getInstance() {
		return this;
	}

	@Override
	public AxonsConfig<Neurons, Neurons> build() {
		if (leftNeurons == null) {
			throw new IllegalStateException("Input neurons have not been specified");
		} else {
			return createDefaultConfig(leftNeurons, rightNeurons);
		}
		
	}

}
