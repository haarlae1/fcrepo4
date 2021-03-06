/**
 * Copyright 2015 DuraSpace, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fcrepo.transform;

import com.google.common.base.Function;
import org.fcrepo.kernel.utils.iterators.RdfStream;

import java.io.InputStream;

/**
 * Generic interface for transforming a resource's properties
 * to an implementation-defined type
 *
 * @author cbeer
 */
public interface Transformation<T> extends Function<RdfStream, T> {

    /**
     * Execute a transform on an rdf stream
     * @param stream
     * @return transformed output
     */
    @Override
    T apply(final RdfStream stream);

    /**
     * Get the Query the transformation is using
     * @return query used by the transformation as an input stream
     */
    InputStream getQuery();

    /**
     * @return a new Transform of this type, for use as a factory
     */
    Transformation<T> newTransform(InputStream query);

}
