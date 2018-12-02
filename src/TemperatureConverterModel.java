import java.util.Observable;

/**
 * TODO Kommentare schreiben
 * 
 * @author Steffen Dworsky, u.a.
 *
 */
public class TemperatureConverterModel extends Observable{
    
    private float celsius;
    private float fahrenheit;
    
    public TemperatureConverterModel(){
        
    }
    
    public void setFahrenheit(float value){
        
        fahrenheit = value;
        celsius = (fahrenheit - 32.0f) * (5.0f/9.0f);
        
        setChanged();
        notifyObservers();
    }
    
    public void setCelsius(float value){
        
        celsius = value;
        fahrenheit = celsius * 1.8f + 32;
        
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @return der momentane wert von celsius, gerundet.
     */
    public int getCelsius(){
        int i = Math.round(celsius);
        return i;
    }
    
    /**
     * 
     * @return der momentane wert von fahrenheit, gerundet.
     */
    public int getFahrenheit(){
        int i = Math.round(fahrenheit);
        return i;
    }
}
