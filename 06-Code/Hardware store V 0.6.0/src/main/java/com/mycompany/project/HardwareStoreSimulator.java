
package com.mycompany.project;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda, Mesias Mariscal CodeCrafters: DCCO-ESPE
 * 
 */
import static com.mycompany.project.Project.showMainMenu;
import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
public class HardwareStoreSimulator {

    public static void main(String[] args) {
        
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        showMainMenu(hardwareStore);
        
        //JSONDataManager jsonDataManager = new JSONDataManager();
        //HardwareStore hardwareStore = jsonDataManager.loadData();
        //showMainMenu(hardwareStore);
    }
    }
    

