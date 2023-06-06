package ec.edu.espe.view;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda, Mesias Mariscal CodeCrafters: DCCO-ESPE
 */
import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import java.io.IOException;
import java.util.Scanner;
import ec.edu.espe.view.Owner;
import static ec.edu.espe.view.Owner.OWNER_PASSWORD;
import ec.edu.espe.view.Costomer;
import static ec.edu.espe.view.Costomer.readInt;
public class Project {
    public static void run() {
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        showMainMenu(hardwareStore);
    }
   
    
public static void showMainMenu(HardwareStore hardwareStore) {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
               System.out.println("---------- BIENVENIDO A FERRETERIA DSA ----------");
        System.out.println("DESEA INGRESAR COMO:");
        System.out.println("1. Propietario");
        System.out.println("2. Usuario");
        System.out.println("3. Ver Comentarios del establecimiento");
        System.out.print("Ingrese la opcion deseada: ");
        int op = readInt(scanner);
        if (op == 1){
            System.out.print("Ingrese la codigo personalde propietario: ");
            scanner.nextLine(); 
            String password = scanner.nextLine();
            if (password.equals(OWNER_PASSWORD)) {
               Owner.showOwnerMenu(hardwareStore, scanner);
            } else {
                System.out.println("Codigo incorrecta. Intente nuevamente.");
                System.out.println("Presione Enter para continuar...");
                try {
                    System.in.read();
                } catch (IOException e) {
                }
            }
        } else if (op == 2) {
            Costomer.showUserMenu(hardwareStore, scanner);
        }
            else if(op==3){
             Costomer.showComments();
        } else {
            System.out.println("Opcion no valida. Intente nuevamente.");
        }
    }
} 
}