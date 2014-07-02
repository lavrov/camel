/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.model.rest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.model.OptionalIdentifiedDefinition;

/**
 * Represents a collection of RESTs
 */
@XmlRootElement(name = "rests")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestsDefinition extends OptionalIdentifiedDefinition<RestsDefinition> implements RestContainer {
    @XmlElementRef
    private List<RestDefinition> rests = new ArrayList<RestDefinition>();
    @XmlTransient
    private ModelCamelContext camelContext;

    public RestsDefinition() {
    }

    @Override
    public String toString() {
        return "Rests: " + rests;
    }

    @Override
    public String getShortName() {
        return "rests";
    }

    public String getLabel() {
        return "Rest " + getId();
    }

    // Properties
    //-----------------------------------------------------------------------

    public List<RestDefinition> getRests() {
        return rests;
    }

    public void setRests(List<RestDefinition> rests) {
        this.rests = rests;
    }

    public ModelCamelContext getCamelContext() {
        return camelContext;
    }

    public void setCamelContext(ModelCamelContext camelContext) {
        this.camelContext = camelContext;
    }

    // Fluent API
    //-------------------------------------------------------------------------

    public RestDefinition rest() {
        RestDefinition rest = createRest();
        return rest(rest);

    }

    public RestDefinition rest(RestDefinition rest) {
        getRests().add(rest);
        return rest;
    }

    // Implementation methods
    //-------------------------------------------------------------------------
    protected RestDefinition createRest() {
        RestDefinition rest = new RestDefinition();
        return rest;
    }

}
