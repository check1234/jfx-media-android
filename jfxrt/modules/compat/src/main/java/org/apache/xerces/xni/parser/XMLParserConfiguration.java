/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 *
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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

package org.apache.xerces.xni.parser;

import java.io.IOException;
import java.util.Locale;

import org.apache.xerces.xni.*;

/**
 * Represents a parser configuration. The parser configuration maintains
 * a table of recognized features and properties, assembles components
 * for the parsing pipeline, and is responsible for initiating parsing
 * of an XML document.
 * <p>
 * By separating the configuration of a parser from the specific parser
 * instance, applications can create new configurations and re-use the
 * existing parser components and external API generators (e.g. the
 * DOMParser and SAXParser).
 * <p>
 * The internals of any specific parser configuration instance are hidden.
 * Therefore, each configuration may implement the parsing mechanism any
 * way necessary. However, the parser configuration should follow these
 * guidelines:
 * <ul>
 *  <li>
 *   Call the <code>reset</code> method on each component before parsing.
 *   This is only required if the configuration is re-using existing
 *   components that conform to the <code>XMLComponent</code> interface.
 *   If the configuration uses all custom parts, then it is free to 
 *   implement everything as it sees fit as long as it follows the
 *   other guidelines.
 *  </li>
 *  <li>
 *   Call the <code>setFeature</code> and <code>setProperty</code> method
 *   on each component during parsing to propagate features and properties
 *   that have changed. This is only required if the configuration is
 *   re-using existing components that conform to the <code>XMLComponent</code>
 *   interface. If the configuration uses all custom parts, then it is free
 *   to implement everything as it sees fit as long as it follows the other
 *   guidelines.
 *  </li>
 *  <li>
 *   Pass the same unique String references for all symbols that are
 *   propagated to the registered handlers. Symbols include, but may not
 *   be limited to, the names of elements and attributes (including their
 *   uri, prefix, and localpart). This is suggested but not an absolute 
 *   must. However, the standard parser components may require access to 
 *   the same symbol table for creation of unique symbol references to be
 *   propagated in the XNI pipeline.
 *  </li>
 * </ul>
 *
 * @author Arnaud  Le Hors, IBM
 * @author Andy Clark, IBM
 *
 * @version $Id: XMLParserConfiguration.java,v 1.4 2010-11-02 21:02:33 joehw Exp $
 */
public interface XMLParserConfiguration
    extends XMLComponentManager {

    //
    // XMLParserConfiguration methods
    //

    // parsing

    /**
     * Parse an XML document.
     * <p>
     * The parser can use this method to instruct this configuration
     * to begin parsing an XML document from any valid input source
     * (a character stream, a byte stream, or a URI).
     * <p>
     * Parsers may not invoke this method while a parse is in progress.
     * Once a parse is complete, the parser may then parse another XML
     * document.
     * <p>
     * This method is synchronous: it will not return until parsing
     * has ended.  If a client application wants to terminate 
     * parsing early, it should throw an exception.
     * <p>
     * When this method returns, all characters streams and byte streams
     * opened by the parser are closed.
     * 
     * @param source The input source for the top-level of the
     *               XML document.
     *
     * @exception XNIException Any XNI exception, possibly wrapping 
     *                         another exception.
     * @exception IOException  An IO exception from the parser, possibly
     *                         from a byte stream or character stream
     *                         supplied by the parser.
     */
    public void parse(XMLInputSource inputSource) 
        throws XNIException, IOException;

    // generic configuration

    /**
     * Allows a parser to add parser specific features to be recognized
     * and managed by the parser configuration.
     *
     * @param featureIds An array of the additional feature identifiers 
     *                   to be recognized.
     */
    public void addRecognizedFeatures(String[] featureIds);

    /**
     * Sets the state of a feature. This method is called by the parser
     * and gets propagated to components in this parser configuration.
     * 
     * @param featureId The feature identifier.
     * @param state     The state of the feature.
     *
     * @throws XMLConfigurationException Thrown if there is a configuration
     *                                   error.
     */
    public void setFeature(String featureId, boolean state)
        throws XMLConfigurationException;

    /**
     * Returns the state of a feature.
     * 
     * @param featureId The feature identifier.
     * 
     * @throws XMLConfigurationException Thrown if there is a configuration
     *                                   error.
     */
    public boolean getFeature(String featureId)
        throws XMLConfigurationException;

    /**
     * Allows a parser to add parser specific properties to be recognized
     * and managed by the parser configuration.
     *
     * @param propertyIds An array of the additional property identifiers 
     *                    to be recognized.
     */
    public void addRecognizedProperties(String[] propertyIds);

    /**
     * Sets the value of a property. This method is called by the parser
     * and gets propagated to components in this parser configuration.
     * 
     * @param propertyId The property identifier.
     * @param value      The value of the property.
     *
     * @throws XMLConfigurationException Thrown if there is a configuration
     *                                   error.
     */
    public void setProperty(String propertyId, Object value)
        throws XMLConfigurationException;

    /**
     * Returns the value of a property.
     * 
     * @param propertyId The property identifier.
     * 
     * @throws XMLConfigurationException Thrown if there is a configuration
     *                                   error.
     */
    public Object getProperty(String propertyId)
        throws XMLConfigurationException;

    // handlers

    /**
     * Sets the error handler.
     *
     * @param errorHandler The error resolver.
     */
    public void setErrorHandler(XMLErrorHandler errorHandler);

    /** Returns the registered error handler. */
    public XMLErrorHandler getErrorHandler();

    /**
     * Sets the document handler to receive information about the document.
     * 
     * @param documentHandler The document handler.
     */
    public void setDocumentHandler(XMLDocumentHandler documentHandler);

    /** Returns the registered document handler. */
    public XMLDocumentHandler getDocumentHandler();

    /**
     * Sets the DTD handler.
     * 
     * @param dtdHandler The DTD handler.
     */
    public void setDTDHandler(XMLDTDHandler dtdHandler);

    /** Returns the registered DTD handler. */
    public XMLDTDHandler getDTDHandler();

    /**
     * Sets the DTD content model handler.
     * 
     * @param dtdContentModelHandler The DTD content model handler.
     */
    public void setDTDContentModelHandler(XMLDTDContentModelHandler dtdContentModelHandler);

    /** Returns the registered DTD content model handler. */
    public XMLDTDContentModelHandler getDTDContentModelHandler();

    // other settings

    /**
     * Sets the entity resolver.
     *
     * @param entityResolver The new entity resolver.
     */
    public void setEntityResolver(XMLEntityResolver entityResolver);

    /** Returns the registered entity resolver. */
    public XMLEntityResolver getEntityResolver();

    /**
     * Set the locale to use for messages.
     *
     * @param locale The locale object to use for localization of messages.
     *
     * @exception XNIException Thrown if the parser does not support the
     *                         specified locale.
     */
    public void setLocale(Locale locale) throws XNIException;

    /** Returns the locale. */
    public Locale getLocale();

} // interface XMLParserConfiguration