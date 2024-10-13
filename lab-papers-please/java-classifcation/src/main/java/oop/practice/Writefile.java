package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Writefile {

    private JsonNode data;

    public Writefile(String path) throws IOException {
        Readfile readfile = new Readfile(path);
        this.data = readfile.getdata();

    }

    public void saveDataToFile(Universe[] universes) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Universe starWars = universes[0];
        Universe hitchhikers = universes[1];
        Universe marvel = universes[2];
        Universe rings = universes[3];

        mapper.writeValue(new File("./lab-papers-please/output/starwars.json"), starWars);
        mapper.writeValue(new File("./lab-papers-please/output/hitchhiker.json"), hitchhikers);
        mapper.writeValue(new File("./lab-papers-please/output/rings.json"), marvel);
        mapper.writeValue(new File("./lab-papers-please/output/marvel.json"), rings);

        System.out.println("Data has been written to files.");
    }

    public void printData() {
        System.out.println(data.toString());
    }

}
