
import javafx.scene.control.*;

import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

/**
 * Created by shweta on 17/037.
 */

/*
 This Class creates a the constructors and getters for the creating a check Box object
 It extends the JCheckBox swing component and implements the ItemListener
*/
public class CheckBox extends JCheckBox implements ItemListener{



    private JCheckBox guiCheckBox;
    private  boolean flag;

    public CheckBox (String s1){

        guiCheckBox = new JCheckBox(s1);
        guiCheckBox.addItemListener(this);

    }


    public JCheckBox getGuiCheckBox() {
        return guiCheckBox;
    }

    public void setGuiCheckBox(JCheckBox guiCheckBox) {
        this.guiCheckBox = guiCheckBox;
    }

    //Register the changed status of te check box and return a flag for true or false
    public void itemStateChanged(ItemEvent e) {
            flag = false;
        Object source = e.getItemSelectable();
        // find out whether it was selected or deselected.
        if (e.getStateChange() == ItemEvent.SELECTED) {
            flag = true;
        }
    }

    // getter for the status being checked retuns the flag value
    public boolean getCheckStaus() {
        return flag;
    }



}

