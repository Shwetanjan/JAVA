import javax.swing.*;
import  java.awt.*;
/**
 * Created by shweta on 17/03/17.
 *
 */


/*
This Class creates a the constructors and getters for the creating a Label  object
It extends the JLabel swing component
 */
public class Label extends JLabel{

    private JLabel guiLabel;

    public JLabel getGuiLabel() {
        return guiLabel;
    }

    public void setGuiLabel(JLabel guiLabel) {
        this.guiLabel = guiLabel;
    }



    public Label(String s){

        guiLabel = new JLabel(s);

    }

}