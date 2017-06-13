import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
/**
 * Created by shweta on 17/03/17.
 */
public class Buttons extends JButton {
    public JButton getGuiButton() {
        return guiButton;
    }

    public void setGuiButton(JButton guiButton) {
        this.guiButton = guiButton;
    }

    private JButton guiButton;

    //String s;
    public Buttons(String s) {
        guiButton = new JButton(s);
        this.add(guiButton);
        //guiButton.addActionListener(this);
    }
}

