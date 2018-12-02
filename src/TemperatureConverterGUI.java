import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * TODO Kommentare schreiben
 * 
 * @author Steffen Dworsky, u.a.
 *
 */
public class TemperatureConverterGUI extends JFrame implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int CELSIUS_MIN = -273;
	static final int CELSIUS_MAX = 100;
	static final int CELSIUS_INIT = 37;
	static final int FAHRENHEIT_MIN = -459;
	static final int FAHRENHEIT_MAX = 212;
	static final int FAHRENHEIT_INIT = 100;
	public double tempCelsius = (double) CELSIUS_INIT;
	public double tempFahrenheit = (double) FAHRENHEIT_INIT;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TemperatureConverterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 350);
		setTitle("Temperature Converter");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 70, 0, 80, 0, 80, 0, 70, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblCelsius = new JLabel("Celsius");
		GridBagConstraints gbc_lblCelsius = new GridBagConstraints();
		gbc_lblCelsius.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelsius.gridx = 1;
		gbc_lblCelsius.gridy = 1;
		contentPane.add(lblCelsius, gbc_lblCelsius);

		JFormattedTextField celsiusTextField = new JFormattedTextField(CELSIUS_INIT);
		GridBagConstraints gbc_celsiusTextField = new GridBagConstraints();
		gbc_celsiusTextField.insets = new Insets(0, 0, 5, 5);
		gbc_celsiusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_celsiusTextField.gridx = 2;
		gbc_celsiusTextField.gridy = 1;
		contentPane.add(celsiusTextField, gbc_celsiusTextField);
		celsiusTextField.addPropertyChangeListener("value", this);

		JFormattedTextField fahrenheitTextField = new JFormattedTextField(String.valueOf(FAHRENHEIT_INIT));
		GridBagConstraints gbc_fahrenheitTextField = new GridBagConstraints();
		gbc_fahrenheitTextField.insets = new Insets(0, 0, 5, 5);
		gbc_fahrenheitTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fahrenheitTextField.gridx = 4;
		gbc_fahrenheitTextField.gridy = 1;
		contentPane.add(fahrenheitTextField, gbc_fahrenheitTextField);

		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		GridBagConstraints gbc_lblFahrenheit = new GridBagConstraints();
		gbc_lblFahrenheit.insets = new Insets(0, 0, 5, 5);
		gbc_lblFahrenheit.gridx = 5;
		gbc_lblFahrenheit.gridy = 1;
		contentPane.add(lblFahrenheit, gbc_lblFahrenheit);

		JSlider celsiusSlider = new JSlider(JSlider.VERTICAL, CELSIUS_MIN, CELSIUS_MAX, CELSIUS_INIT);
		celsiusSlider.setBackground(Color.GRAY);
		celsiusSlider.setPaintTicks(true);
		celsiusSlider.setPreferredSize(new Dimension(70, 250));
		celsiusSlider.setMinorTickSpacing(5);
		celsiusSlider.setMajorTickSpacing(50);
		celsiusSlider.setValue(CELSIUS_INIT);
		celsiusSlider.setPaintLabels(true);
		GridBagConstraints gbc_celsiusSlider = new GridBagConstraints();
		gbc_celsiusSlider.gridheight = 6;
		gbc_celsiusSlider.insets = new Insets(0, 0, 0, 5);
		gbc_celsiusSlider.gridx = 0;
		gbc_celsiusSlider.gridy = 0;
		contentPane.add(celsiusSlider, gbc_celsiusSlider);

		JSlider fahrenheitSlider = new JSlider(SwingConstants.VERTICAL, FAHRENHEIT_MIN, FAHRENHEIT_MAX,
				FAHRENHEIT_INIT);
		fahrenheitSlider.setPreferredSize(new Dimension(70, 250));
		fahrenheitSlider.setPaintTicks(true);
		fahrenheitSlider.setPaintLabels(true);
		fahrenheitSlider.setMinorTickSpacing(5);
		fahrenheitSlider.setMajorTickSpacing(50);
		fahrenheitSlider.setBackground(Color.GRAY);
		GridBagConstraints gbc_fahrenheitSlider = new GridBagConstraints();
		gbc_fahrenheitSlider.gridheight = 6;
		gbc_fahrenheitSlider.insets = new Insets(0, 0, 5, 0);
		gbc_fahrenheitSlider.gridx = 6;
		gbc_fahrenheitSlider.gridy = 0;
		contentPane.add(fahrenheitSlider, gbc_fahrenheitSlider);
		GridBagConstraints gbc_btnZurcksetzen = new GridBagConstraints();
		gbc_btnZurcksetzen.insets = new Insets(0, 0, 0, 5);
		gbc_btnZurcksetzen.gridx = 3;
		gbc_btnZurcksetzen.gridy = 5;

		JButton btnCelsiusFahrenheit = new JButton("Celsius -> Fahrenheit");
		btnCelsiusFahrenheit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnCelsiusFahrenheit = new GridBagConstraints();
		gbc_btnCelsiusFahrenheit.insets = new Insets(0, 0, 5, 5);
		gbc_btnCelsiusFahrenheit.gridx = 2;
		gbc_btnCelsiusFahrenheit.gridy = 3;
		contentPane.add(btnCelsiusFahrenheit, gbc_btnCelsiusFahrenheit);

		JButton btnUmrechnen = new JButton("Fahreheit -> Celsius");
		GridBagConstraints gbc_btnUmrechnen = new GridBagConstraints();
		gbc_btnUmrechnen.insets = new Insets(0, 0, 5, 5);
		gbc_btnUmrechnen.gridx = 4;
		gbc_btnUmrechnen.gridy = 3;
		contentPane.add(btnUmrechnen, gbc_btnUmrechnen);

		JButton btnZurcksetzen = new JButton("Zur\u00FCcksetzen");
		btnZurcksetzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				celsiusTextField.setText(String.valueOf(CELSIUS_INIT));
				fahrenheitTextField.setText(String.valueOf(FAHRENHEIT_INIT));
				celsiusSlider.setValue(CELSIUS_INIT);
				fahrenheitSlider.setValue(FAHRENHEIT_INIT);
				tempCelsius = Double.parseDouble(celsiusTextField.getText());
				tempFahrenheit = Double.parseDouble(fahrenheitTextField.getText());
			}
		});

		contentPane.add(btnZurcksetzen, gbc_btnZurcksetzen);

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub

	}
}
