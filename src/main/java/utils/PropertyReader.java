package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {



    private static Properties properties;


    //Чтение записи из файла Property
    public static void ReadProperty(String name) throws IOException {
        properties = new Properties();
        File prop = new File("data/properties/"+name+".property");
        FileReader obj = new FileReader(prop);
        properties.load(obj);

    }

    public String getObjectFromProperty(String Data, String name) throws IOException {
        ReadProperty(name);
        String data = properties.getProperty(Data);
        return data;
    }

}
