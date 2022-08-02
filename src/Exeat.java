import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Exeat {

    // First Page
    void ExeatApp () {

        JFrame gui = new JFrame("Exeat App");  // create gui frame
        gui.setSize(800, 400);  // set gui size
        gui.setLayout(new GridLayout(4, 2));  // set gui layout

        JLabel reasonLabel = new JLabel("Reason For Exeat: ");  // create reason label
        JTextField reasonField = new JTextField(); // create reason text or input field
        gui.add(reasonLabel); // add to frame
        gui.add(reasonField); // add to frame

        JLabel periodLabel = new JLabel("Period of Exeat: "); // create period label
        JTextField periodField = new JTextField(); // create period text or input field
        gui.add(periodLabel); // add to frame
        gui.add(periodField); // add to frame

        JButton signButton = new JButton("SIGN"); // create button
        signButton.setBackground(Color.PINK); // change button color to PINK
        gui.add(signButton); // add to frame

        gui.setVisible(true); // make gui visible

        // execute this when button is clicked
        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reasonValue = reasonField.getText();  // receive text from periodField(line 15)
                String periodValue = periodField.getText();  // receive text from periodField(line 20)

                // write to file: try catch block is needed to do anything create, write and close files
                try {
                    FileWriter schoolExeatGranted = new FileWriter("schoolExeatGranted.txt");  // create file
                    schoolExeatGranted.write("Reason For Exeat - " + reasonValue + "\nPeriod of Exeat - " + periodValue + "\nDean: SIGNED"); // write to file
                    schoolExeatGranted.close(); // close file. must close file after use
                } catch (IOException ex) {
                    System.out.println(ex);   // catch any error
                }

                // call next method ExitGranted() - where our next gui is created for the next page
                ExitGranted();
            }
        });
    }

    // Next Page
    void ExitGranted () {
        JFrame gui = new JFrame("Exeat App"); // create gui frame
        gui.setSize(600, 300); // set size of frame
        gui.setLayout(new GridLayout(4, 2)); // set layout of frame

        JLabel grantedlabel = new JLabel("Exeat granted!!!"); // create granted label
        gui.add(grantedlabel); // add label to gui

        gui.setVisible(true); // make frame visible
    }
}
