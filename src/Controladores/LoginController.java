/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAOException;
import Lógica.ILogin;
import Vistas.Ventana;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author israz
 */
public class LoginController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtfield_nombredeusuario;
    @FXML
    private Label lbl_nombredeusuario;
    @FXML
    private Label lbl_contraseña;
    @FXML
    private PasswordField txtfield_contraseña;
    @FXML
    private Button btn_iniciarsesion;
    @FXML
    private Label lbl_olvidastecontraseña;
    @FXML
    private Button btn_recuperarcontraseña;
    @FXML
    private Label lbl_iniciarsesion;
    @FXML
    private Button btn_salir;
    @FXML
    private Label lbl_correoinvalido;
    @FXML
    private Label lbl_request;
    
    private void handleSalir(ActionEvent event) {
            System.exit(0);
       
    }
    
    @FXML
    private void handleIniciarSesion(ActionEvent event) throws DAOException {
        Ventana v = new Ventana();
        
        ILogin ilogin = new ILogin();
        String email = txtfield_nombredeusuario.getText();
        String password = txtfield_contraseña.getText();
        
        if(ValidarFormatoEmail(email) == true){
            try{
                
                switch(ilogin.IniciarSesion(email, password)){
                    case 1: v.StartInicioDocente();
                    break;
                    case 2: v.StartInicioDirectivo();
                    break;
                    case 3: v.StartInicioEncargado();
                    break;
                    default:
                    lbl_request.setText("Correo electrónico o contraseña incorrectos");
                }
                
            }catch (Exception e){
                
            }
        }else{
            lbl_correoinvalido.setText("ERROR: Introduce un correo en formato válido");
        }
         
    }
    
    public static boolean ValidarFormatoEmail(String email) { //Checar e-mail
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
  
    
    @FXML
    private void handleCleanAlert(MouseEvent event) {
        lbl_correoinvalido.setText(" ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

 


    
}
