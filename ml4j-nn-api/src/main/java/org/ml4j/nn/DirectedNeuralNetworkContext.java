package org.ml4j.nn;

import org.ml4j.nn.layers.DirectedLayerContext;

/**
 * Encapsulates the runtime context used with a DirectedNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface DirectedNeuralNetworkContext extends NeuralNetworkContext {

  /**
   * Create the DirectedLayerContext for the DirectedLayer specified
   * by the layerIndex.
   * 
   * @param layerIndex The index of the DirectedLayer in this
   *        DirectedNeuralNetwork to create the context for.
   * @return The DirectedLayerContext for the DirectedLayer specified
   *        by the layerIndex.
   */
  DirectedLayerContext getLayerContext(int layerIndex);
  
  /**
   * @return The index of the starting layer for a propagation through a DirectedNeuralNetwork.
   */
  int getStartLayerIndex();

  /**
   * @return The index of the end layer for a propagation through a DirectedNeuralNetwork, or null
   *         if the propagation is required to reach the final Layer.
   */
  Integer getEndLayerIndex();
  
  /**
   * @return The learning rate used during training.
   */
  double getTrainingLearningRate();
  
  /**
   * @return The number of iterations used during training.
   */
  int getTrainingIterations();
  
  /**
   * @param trainingLearningRate The learning rate used during training.
   */
  void setTrainingLearningRate(double trainingLearningRate);
  
  /**
   * @param trainingIterations The number of iterations used during training.
   */
  void setTrainingIterations(int trainingIterations);
 
}
