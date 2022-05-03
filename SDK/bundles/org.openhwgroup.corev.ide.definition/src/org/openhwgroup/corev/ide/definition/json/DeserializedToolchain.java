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

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import org.openhwgroup.corev.ide.definition.api.Toolchain;
import org.openhwgroup.corev.ide.definition.project.DefinedToolchain;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public final class DeserializedToolchain implements JsonDeserializer<Toolchain> {

	@Override
	public Toolchain deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		String identifier = json.getAsJsonObject().get("identifier").getAsString(); //$NON-NLS-1$
		String title = json.getAsJsonObject().get("title").getAsString(); //$NON-NLS-1$
		String path = json.getAsJsonObject().get("path").getAsString(); //$NON-NLS-1$
		List<String> boards = new LinkedList<>();
		json.getAsJsonObject().get("boards").getAsJsonArray().forEach(element -> { //$NON-NLS-1$
			boards.add(element.getAsString());
		}); // $NON-NLS-1$
		return new DefinedToolchain(identifier, title, path, boards);
	}

}
