
package ec.edu.espe.view;

import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import static ec.edu.espe.view.Project.showMainMenu;

public class HardwareStoreSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        showMainMenu(hardwareStore);
    }
    }
    
