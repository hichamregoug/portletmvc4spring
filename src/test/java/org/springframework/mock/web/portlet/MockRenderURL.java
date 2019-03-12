/*
 * Copyright 2002-2019 the original author or authors.
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

package org.springframework.mock.web.portlet;

import javax.portlet.MimeResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortalContext;
import javax.portlet.RenderURL;

/**
 * Mock implementation of the {@link RenderURL} interface.
 *
 * @author Neil Griffin
 * @since 5.1.0
 */
public class MockRenderURL extends MockPortletURL implements RenderURL {

	private MimeResponse.Copy copy;
	private String fragmentIdentifier;
	private MutableRenderParameters mutableRenderParameters;

	/**
	 * Create a new MockPortletURL for the given URL type.
	 *
	 * @param portalContext the PortalContext defining the supported
	 *                      PortletModes and WindowStates
	 */
	public MockRenderURL(PortalContext portalContext, MimeResponse.Copy copy) {
		super(portalContext, URL_TYPE_RENDER);
		this.copy = copy;
	}

	@Override
	public void setFragmentIdentifier(String fragmentIdentifier) {
		this.fragmentIdentifier = fragmentIdentifier;
	}

	@Override
	public String getFragmentIdentifier() {
		return fragmentIdentifier;
	}

	@Override
	public MutableRenderParameters getRenderParameters() {

		if (mutableRenderParameters == null) {
			mutableRenderParameters = new MockMutableRenderParameters();
		}

		return mutableRenderParameters;
	}
}
