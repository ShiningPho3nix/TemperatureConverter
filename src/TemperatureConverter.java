import java.util.Observable;

/**
 * TODO Kommentare schreiben
 * 
 * @author Steffen Dworsky, u.a.
 *
 */
public class TemperatureConverter extends Observable
{
	private float mFahrenheit = 32;
	private float mCelsius = 0;

	public float getFahrenheit()
	{
		return mFahrenheit;
	}

	public float getCelsius()
	{
		return mCelsius;
	}
	
	public double calculateFahrenheit(int celsius){
		mCelsius = celsius;
		return mFahrenheit = celsius * 1.8f + 32;
	}

	public void setFahrenheit(float fahrenheit)
	{
		mFahrenheit = fahrenheit;
		mCelsius = (fahrenheit - 32) * (5f / 9f);
		setChanged();
		notifyObservers(this);
	}

	public void setCelsius(float celsius)
	{
		mCelsius = celsius;
		mFahrenheit = celsius * 1.8f + 32;
		setChanged();
		notifyObservers(this);
	}
}
