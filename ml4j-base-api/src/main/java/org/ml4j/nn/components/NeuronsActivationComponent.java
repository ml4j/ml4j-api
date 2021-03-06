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
package org.ml4j.nn.components;

import java.util.Optional;

import org.ml4j.nn.neurons.format.NeuronsActivationFormat;

/**
 * A component with NeuronsActivation input. Provides methods to indicate the
 * type of NeuronsActivation supported/preferred.
 * 
 * @author Michael Lavelle
 *
 */
public interface NeuronsActivationComponent {

	/**
	 * 
	 * @param format The format to check
	 * @return Whether the specified neurons activation format is supported by this component
	 */
	boolean isSupported(NeuronsActivationFormat<?> format);

	/**
	 * @return Whether this component has been optionally optimised for (or prefers)
	 *         a particular NeuronsActivationFeatureOrientation. If Optional.empty()
	 *         is returned, clients can assume that there is no significant
	 *         performance difference between the different representations of input
	 *         data
	 */
	Optional<NeuronsActivationFormat<?>> optimisedFor();
}
