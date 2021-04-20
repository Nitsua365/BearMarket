package csi3471.bearMarket.ProductFiles;

import com.sun.tools.javac.Main;
import csi3471.bearMarket.MainScreenFiles.MainScreen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ReadProductFile {

    public static void readFile(String file, Vector<Product> productVector, Map<Integer, Product> productMap){


        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            bufferedReader.readLine(); //waste first line of csv
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                Product p = new Product(line.split("\t"));

                productMap.put(p.getID(), p);
                productVector.add(p);
            }

            bufferedReader.close(); //close file
        }catch(IOException e){
            System.out.println("ERROR while opening or reading'" + file + "'");
            e.printStackTrace();
        }
    }
}