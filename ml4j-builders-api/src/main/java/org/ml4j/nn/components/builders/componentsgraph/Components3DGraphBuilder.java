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
package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.builders.axons.ActivationFunctionPermitted;
import org.ml4j.nn.components.builders.axons.Axons3DBuilder;
import org.ml4j.nn.components.builders.axons.Axons3DPermitted;
import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.common.ParallelPathsPermitted;
import org.ml4j.nn.components.builders.skipconnection.Components3DGraphSkipConnectionBuilder;
import org.ml4j.nn.components.builders.skipconnection.SkipConnection3DPermitted;
import org.ml4j.nn.components.builders.synapses.Synapses3DPermitted;
import org.ml4j.nn.definitions.Component3Dto3DGraphDefinition;
import org.ml4j.nn.definitions.Component3DtoNon3DGraphDefinition;
import org.ml4j.nn.neurons.Neurons3D;

public interface Components3DGraphBuilder<C extends Axons3DBuilder<T>, D extends AxonsBuilder<T>, T extends NeuralComponent>
		extends Axons3DPermitted<C, D, T>, Synapses3DPermitted<C, D, T>, ActivationFunctionPermitted<C>,
		ParallelPathsPermitted<Components3DSubGraphBuilder<C, D, T>>,
		SkipConnection3DPermitted<Components3DGraphSkipConnectionBuilder<C, D, T>, T>, Axons3DBuilder<T> {

	C get3DBuilder();

	D getBuilder();

	C with3DComponent(T component, Neurons3D endNeurons);

	D withNon3DComponent(T component);

	C withComponents(Components3DGraphBuilder<?, ?, T> builder, Neurons3D endNeurons);

	D withComponents(ComponentsGraphBuilder<?, T> builder);

	C withComponentDefinition(Component3Dto3DGraphDefinition componentDefinition);

	D withComponentDefinition(Component3DtoNon3DGraphDefinition componentDefinition);

}
