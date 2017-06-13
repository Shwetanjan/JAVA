/*
I declare that the attached assignment is my own work in accordance
with Seneca Academic Policy. No part of this assignment has been
copied manually or electronically from any other source (including web
sites) or distributed to other students.
Name :  Shweta Anjan
Student ID: 037-775-152
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;


/**
 * Created by shweta on 16/03/17.
 */

/*
This Class creates a the GUI frame and adds the components into it by instantiating the component classes
It extends the JFrame swing component
 */
public class GuiFrame extends JFrame {

/*
Main method that creates, formats and adds all the components to the GUI frame
Regesters the action listerns and performs the desired action
 */
    public static void main(String[] args) {

        // GuiFrame class instantiation and set basic frame layout to Flow and keep it centred

        GuiFrame gui = new GuiFrame();
        gui.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Create a Label for the input sequence panel of type Label
        Label inputLabel = new Label("Enter input sequence");

        //Create a Panel for the input text of type Panel
        Panel inputPanel = new Panel("", 10, 60);

        /*
         Create an input sequence Panel to containerize the input label and text Panel
         Set the layout for this panel
         Add the input label and text panel to sequence Panel
         */

        JPanel inputSeqPanel = new JPanel();
        inputSeqPanel.setLayout(new BoxLayout(inputSeqPanel, BoxLayout.Y_AXIS));
        inputSeqPanel.add(inputLabel.getGuiLabel());
        inputSeqPanel.add(inputPanel.getGuiScrollPane());

        //Add the input sequence panel to the gui basic frame
        gui.add(inputSeqPanel);


        /*
         Create an options Panel to containerize the options selected
         Set the layout for this panel
         Add the combo Box (for selecting the number of characters per line)
         and the radioBottons (to toggle between upper and lower case)
         to the options panel
         */
        JPanel optionsPanel = new JPanel(new FlowLayout());

        Label comboBoxLabel = new Label("Characters per line");
        comboBoxLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        optionsPanel.add(comboBoxLabel.getGuiLabel());
        //gui.add(comboBoxLabel.getGuiLabel());

        ComboBox seqComboBox = new ComboBox(40, 50, 60, 70);
        //gui.add(seqComboBox.getGuiComboBox());
        optionsPanel.add(seqComboBox.getGuiComboBox());


        RadioButton caseButton = new RadioButton("Lower case", "Upper case");
        JPanel caseButtonPanel = new JPanel(new FlowLayout());
        caseButtonPanel.add(caseButton.getLower());
        caseButtonPanel.add(caseButton.getUpper());
        //gui.add(caseButton.getLower());
        //gui.add(caseButton.getUpper());
        optionsPanel.add(caseButtonPanel);


         /*
         create a check box for selecting the dispay in griops of 10
         and add it to the Gui main frame
          */
        CheckBox lengthFormat = new CheckBox(" check box to display the sequence in groups of 10 characters"+"\n");
        //gui.add(lengthFormat.getGuiCheckBox());
        //lengthFormat.setLayout(new BoxLayout(lengthFormat,BoxLayout.Y_AXIS));
        gui.add(lengthFormat.getGuiCheckBox());

        gui.add(optionsPanel);


        JPanel outputSeqPanel = new JPanel();
        outputSeqPanel.setLayout(new BoxLayout(outputSeqPanel, BoxLayout.Y_AXIS));

        Label outLabel = new Label("\n"+ "Formatted Sequence");
        //gui.add(outLabel.getGuiLabel());
        outputSeqPanel.add(outLabel.getGuiLabel());

        Panel outputPanel = new Panel("", 10, 60);
        //gui.add(outputPanel.getGuiScrollPane());
        outputSeqPanel.add(outputPanel.getGuiScrollPane());

        gui.add(outputSeqPanel);

        JPanel seqStatPanel = new JPanel(new GridLayout(0,2));
        Label seqLenLabel = new Label("Sequence length");
        //gui.add(seqLenLabel.getGuiLabel());
        seqStatPanel.add(seqLenLabel.getGuiLabel());

        Panel seqLenPanel = new Panel("", 0, 0);
        seqStatPanel.add(seqLenPanel.getGuiScrollPane());

        Label basePercentLabel = new Label("Base %");
        //gui.add(basePercentLabel.getGuiLabel());
        seqStatPanel.add(basePercentLabel.getGuiLabel());

        Panel basePercentPanel = new Panel("", 5, 20);
        //gui.add(basePercentPanel.getGuiScrollPane());
        seqStatPanel.add(basePercentPanel.getGuiScrollPane());

        gui.add(seqStatPanel);


        /*
         Create an output sequence Panel to containerize the output label and text Panel
         Set the layout for this panel
         Add the output label and text panel to sequence Panel
         */

        JPanel guiButtonPanel = new JPanel(new GridLayout(0,2));
        JButton submitButton = new JButton("Submit");
        guiButtonPanel.add(submitButton);
        //gui.add(submitButton);
        //submitButton.actionPerformed(new ActionListener());


        //Set the general look and feel of the GUI main frame

        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setSize(700, 700);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setResizable(true);
        gui.setTitle("Sequence Formater");

        /*
        Customize the action listerner and action performer for the submit button
        by overriding the actionPerformed function of the ActionLister
         */


        JButton ResetButton = new JButton("Reset");
        guiButtonPanel.add(ResetButton);

        gui.add(guiButtonPanel);



        /*
        Add action listner to the submit button to register the clicl and perform the actions asscoiated with submit button
        by overriding the action listner's actionPerformed method
         */
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*
                set the variables for getting values from the various component class constructors
                Read the options selected into variables variables
                 */

                String command = e.getActionCommand();
                String input = inputPanel.getStringInput();
                input = input.replace("\n", "");
                int totalStringLength = seqComboBox.getLength();
                String caseChoice = caseButton.getCase();
                boolean lengthChoice = lengthFormat.getCheckStaus();
                StringBuilder buf = new StringBuilder();
                String percent = "";
                String len = Integer.toString(input.length());

                //intialise the base count registers to zero
                int aCount = 0;
                int tCount = 0;
                int gCount = 0;
                int cCount = 0;
                int lineLength = 0;
                float aPercent;
                float gPercent;
                float cPercent;
                float tPercent;

                //check the staus of the submit command and perform the tasks associared with the submit commmand

                if (command == "Submit") {

                    // if submit on empty sequence promts to entre a seq
                    if ("".equals(input)) {
                        System.out.print(input);
                        JFrame nullErrorframe = new JFrame();
                        JOptionPane.showMessageDialog(nullErrorframe,
                                "Entre a valid sequence and submit");
                    }

                    else {

                        // case check to count the bases and to check if the entred sequence as a valid agtc sequnce

                        for (int i = 0; i < input.length(); i++) {
                            String base = input.substring(i, i + 1).toLowerCase();

                            if (base.matches("[agtc]")) {
                                switch (base.charAt(0)) {

                                    case 'a':
                                        aCount++;
                                        break;
                                    case 'c':
                                        cCount++;
                                        break;
                                    case 't':
                                        tCount++;
                                        break;
                                    case 'g':
                                        gCount++;
                                        break;
                                }

                                //Calculate the percent of A, T, G and C

                                aPercent = ((float) aCount / input.length()) * 100;
                                gPercent = ((float) gCount / input.length()) * 100;
                                cPercent = ((float) cCount / input.length()) * 100;
                                tPercent = ((float) tCount / input.length()) * 100;
                                percent = "A=" + aPercent + "\n" + "C=" + cPercent + "\n" + "G=" + gPercent + "\n" + "T=" + tPercent + "\n";
                            }
                            else {

                                // In case the sequence dosnot have a valid DNA sequence, promt the user and reset the input panel

                                JFrame seqErrorframe = new JFrame();
                                JOptionPane.showMessageDialog(seqErrorframe,
                                        "Entre a valid DNA sequence", "Inane error",
                                        JOptionPane.ERROR_MESSAGE);
                                inputPanel.setTextInput("");

                               // break;
                                return;
                            }

                        }

                        // Covert the sequence to lower or upper case based on the users choice

                        if (caseChoice == "Lower case") {
                            input = input.toLowerCase();
                        } else if (caseChoice == "Upper case") {
                            input = input.toUpperCase();
                        }

                        // Resgister the choice for grouping the sequence if true reset the sequence interval calculator constant to 1


                        int delta = 0;
                        if (lengthChoice == true) {
                            input = seqFormater(input, " ", 10);
                            delta = 1;
                        }

                        // Register the choice for line length and format the sequence accordingly


                        switch (totalStringLength) {
                            case 40:
                                input = seqFormater(input, "\n", 40 + (4 * delta));
                                break;

                            case 50:
                                input = seqFormater(input, "\n", 50 + (5 * delta));
                                break;

                            case 60:
                                input = seqFormater(input, "\n", 60 + (6 * delta));
                                break;

                            case 70:
                                input = seqFormater(input, "\n", 70 + (7 * delta));
                                break;
                        }
                    }
                    // Display the formatted seq and calclulated base % and sequence length in the repective windows
                    outputPanel.setTextInput(input);
                    basePercentPanel.setTextInput(percent);
                    seqLenPanel.setTextInput(len);

                }
            }


