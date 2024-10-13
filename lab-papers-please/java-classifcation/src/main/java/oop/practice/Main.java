package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    var path = "./lab-papers-please/java-classifcation/src/main/resources/input.json";

    Classification classification = new Classification();
    Universe[] universes = classification.test();
    Writefile witefile = new Writefile(path);
    witefile.printData();
    witefile.saveDataToFile(universes);
  }
}

record Universe(
    String name,
    List<JsonNode> individuals) {
}
