// WindChill GUI
// Developed: June 2007

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindChill implements ActionListener {

    // Class constants
    private static final int WINDOW_WIDTH = 410;       
    private static final int WINDOW_HEIGHT = 235;      
    private static final int FIELD_WIDTH = 20;       
    private static final int AREA_WIDTH = 40;         
    private static final FlowLayout LAYOUT_STYLE = new FlowLayout();
    private static final String LEGEND = "This windchill calculator is intended for wind speeds greater than 4 mph.";

    // Instance variables
    // Window for GUI
    private JFrame window = new JFrame("Windchill Calculator");

    // Legend
    private JTextArea legendArea = new JTextArea(LEGEND, 2, AREA_WIDTH);

    // User entry area for temperature
    private JLabel fahrTag = new JLabel("Fahrenheit Temperature");
    private JTextField fahrText = new JTextField(FIELD_WIDTH);

    // User entry area for windspeed
    private JLabel windTag = new JLabel("Windspeed (mph)");
    private JTextField windText = new JTextField(FIELD_WIDTH);

    // Entry area for windchill result
    private JLabel chillTag = new JLabel("Windchill Temperature");
    private JTextField chillText = new JTextField(FIELD_WIDTH);

    // Run button
    private JButton runButton = new JButton("Run");

    // WindChill(): Constructor
    public WindChill() {
        configureGUI();
    }

    private void configureGUI() {
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        legendArea.setEditable(false);
        legendArea.setLineWrap(true);
        legendArea.setWrapStyleWord(true);
        legendArea.setBackground(window.getBackground());

        chillText.setEditable(false);

        runButton.setBackground(Color.RED);
        runButton.setOpaque(true);
        runButton.addActionListener(this);

        Container c = window.getContentPane();
        c.setLayout(LAYOUT_STYLE);

        c.add(legendArea);
        c.add(fahrTag);
        c.add(fahrText);
        c.add(windTag);
        c.add(windText);
        c.add(chillTag);
        c.add(chillText);
        c.add(runButton);

        window.setVisible(true);
    }

    // actionPerformed(): run button action event handler
    public void actionPerformed(ActionEvent e) {
        double t = Double.parseDouble(fahrText.getText());
        double v = Double.parseDouble(windText.getText());

        double windchillTemperature = 0.081 * (t - 91.4) * (3.71 * Math.sqrt(v) + 5.81 - 0.25 * v) + 91.4;
        int perceivedTemperature = (int) Math.round(windchillTemperature);

        chillText.setText(String.valueOf(perceivedTemperature));
    }

    // main(): application entry point
    public static void main(String[] args) {
        new WindChill();
    }
}
