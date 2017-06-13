import javafx.scene.control.*;

import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

/**
 * Created by shweta on 17/03/17.
 */

/*
This Class creates a the constructors and getters for the creating a radio button object
It extends the JRadioButton swing component and implements the ActionListener
 */
public class RadioButton extends JRadioButton implements ActionListener {


    private ButtonGroup guiRadioButton;
    private JRadioButton lower;
    private JRadioButton upper;
    private  String caseActionString;

    public RadioButton (String s1, String s2){

          lower = new JRadioButton(s1);
          lower.setActionCommand(s1);
          upper =new JRadioButton(s2);
          upper.setActionCommand(s2);

          guiRadioButton = new ButtonGroup();
          guiRadioButton.add(lower);
          guiRadioButton.add(upper);

        lower.addActionListener(this);
        upper.addActionListener(this);

    }

    public JRadioButton getLower(){ return lower;}
    public JRadioButton getUpper(){ return upper;}

    public void setGuiRadioButton(ButtonGroup guiRadioButton) {
        this.guiRadioButton = guiRadioButton;
    }

    public void actionPerformed(ActionEvent e) {
       caseActionString = e.getActionCommand();

    }

    public String getCase() {return caseActionString;}

}
