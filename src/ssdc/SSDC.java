/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssdc;

import Vistas.Ventana;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author israz
 */
public class SSDC extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Ventana v = new Ventana();
        v.StartLogin();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
