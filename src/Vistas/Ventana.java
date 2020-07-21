package Vistas;


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ventana {
   
    public static Stage gg = new Stage();
    
    public void StartLogin() throws Exception{
        gg.close();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        
        gg.setScene(scene);
        gg.show();
        gg.setResizable(false);
        gg.setTitle("Login");
   
    }
    
    public void StartInicioDirectivo() throws Exception{
    gg.close();
        Parent root = FXMLLoader.load(getClass().getResource("InicioDirectivo.fxml"));
        
        Scene scene = new Scene(root);
        
        gg.setScene(scene);
        gg.show();
        gg.setResizable(false);
    }
    
    public void StartInicioDocente() throws Exception{
    gg.close();
        Parent root = FXMLLoader.load(getClass().getResource("InicioDocente.fxml"));
        
        Scene scene = new Scene(root);
        
        gg.setScene(scene);
        gg.show();
        gg.setResizable(false);
    }
    
    //ENCARGADO
    public void StartInicioEncargado() throws Exception{
    gg.close();
        Parent root = FXMLLoader.load(getClass().getResource("InicioEncargado.fxml"));
        
        Scene scene = new Scene(root);
        
        gg.setScene(scene);
        gg.show();
        gg.setResizable(false);
    }
    
    public void StartAgregarDocente() throws Exception{
    gg.close();
        Parent root = FXMLLoader.load(getClass().getResource("AgregarDocente.fxml"));
        
        Scene scene = new Scene(root);
        
        gg.setScene(scene);
        gg.show();
        gg.setResizable(false);
    }
    
}
