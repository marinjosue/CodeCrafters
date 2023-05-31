
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(hardwareStore);
            writer.write(json);
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
