/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import Arbol.ArbolB;
import Arbol.ArbolGrafico;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Javier
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtInsertar, txtEliminar;
    @FXML
       public TextArea txtPre, txtMovimientos;
    ArbolB arbol;
    
    
    @FXML
    private void insertar(ActionEvent event) {
        if(!" ".equals(txtInsertar.getText()) || txtInsertar.getText() != null){
            int numero = Integer.parseInt(txtInsertar.getText());
            arbol.insertar(numero);
              arbol.preorder();
        }
      
       
    }
 
    @FXML
    public void showArbol(ActionEvent ev) {
        createAndSetSwingContent(arbol);
    }

    private void createAndSetSwingContent(ArbolB ar) {

        SwingUtilities.invokeLater(() -> {
            
            JFrame pane = new JFrame("Arbol de Huffman");
            pane.add(new ArbolGrafico(ar));
            pane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //para terminar hilo
            pane.setSize(1700, 720);
            pane.setVisible(true);
           
        });

    }
    @FXML
    private void eliminar(ActionEvent event) {
        if(!" ".equals(txtEliminar.getText()) || txtEliminar.getText() != null){
            int numero = Integer.parseInt(txtEliminar.getText());
            arbol.eliminar(numero);
             arbol.preorder();
        }
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arbol = new ArbolB(txtPre,txtMovimientos);
    }    
    
}
