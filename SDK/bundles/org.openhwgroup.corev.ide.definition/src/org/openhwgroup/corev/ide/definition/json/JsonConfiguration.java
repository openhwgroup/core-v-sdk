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
package org.openhwgroup.corev.ide.definition.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.Function;

import org.openhwgroup.corev.ide.definition.api.Board;
import org.openhwgroup.corev.ide.definition.api.Configuration;
import org.openhwgroup.corev.ide.definition.api.Toolchain;
import org.openhwgroup.corev.ide.definition.project.EmptyConfiguration;
import org.openhwgroup.corev.ide.definition.project.SimpleConfiguration;

import com.google.gson.GsonBuilder;

public final class JsonConfiguration implements Function<InputStream, Configuration> {

	@Override
	public Configuration apply(InputStream t) {
		try (Reader reader = new InputStreamReader(t)) {
			return new GsonBuilder() //
					.registerTypeAdapter(Board.class, new DeserializedBoard())
					.registerTypeAdapter(Toolchain.class, new DeserializedToolchain())
					.create()
					.fromJson(reader, SimpleConfiguration.class);
		} catch (IOException e) {
			return new EmptyConfiguration();
		}
	}

}
