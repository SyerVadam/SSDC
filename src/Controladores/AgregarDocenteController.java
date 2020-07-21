/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAOException;
import Lógica.IAgregarDocente;
import Vistas.Ventana;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author israz
 */
public class AgregarDocenteController implements Initializable {

    @FXML
    private TextField txtf_nombre;
    @FXML
    private TextField txtf_apellidopaterno;
    @FXML
    private TextField txtf_apellidomaterno;
    @FXML
    private TextField txtf_contraseña;
    @FXML
    private TextField txtf_rfc;
    @FXML
    private TextField txtf_curp;
    @FXML
    private TextField txtf_añosexperiencia;
    @FXML
    private TextField txtf_usuario;
    @FXML
    private TextField txtf_email;
    @FXML
    private Button btn_agregar;
    private TextField txtf_fechanacimiento;
    @FXML
    private Label lbl_error;
    @FXML
    private Label lbl_errornombre;
    @FXML
    private Label lbl_errorapellidopaterno;
    @FXML
    private Label lbl_errorapellidomaterno;
    @FXML
    private Button btn_regresar;

  
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void handleAgregarDocente(ActionEvent event) throws SQLException, DAOException {
        
            lbl_error.setText(" ");
            lbl_errornombre.setText(" ");
            lbl_errorapellidopaterno.setText(" ");
            lbl_errorapellidomaterno.setText(" ");
        String nombre = txtf_nombre.getText();
        String apellidoPaterno = txtf_apellidopaterno.getText();
        String apellidoMaterno = txtf_apellidomaterno.getText();
        String contraseña = txtf_contraseña.getText();
        String rfc = txtf_rfc.getText();
        String curp = txtf_curp.getText();
        int antiguedad = Integer.parseInt(txtf_añosexperiencia.getText());
        String usuario = txtf_usuario.getText();
        String email = txtf_email.getText();
       
        if (ValidarCamposVacios(nombre,apellidoPaterno,apellidoMaterno,contraseña,rfc,curp,antiguedad,usuario,email) == false){
            lbl_error.setText("Comprobar campos vacíos");

        }else{
        
        if (ValidarCamposNumeros(nombre,apellidoPaterno,apellidoMaterno) == true){
            lbl_error.setText("Comprobar contenido de números");
            lbl_errornombre.setText(" *");
            lbl_errorapellidopaterno.setText(" *");
            lbl_errorapellidomaterno.setText(" *");
            
        }else{
        if (ValidarFormatoEmail(email) == false){
           lbl_error.setText("Correo electrónico incorrecto");
            
        }else{
            IAgregarDocente iagregardocente = new IAgregarDocente();
        if (iagregardocente.ExisteCorreo(email) == true){
           lbl_error.setText("El correo electrónico ingresado ya existe");
           
        }else{
            lbl_error.setText("Registrando...");
             try{
           
           
           iagregardocente.RegistrarDocente(nombre, apellidoPaterno, apellidoMaterno, contraseña, rfc, curp, antiguedad, usuario, email);
            
        
        }
        catch (Exception e){
            System.out.println("Error en AgregarDocenteController.java, no accedió a la implementación IAgregarDocente para el registro a la base de datos"+e.getMessage());
        }
        }
        }//else
        }//
        }//
        
        
    }
    
     public static boolean ValidarCamposVacios(String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña, String rfc, String curp, int antiguedad, String usuario, String email)
     {
         if(nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || apellidoPaterno.isEmpty() 
                 || contraseña.isEmpty() || rfc.isEmpty() || curp.isEmpty() || usuario.isEmpty() 
                 || email.isEmpty() || email.isEmpty()){
             return false;
         }
             return true;
     }
     public static boolean ValidarFormatoEmail(String email) { //Checar e-mail
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
        
        return mather.find();
        
    }
     
    public static boolean ValidarCamposNumeros(String nombre, String apellidoPaterno, String apellidoMaterno){
        for (int i = 0; i < nombre.length(); i++){
            if (Character.isDigit(nombre.charAt(i))){
                return true;
            }
        }
      
        
        for (int i = 0; i < apellidoPaterno.length(); i++){
            if (Character.isDigit(apellidoPaterno.charAt(i))){
                return true;
            }
        }
        
        for (int i = 0; i < apellidoMaterno.length(); i++){
            if (Character.isDigit(apellidoMaterno.charAt(i))){
                return true;
            }
            
        }
         
         return false;
     }
    
    public static boolean ValidarExistenciaCorreo(String email){
        
        return true;
    }
    
    @FXML
    private void handleRegresar(ActionEvent event) {
        Ventana v = new Ventana();
        try{
        v.StartInicioEncargado();
        
        }catch (Exception e){
            
        }
        
        
    }

    
}
