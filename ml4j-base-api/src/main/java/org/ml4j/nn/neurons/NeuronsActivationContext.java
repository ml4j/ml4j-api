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

package org.ml4j.nn.neurons;

import java.io.Serializable;

import org.ml4j.MatrixFactory;

/**
 * Defines the runtime context for NeuronsActivation instances.
 * 
 * @author Michael Lavelle
 */
public interface NeuronsActivationContext extends Serializable {

	ThreadLocal<MatrixFactory> getThreadLocalMatrixFactory();

	ThreadLocal<Boolean> getThreadLocalIsTrainingContext();
	
	void setMatrixFactory(MatrixFactory matrixFactory);
	
	void setTrainingContext(Boolean trainingContext);
	
	default MatrixFactory getMatrixFactory() {
		MatrixFactory matrixFactory = getThreadLocalMatrixFactory().get();
		if (matrixFactory == null) {
			throw new IllegalStateException("MatrixFactory has not been set on NeuronsActivationContext");
		}
		return matrixFactory;
	}
	
	default boolean isTrainingContext() {
		Boolean trainingContext = getThreadLocalIsTrainingContext().get();
		if (trainingContext == null) {
			throw new IllegalStateException("isTrainingContext has not been set on NeuronsActivationContext");
		}
		return trainingContext;
	}

}
