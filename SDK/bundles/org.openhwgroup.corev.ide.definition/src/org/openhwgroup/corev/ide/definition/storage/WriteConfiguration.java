/*******************************************************************************
 * Copyright (c) 2021 ArSysOp and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Nikifor Fedorov (ArSysOp) - initial API and implementation
 *******************************************************************************/
package org.openhwgroup.corev.ide.definition.storage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.function.Function;

import org.openhwgroup.corev.ide.definition.api.Configuration;

import com.google.gson.Gson;

public class WriteConfiguration implements Function<Configuration, InputStream> {

	@Override
	public InputStream apply(Configuration configuration) {
		return new ByteArrayInputStream(new Gson().toJson(configuration).getBytes());
	}

}
