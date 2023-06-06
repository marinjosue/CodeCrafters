package ec.edu.espe.hardwarestore.view;
import ec.edu.espe.hardwarestore.model.Tooltype;
import ec.edu.espe.hardwarestore.model.JsonFileManager;
import ec.edu.espe.hardwarestore.model.Menu;
import java.util.List;

public class HadwareStore {
    public static void main(String[] args) {
        JsonFileManager jsonFileManager = new JsonFileManager("products.json");
        List<Tooltype> type = jsonFileManager.readCoops();

        Menu menu = new Menu(type);
        menu.show();

        jsonFileManager.writeCoops(type);
    }
}
