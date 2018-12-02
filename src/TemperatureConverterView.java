import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * TODO Kommentare schreiben
 * 
 * @author Steffen Dworsky, u.a.
 *
 */
public class TemperatureConverterView implements Observer {

    protected TemperatureConverterController controller;

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel fahrenheitLabel;
    private JLabel celsiusLabel;
    private JSlider fahrenheitSlider;
    private JSlider celsiusSlider;
    private JFormattedTextField fahrenheitText;
    private JFormattedTextField celsiusText;
    private JButton celsiusButton;
    private JButton fahrenheitButton;

    public TemperatureConverterView(TemperatureConverterController cont) {
        controller = cont;

        mainFrame = new JFrame("TemperatureConverter MVC");
        mainFrame.setSize(700, 300);

        mainPanel = new JPanel(new java.awt.FlowLayout());
        fahrenheitLabel = new JLabel("Fahrenheit");
        celsiusLabel = new JLabel("Celsius");

        fahrenheitSlider = new JSlider(SwingConstants.VERTICAL, -40, 160, 32);
        fahrenheitSlider.setPaintLabels(true);
        fahrenheitSlider.setPaintTicks(true);
        fahrenheitSlider.setMajorTickSpacing(40);
        fahrenheitSlider.setMinorTickSpacing(1);
        fahrenheitSlider.setSnapToTicks(true);
        fahrenheitSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    controller.inputFahrenheit(source.getValue());

                }
            }
        });

        celsiusSlider = new JSlider(SwingConstants.VERTICAL, -40, 70, 0);
        celsiusSlider.setPaintLabels(true);
        celsiusSlider.setPaintTicks(true);
        celsiusSlider.setMajorTickSpacing(25);
        celsiusSlider.setMinorTickSpacing(1);
        celsiusSlider.setSnapToTicks(true);
        celsiusSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    controller.inputCelsius(source.getValue());

                }
            }
        });

        fahrenheitText = new JFormattedTextField(NumberFormat.getNumberInstance());
        fahrenheitText.setColumns(1);
        fahrenheitText.setValue(32);
        fahrenheitText.setEditable(true);

        celsiusText = new JFormattedTextField(NumberFormat.getNumberInstance());
        celsiusText.setColumns(1);
        celsiusText.setValue(0);
        celsiusText.setEditable(true);
        
        fahrenheitButton = new JButton("Convert2Celsius ->");
        fahrenheitButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                int i = Integer.parseInt(fahrenheitText.getText());
                controller.inputFahrenheit(i);
            }
        });
        celsiusButton = new JButton("<- Convert2Fahrenheit");
        celsiusButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                int i = Integer.parseInt(celsiusText.getText());
                controller.inputCelsius(i);
            }
        });

        mainPanel.add(fahrenheitSlider);
        mainPanel.add(fahrenheitLabel);
        mainPanel.add(fahrenheitText);
        mainPanel.add(fahrenheitButton);
        mainPanel.add(celsiusButton);
        mainPanel.add(celsiusText);
        mainPanel.add(celsiusLabel);
        mainPanel.add(celsiusSlider);
        mainFrame.add(mainPanel);
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        TemperatureConverterModel source = (TemperatureConverterModel)o;
        int c = source.getCelsius();
        int f = source.getFahrenheit();
        fahrenheitSlider.setValue(f);
        fahrenheitText.setValue(f);
        celsiusSlider.setValue(c);
        celsiusText.setValue(c);
    }

}
