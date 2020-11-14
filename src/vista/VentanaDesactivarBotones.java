package vista;
 
import controlador.ControlClics;
import java.awt.BorderLayout;
import java.awt.GridLayout;
 
// Importamos el paquete swing para trabajar con interfaces gráficas
import javax.swing.*;
 
/**
 * ESTA CLASE DEBE HEREDAR DE JFRAME PARA PODER
 * CREAR LA VENTANA DE NUESTRA INTERFAZ
 */
public class VentanaDesactivarBotones extends JFrame{
     
    /* Esta variable no es necesaria, pero si
     * muy recomendable, ya que nos evitará problemas
     * si hay futuras actualizaciones de la aplicacion*/
    private static final long serialVersionUID = 1L;
    
    // Creamos una lámina para colocar encima del JFrame
    public JPanel laminaFondo = new JPanel(); 
    public JPanel laminaBotones = new JPanel();
     
    // Creamos los controles que tendrá nuestra lámina
     private JLabel lblTitulo = new JLabel();
     public JLabel lblNumero = new JLabel(); 
     public JButton [] botones =new JButton[9];
     
     // Creamos una instancia de nuestra clase controlador
    private ControlClics ejecutarAcciones;
    /**
     * EL CONSTRUCTOR CREA LA VENTANA, LE DA UNAS PROPIEDADES
     * Y ADEMÁS EN EL, SE INDICA QUE SE LE AGREGUE UN JPANEL
     * O LO QUE ES LO MISMO, UNA LAMINA PARA PODER AGREGAR
     * LOS CONTROLES NECESARIOS
     */
    public VentanaDesactivarBotones() {
          
        // Le damos un tamaño a la ventana
        this.setSize(640, 480);
         
        // Agregamos un tículo
        this.setTitle("Desactivar botones");
          
        // Lo centramos en pantalla
        this.setLocationRelativeTo(null);
          
        /* Le decimos que no se puede redimensionar*/
        this.setResizable(false);
          
        // Le decimos que al cerrar la ventana, acabe el programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        // Agregamos una lámina a la ventana
        this.getContentPane().add(laminaFondo);
         
        // llamamos al método que configura la lamina fondo
        // y la lamina de los botones
        configurarLaminaFondo();
        configurarLaminaBotones();
        ejecutar();
    }
     
    private void ejecutar() {
        ejecutarAcciones = new ControlClics(this);
        ejecutarAcciones.escucharEventos();
    }
    
    /**
     * ESTE MÉTODO CONFIGURA NUESTRA LÁMINA (JPANEL) Y AGREGA LOS CONTROLES
     * AL JPANEL DE NUESTRA VENTANA
     */
    private void configurarLaminaFondo() {
         
        // Le damos a la lamina una distribución de tipo BorderLayout.
        laminaFondo.setLayout(new BorderLayout());
         
        // Colocamos un texto a las etiquetas
        lblTitulo.setText("Pulsa cada botón para desactivarlo");
        lblNumero.setText("Número");
         
        // Agregamos las etiquetas al norte y al sur de la lamina
        laminaFondo.add(lblNumero,BorderLayout.SOUTH);
        laminaFondo.add(lblTitulo,BorderLayout.NORTH);
         
        // Alineamos el texto de las etiquetas
        lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
           
    }
     
    private void configurarLaminaBotones() {
         
        // Le damos a la lamina botones una distribucion del tipo GridLayout
        laminaBotones.setLayout(new GridLayout(3,3));
         
        /* Con un bucle, agrego los botones del 1 al 9
         * al panel en forma de rejilla*/
        for(int x=0;x<botones.length;x++) {
                      
            botones[x]=new JButton("Botón " + (x+1));
            laminaBotones.add(botones[x]);
        }     
      
        // Agregamos la laminaBotones en el
        // centro de la laminaFondo
        laminaFondo.add(laminaBotones,BorderLayout.CENTER);
    }
}