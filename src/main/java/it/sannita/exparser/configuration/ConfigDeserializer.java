package it.sannita.exparser.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import it.sannita.exparser.model.Symbol;
import it.sannita.exparser.model.SymbolBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConfigDeserializer extends StdDeserializer<SymbolsTable> {
    public ConfigDeserializer(){
        this(null);
    }

    protected ConfigDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SymbolsTable deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Map<String, Symbol> result = new HashMap<>();

        Iterator<JsonNode> elements = node.get("symbols").elements();
        while(elements.hasNext()){
            JsonNode element = elements.next();
            String id = element.get("id").asText();
            String symbol = element.get("symbol").asText();
            int priority = element.get("priority").asInt(0);
            String associativity = element.get("associativity").asText();
            String type = element.get("type").asText();

            Symbol symbolObject = SymbolBuilder.getSymbolBuilder(symbol, priority, associativity, type).build();
            result.put(symbol, symbolObject);
        }

        return new SymbolsTable(result);
    }

}