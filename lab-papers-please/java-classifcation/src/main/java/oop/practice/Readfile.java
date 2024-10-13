package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Readfile {

    private String path;

    Readfile(String path) {
        this.path = path;
    }

    public JsonNode getdata() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File(path);
        JsonNode data = mapper.readTree(inputFile).get("data");

        ArrayNode modifiedData = mapper.createArrayNode();

        for (JsonNode item : data) {

            ObjectNode filledObject = mapper.createObjectNode()
                    .put("isHumanoid", item.has("isHumanoid") ? item.get("isHumanoid").asBoolean() : null)
                    .put("planet", item.has("planet") ? item.get("planet").asText() : null)
                    .put("age", item.has("age") ? item.get("age").asInt() : null)
                    .set("traits", item.has("traits") ? item.get("traits") : null);

            if (item.has("id")) {
                filledObject.put("id", item.get("id").asInt());
            }

            modifiedData.add(filledObject);
        }

        return modifiedData;
    }
}
