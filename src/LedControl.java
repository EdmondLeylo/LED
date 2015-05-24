import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LedControl {
	
	final private GpioController gpio;
	
	public LedControl(){
		gpio = GpioFactory.getInstance();
	}
	public void turnLED(int sec){
        
        // creating the pin with parameter PinState.HIGH
        // will instantly power up the pin
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "PinLED", PinState.HIGH);
        System.out.println("light is: ON");
        
        // wait sec seconds
        try {
			Thread.sleep(sec *1000);
			pin.low();
			gpio.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) throws InterruptedException {
    	LedControl led = new LedControl();
    	led.turnLED(5);
    }
}
