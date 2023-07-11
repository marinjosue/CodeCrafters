
package com.mycompany.project;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda, Mesias Mariscal CodeCrafters: DCCO-ESPE
 * 
 */
import static com.mycompany.project.Project.showMainMenu;
import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.show.HardwareStoreDSA;
public class HardwareStoreSimulator {

    public static void main(String[] args) {
        HardwareStoreDSA main = new HardwareStoreDSA();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        showMainMenu(hardwareStore);
        
        //JSONDataManager jsonDataManager = new JSONDataManager();
        //HardwareStore hardwareStore = jsonDataManager.loadData();
        //showMainMenu(hardwareStore);
    }
    }
    

