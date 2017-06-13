import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by shweta on 16/03/17.
 */

/*
This Class creates a the constructors and getters for the creating a comboBox object
It extends the JComboBox swing component and implements the ActionListener
 */
public class ComboBox extends JComboBox {

    private JComboBox guiComboBox;

    public JComboBox getGuiComboBox() {
        return guiComboBox;
    }

    public void setGuiComboBox(JComboBox guiComboBox) {
        this.guiComboBox = guiComboBox;
    }


    public ComboBox(int a, int b, int c, int d) {

        guiComboBox = new JComboBox();
        guiComboBox.addItem(a);
        guiComboBox.addItem(b);
        guiComboBox.addItem(c);
        guiComboBox.addItem(d);
        guiComboBox.setSelectedIndex(2);
        guiComboBox.addActionListener(this);

    }


    public int getLength() {
        return (int) guiComboBox.getSelectedItem();
    }

}


