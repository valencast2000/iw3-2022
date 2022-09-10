package org.magm.backend.integration.cli2.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ItemCli2JsonSerializer extends StdSerializer<ItemCli2>{

	private static final long serialVersionUID = 9188921434629638095L;

	protected ItemCli2JsonSerializer(Class<?> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(ItemCli2 value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());	
		gen.writeNumberField("cantidad", value.getCantidad());
		gen.writeNumberField("precio", value.getPrecio());
		
		gen.writeObjectFieldStart("producto");
		gen.writeNumberField("id", value.getProduct().getId());
		gen.writeStringField("producto", value.getProduct().getProduct());
		gen.writeEndObject();
		
		gen.writeEndObject();
	}

}
