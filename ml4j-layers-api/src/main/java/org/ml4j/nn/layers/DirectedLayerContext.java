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

import org.ml4j.nn.synapses.DirectedSynapsesContext;

/**
 * Encapsulates the runtime context used with a DirectedLayer.
 * 
 * @author Michael Lavelle
 */
public interface DirectedLayerContext extends LayerContext {

  /**
   * @param synapsesIndex The index of the synapses within this DirectedLayer.
   * @return The context we use to propagate data through the directed 
   *         synapses of this Layer.
   */
  DirectedSynapsesContext createSynapsesContext(int synapsesIndex);
  
  /**
   * @param inputDropoutKeepProbability The input dropout keep probability for 
   *        this DirectedLayer.
   */
  void setInputDropoutKeepProbability(
      double inputDropoutKeepProbability);
  
  /**
   * @return The input dropout keep probability for this DirectedLayer.
   */
  double getLayerInputDropoutKeepProbability();
  
  /**
   * @param regularisationLamdba The regularisation lambda to use with the primary axons of
   *        a DirectedLayer.
   */
  void setPrimaryAxonsRegularisationLambda(double regularisationLamdba);
  
  /**
   * @return The regularisation lambda to use with the primary axons of
   *        a DirectedLayer.
   */
  double getPrimaryAxonsRegularisationLambda();
}
