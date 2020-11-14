package arranque;

// Importamos el paquete vista
import vista.*;
 
public class Principal {
 
    public static void main(String[] args) {
         
        // Creamos una instancia de la clase PintarVentana
        VentanaDesactivarBotones ventanaPintada=new VentanaDesactivarBotones();
         
        // Hacemos visible la ventana
        ventanaPintada.setVisible(true);
    }
}