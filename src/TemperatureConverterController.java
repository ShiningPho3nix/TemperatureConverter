/**
 * TODO Kommentare schreiben
 * 
 * @author Steffen Dworsky, u.a.
 *
 */
public class TemperatureConverterController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new TemperatureConverterController();
    }
    //-------------------------------------------------------------------------
    
    private TemperatureConverterModel model;
    private TemperatureConverterView view;
    
    TemperatureConverterController(){
        model = new TemperatureConverterModel();
        view = new TemperatureConverterView(this);
        model.addObserver(view);
    }
    
    public void inputFahrenheit(int value){
        model.setFahrenheit(value);
    }
    
    public void inputCelsius(int value){
        model.setCelsius(value);
    }
}
