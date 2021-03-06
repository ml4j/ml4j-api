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

package org.ml4j.nn.synapses;

import java.io.Serializable;

import org.ml4j.nn.components.NeuralNetworkComponent;

/**
 * Synapses are containers for Axons ( or graphs of Axons) with optional surrounding 
 * transformations such as ActivationFunctions.
 * 
 * @author Michael Lavelle
 *
 * @param <S> The type of Synapses
 */
public interface Synapses<S extends Synapses<S>> extends NeuralNetworkComponent, Serializable {

}
