
package ec.edu.espe.view;

import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;

public class Main {
    public static void main(String[] args) {
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        MainMenu.showMainMenu(hardwareStore);
    }
}
