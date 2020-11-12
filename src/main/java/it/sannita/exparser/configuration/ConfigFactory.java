package it.sannita.exparser.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class ConfigFactory {
    private ConfigFactory(){}

    public static SymbolsTable getConfigFromResource(String resource) {
        InputStream stream = ClassLoader.getSystemResourceAsStream(resource);

        return getConfigFromStream(stream);
    }

    public static SymbolsTable getConfigFromFile(String file) {
        try {
            return getConfigFromStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SymbolsTable getConfigFromStream(InputStream inputStream) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(SymbolsTable.class, new ConfigDeserializer());
        mapper.registerModule(module);

        try {
            return mapper.readValue(inputStream, SymbolsTable.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
