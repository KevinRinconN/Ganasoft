package baseDatos.momento3.ganasoft.View;

import javax.swing.*;
import java.awt.*;

public class PanelContenido extends JPanel {
    private Image imagen;
    private String imagenUbicacion;

    public PanelContenido (String imagenUbicacion){
        this.imagenUbicacion = imagenUbicacion;
    }

    public void paint(Graphics g) {
        imagen = new ImageIcon(imagenUbicacion).getImage();
        this.setOpaque(false);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        super.paint(g);
    }


}
