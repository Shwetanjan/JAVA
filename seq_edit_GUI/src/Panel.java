import  javax.swing.*;
import java.awt.*;

/**
 * Created by shweta on 17/03/17.
 */

/*
This Class creates a the constructors and getters for the creating a Panel object
It extends the JPanel swing component
 */
public class Panel extends JPanel {



    private JTextArea guiTextArea;
    private JScrollPane guiScrollPane;

    public JTextArea getGuiTextArea() {
        return guiTextArea;
    }

    public void setGuiTextArea(JTextArea guiTextArea) {
        this.guiTextArea = guiTextArea;
    }

    public JScrollPane getGuiScrollPane() {
        return guiScrollPane;
    }

    public void setGuiScrollPane(JScrollPane guiScrollPane) {
        this.guiScrollPane = guiScrollPane;
    }




    public Panel(String s, int x, int y){

        guiTextArea = new JTextArea(s,x,y);
        guiTextArea.setLineWrap(true);
        guiTextArea.setWrapStyleWord(true);
        this.add (guiTextArea);

        guiScrollPane = new JScrollPane(getGuiTextArea());
        guiScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(guiScrollPane);
    }

     // getter to get the value in the text area
     public String getStringInput (){
         return guiTextArea.getText(); }

    //set the value in the text area
    public void setTextInput(String t){
         guiTextArea.setText(t);
         }
}