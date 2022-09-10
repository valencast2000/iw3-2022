package org.magm.backend.integration.cli2.model;

import java.io.IOException;

import org.magm.backend.util.JsonUtiles;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class FacturaCli2JsonSerializer extends StdSerializer<FacturaCli2> {
	
	private static final long serialVersionUID = -966197690047715377L;

	protected FacturaCli2JsonSerializer(Class<?> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(FacturaCli2 value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeNumberField("numero", value.getNumero());
		gen.writeObjectField("fechaEmision", value.getFechaEmision());
		gen.writeObjectField("fechaVencimiento", value.getFechaVencimiento());
		gen.writeBooleanField("anulada", value.isAnulada());
		
		String itemsStr = JsonUtiles
				.getObjectMapper(ItemCli2.class, new ItemCli2JsonSerializer(ItemCli2.class, false), null)
				.writeValueAsString(value.getItems());
		
		gen.writeFieldName("items");
		gen.writeRawValue(itemsStr);
		
		gen.writeEndObject();
	}

}
