package ComponentCustom;

import javax.swing.*;
import java.awt.*;

public class ImageIconCustom extends ImageIcon {
    public ImageIconCustom (String f, int height, int width) {
        setImage(new ImageIcon(getClass().getClassLoader().getResource(f)).getImage().getScaledInstance(height, width, Image.SCALE_AREA_AVERAGING));
    }
}