            // Function to insert the gap after the specified interval
            // Source: http://stackoverflow.com/questions/537174/putting-char-into-a-java-string-for-each-n-characters

            private String seqFormater(String s, String gap, int interval) {

                // Inserts a String into the sequence at the period specified


                // Source: http://stackoverflow.com/questions/537174/putting-char-into-a-java-string-for-each-n-characters

                StringBuilder builder =
                        new StringBuilder(s.length() + gap.length() * (s.length() / interval) + 1);

                int i = 0;
                while (i < s.length()) {
                    builder.append(s.substring(i, Math.min(i + interval, s.length())));           // stop at the end and append a 10 character substring of the sequence
                    builder.append(gap);                                                          // append a whitespace
                    i += interval;                                                                // then append the next 10 characters...
                }
                return builder.toString();
            }


        });


        /*
        Add action listner to the submit button to register the clicl and perform the actions asscoiated with submit button
        by overriding the action listner's actionPerformed method
         */

        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                // Check if the reset has been clicked and perform the tasks
                if (command == "Reset") {

                    //pop up an erroe message wit options of yes, no, cancel
                    JFrame frame = new JFrame();
                    Object[] options = {"Yes",
                            "No",
                            "Cancel"};

                    //create the pop up window
                    int n = JOptionPane.showOptionDialog(frame,
                            "Would you like to Reset "                          ,
                            "Reset confirm",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[2]);

                    //check for the options selected and reset if yes
                    if (n == JOptionPane.OK_OPTION) {
                        inputPanel.setTextInput("");
                        outputPanel.setTextInput("");
                        seqLenPanel.setTextInput("");
                        basePercentPanel.setTextInput("");
                        System.out.print("Form reset.");

                    }
                    else if (n == JOptionPane.CANCEL_OPTION) {
                        //break;
                    } else if (n == JOptionPane.CLOSED_OPTION) {
                        //break;
                    }

                }


            }
        });


    }
}