package org.example.Task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FileReadTest {
    private ObjectMapper mapper;
    private File inputFile;
    private JsonNode data;

    @BeforeEach
    public void setUp() throws IOException {
        mapper = new ObjectMapper();

        String jsonContent = "{ \"id\": 1, \"consumption\": 10, \"isDining\": true, \"passengers\": \"PEOPLE\", \"type\": \"GAS\" }";
        data = mapper.readTree(jsonContent);

        inputFile = mock(File.class);
        when(inputFile.exists()).thenReturn(true);
    }


    @Test
    public void testReadFileData()  {

        int id = data.get("id").asInt();
        int consumption = data.get("consumption").asInt();
        boolean isDining = data.get("isDining").asBoolean();
        String passengers = data.get("passengers").asText();
        String type = data.get("type").asText();

        assertEquals(1, id);
        assertEquals(10, consumption);
        assertTrue(isDining);
        assertEquals("PEOPLE", passengers);
        assertEquals("GAS", type);
    }


}
