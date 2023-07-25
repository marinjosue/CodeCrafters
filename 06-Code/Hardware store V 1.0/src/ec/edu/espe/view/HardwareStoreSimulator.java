
package ec.edu.espe.view;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda, Mesias Mariscal CodeCrafters: DCCO-ESPE
 * 
 */
import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import static ec.edu.espe.view.Project.showMainMenu;
public class HardwareStoreSimulator {

    public static void main(String[] args) {
        
     
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        showMainMenu(hardwareStore);
    }
    }
    

