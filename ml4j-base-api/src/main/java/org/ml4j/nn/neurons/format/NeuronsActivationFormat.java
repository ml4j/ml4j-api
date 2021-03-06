/*
 * Copyright 2020 the original author or authors.
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
package org.ml4j.nn.neurons.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.neurons.NeuronsActivationFeatureOrientation;
import org.ml4j.nn.neurons.format.features.Dimension;
import org.ml4j.nn.neurons.format.features.FeaturesFormat;
import org.ml4j.nn.neurons.format.features.FlatFeaturesFormat;

/**
 * Format specification for a NeuronsActivation, encapsulating the FeaturesFormat, and
 * the NeuronsActivationFeaturesOrientation for matrix representation of multiple examples.
 * 
 * @author Michael Lavelle
 *
 * @param <F> The type of FeaturesFormat representing the data features.
 */
public class NeuronsActivationFormat<F extends FeaturesFormat> {

	public static final NeuronsActivationFormat<?> ROWS_SPAN_FEATURE_SET = new NeuronsActivationFormat<>(NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET, 
			new FlatFeaturesFormat(), Arrays.asList(Dimension.EXAMPLE));
	
	public static final NeuronsActivationFormat<?> COLUMNS_SPAN_FEATURE_SET = new NeuronsActivationFormat<>(NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET, 
			new FlatFeaturesFormat(), Arrays.asList(Dimension.EXAMPLE));
	
	protected NeuronsActivationFeatureOrientation featureOrientation;
	protected F featuresFormat;
	protected List<Dimension> exampleDimensions;
	
	public NeuronsActivationFormat(NeuronsActivationFeatureOrientation featureOrientation,
			F featuresFormat, List<Dimension> exampleDimensions) {
		this.featureOrientation = featureOrientation;
		this.featuresFormat = featuresFormat;
		this.exampleDimensions = exampleDimensions;
	}
	
	public NeuronsActivationFeatureOrientation getFeatureOrientation() {
		return featureOrientation;
	}

	public List<Dimension> getExampleDimensions() {
		return exampleDimensions;
	}
	
	public List<Dimension> getDimensions() {
		List<Dimension> allDimensions = new ArrayList<>();
		allDimensions.addAll(getRowDimensions());
		allDimensions.addAll(getColumnDimensions());
		return allDimensions;
		
	}

	public List<Dimension> getRowDimensions() {
		if (featureOrientation == NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET) {
			return featuresFormat.getDimensions();
		} else {
			return exampleDimensions;
		}
	}
	
	public List<Dimension> getColumnDimensions() {
		if (featureOrientation == NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET) {
			return featuresFormat.getDimensions();
		} else {
			return exampleDimensions;
		}
	}
	
	public String getRowDimensionsName() {
		if (featureOrientation == NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET) {
			return featuresFormat.getDimensions().stream().map(Dimension::getName).collect(Collectors.toList()).toString();
		} else {
			return exampleDimensions.stream().map(Dimension::getName).collect(Collectors.toList()).toString();
		}
	}
	
	public String getColumnDimensionsName() {
		if (featureOrientation == NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET) {
			return featuresFormat.getDimensions().stream().map(Dimension::getName).collect(Collectors.toList()).toString();
		} else {
			return exampleDimensions.stream().map(Dimension::getName).collect(Collectors.toList()).toString();
		}
	}

	public F getFeaturesFormat() {
		return featuresFormat;
	}

	@Override
	public String toString() {
		if (featureOrientation == NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET) {
			List<Dimension> dimensions = new ArrayList<>();
			dimensions.addAll(featuresFormat.getDimensions());
			dimensions.addAll(getExampleDimensions());
			return dimensions.stream().map(Dimension::getName).collect(Collectors.toList()).toString();
		} else {
			List<Dimension> dimensions = new ArrayList<>();
			dimensions.addAll(getExampleDimensions());
			dimensions.addAll(featuresFormat.getDimensions());
			return dimensions.stream().map(Dimension::getName).collect(Collectors.toList()).toString();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	public static Optional<NeuronsActivationFormat<?>> intersectOptionals(
			List<Optional<NeuronsActivationFormat<?>>> values) {
		return values.stream().reduce(Optional.empty(), NeuronsActivationFormat::intersectOptionals);
	}

	public static Optional<NeuronsActivationFormat<?>> intersectOptionals(
			Optional<NeuronsActivationFormat<?>> first, Optional<NeuronsActivationFormat<?>> second) {
		return first.isPresent() && second.isPresent() ? (first.get().equals(second.get()) ? first : Optional.empty())
				: first.isPresent() ? first : (second);
	}

	public static List<NeuronsActivationFormat<?>> intersectLists(
			List<NeuronsActivationFormat<?>> first, List<NeuronsActivationFormat<?>> second) {
		return first.stream().filter(second::contains).collect(Collectors.toList());
	}

	public static List<NeuronsActivationFormat<?>> intersectLists(
			List<List<NeuronsActivationFormat<?>>> values) {
		return values.stream().reduce(Arrays.asList(), NeuronsActivationFormat::intersectLists);
	}
}
