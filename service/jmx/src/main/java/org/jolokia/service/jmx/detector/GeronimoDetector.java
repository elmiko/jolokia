package org.jolokia.service.jmx.detector;

/*
 * Copyright 2009-2013 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jolokia.core.service.detector.DefaultServerHandle;
import org.jolokia.core.service.detector.ServerHandle;
import org.jolokia.core.util.jmx.MBeanServerAccess;

/**
 * Detector for the Geronimo JEE Server
 * 
 * @author roland
 * @since 05.12.10
 */
public class GeronimoDetector extends AbstractServerDetector {

    /**
     * Create a server detector
     *
     * @param pOrder of the detector (within the list of detectors)
     */
    public GeronimoDetector(int pOrder) {
        super(pOrder);
    }

    /** {@inheritDoc}
     * @param pMBeanServerAccess*/
    public ServerHandle detect(MBeanServerAccess pMBeanServerAccess) {
        String version = getSingleStringAttribute(pMBeanServerAccess,"geronimo:j2eeType=J2EEServer,*","serverVersion");
        if (version != null) {
            return new DefaultServerHandle("Apache","geronimo",version);
        } else {
            return null;
        }
    }
}
