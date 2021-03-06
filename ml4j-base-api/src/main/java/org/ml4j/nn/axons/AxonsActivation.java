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

package org.ml4j.nn.axons;

import java.util.function.Supplier;

import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Encapsulates the artifacts produced when pushing NeuronsActivations through
 * an Axons instance.
 * 
 * @author Michael Lavelle
 */
public interface AxonsActivation {

	/**
	 * @return The axons instance from which this activation originated.
	 */
	Axons<?, ?, ?> getAxons();

	/**
	 * @return The dropout mask (if any) used by the axons to create this
	 *         activation, or null if no dropout mask.
	 */
	AxonsDropoutMask getDropoutMask();
	
	/**
	 * @param axonsDropoutMask Set the dropout mask (if any) used by the axons to create this activation.
	 */
	void setDropoutMask(AxonsDropoutMask axonsDropoutMask);

	/**
	 * @return The output from this axons activation, after any output dropout has
	 *         been applied.
	 */
	NeuronsActivation getPostDropoutOutput();

	/**
	 * @return A supplier of the input of the axons activation, after any input
	 *         dropout has been applied.
	 */
	Supplier<NeuronsActivation> getPostDropoutInput();

}
