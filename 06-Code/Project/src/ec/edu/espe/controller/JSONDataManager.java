
package ec.edu.espe.controller;

/**
 *
 * @author USER
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.model.HardwareStore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONDataManager {
    private final String FILE_PATH = "data.json";

public void saveData(HardwareStore hardwareStore) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    HardwareStore existingHardwareStore = loadData();
    if (existingHardwareStore != null) {
        // Agrega los nuevos datos al objeto HardwareStore existente
        existingHardwareStore.getProductList().addAll(hardwareStore.getProductList());
    } else {
        existingHardwareStore = hardwareStore;
    }
    String json = gson.toJson(existingHardwareStore);

    try (FileWriter writer = new FileWriter(FILE_PATH)) {
        writer.write(json);
        System.out.println("Cambios guardados correctamente en el archivo JSON.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public HardwareStore loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Gson gson = new Gson();
            return gson.fromJson(reader, HardwareStore.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
