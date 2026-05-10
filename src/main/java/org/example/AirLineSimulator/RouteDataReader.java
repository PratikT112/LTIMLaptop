package org.example.AirLineSimulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RouteDataReader {

    public static List<String> routeDataReadJava8() throws IOException {
//        Path path = Path.of("org/example/AirLineSimulator/PaxRouteData");
        Path path = Path.of("src/main/resources/PaxRouteData");
        return Files.readAllLines(path);
    }

    public static List<String> routeDataReadBufferedReader() throws IOException{
        List<String> lines  = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/PaxRouteData"))){
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        }

        return  lines;
    }



}
