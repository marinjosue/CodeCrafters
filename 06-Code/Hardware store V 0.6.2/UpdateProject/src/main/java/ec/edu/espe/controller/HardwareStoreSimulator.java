
package ec.edu.espe.controller;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda, Mesias Mariscal CodeCrafters: DCCO-ESPE
 * 
 */
import static ec.edu.espe.controller.Project.showMainMenu;
import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.view.HardwareStoreDSA;
public class HardwareStoreSimulator {

    public static void main(String[] args) {
        HardwareStoreDSA show = new HardwareStoreDSA();
        show.setVisible(true);
        show.setLocationRelativeTo(null);
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        showMainMenu(hardwareStore);
        
        //JSONDataManager jsonDataManager = new JSONDataManager();
        //HardwareStore hardwareStore = jsonDataManager.loadData();
        //showMainMenu(hardwareStore);
    }
    }
    

