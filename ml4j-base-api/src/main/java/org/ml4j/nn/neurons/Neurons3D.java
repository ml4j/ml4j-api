/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.neurons;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Neurons that are arranged in a 3D shape.
 * 
 * @author Michael Lavelle
 */
public class Neurons3D extends Neurons {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	private int width;
	private int height;
	private int depth;

	/**
	 * @param width       The width.
	 * @param height      The height.
	 * @param depth       the depth.
	 * @param hasBiasUnit Whether these Neurons also have a bias unit.
	 */
	public Neurons3D(int width, int height, int depth, boolean hasBiasUnit) {
		super(width * height * depth, hasBiasUnit);
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	/**
	 * @return The width of the volume of Neurons.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height of the volume of Neurons.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return The depth of the volume of Neurons.
	 */
	public int getDepth() {
		return depth;
	}

	@Override
	public String toString() {
		   return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
