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

import org.openhwgroup.corev.ide.definition.api.Board;
import org.openhwgroup.corev.ide.definition.project.DefinedBoard;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public final class DeserializedBoard implements JsonDeserializer<Board> {

	@Override
	public Board deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return new DefinedBoard(json.getAsJsonObject().get("identifier").getAsString(), //$NON-NLS-1$
				json.getAsJsonObject().get("title").getAsString()); //$NON-NLS-1$
	}

}
