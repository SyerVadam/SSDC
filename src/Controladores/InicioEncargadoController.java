/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.Ventana;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author israz
 */
public class InicioEncargadoController implements Initializable {

    @FXML
    private Button btn_agregardocente;
    @FXML
    private Button btn_salir;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAgregarDocente(ActionEvent event) {
        
        Ventana v = new Ventana();
        try{
            v.StartAgregarDocente();
        }catch(Exception e){
            
        }
        
    }

    @FXML
    private void handleSalir(ActionEvent event) {
        System.exit(0);
    }
    
}
