package ComponentCustom;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontCustom {
    public Font customFont17;
    public Font customFont23;

    public FontCustom () {
        // get font
        try {
            //create the font to use. Specify the size!
            customFont17 = Font.createFont(Font.TRUETYPE_FONT, new File("font/poppin.ttf")).deriveFont(17f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont17);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }

        try {
            //create the font to use. Specify the size!
            customFont23 = Font.createFont(Font.TRUETYPE_FONT, new File("font/poppin.ttf")).deriveFont(23f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont23);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
    }
}
