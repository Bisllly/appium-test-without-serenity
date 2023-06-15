import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LaunchEmulator {
    private AndroidDriver driver;

    @Before
    public void setUp() throws IOException, InterruptedException {
        // Start the emulator
        startEmulator();
        // Start the Appium server
        startAppiumServer();
        // Connect the emulator to Appium
        connectEmulatorToAppium();
    }

    @After
    public void tearDown() {
        // Quit the driver and stop the Appium server
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testEmulatorLaunch() {
        // Perform your automation tasks using the driver
    }

    private void startEmulator() throws IOException, InterruptedException {

        // Replace "emulatorName" with the name of your emulator
        String emulatorName = "Pixel_XL_API_30";
        // Command to start the emulator
        String emulatorCommand = "emulator";
        // Set the environment variable for the emulator command
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", "export PATH=$PATH:$ANDROID_HOME/emulator && " + emulatorCommand + " -avd " + emulatorName);
        // Start the emulator using the command
        Process process = processBuilder.start();
        Thread.sleep(5000); // Wait for the emulator to start
    }

    private void startAppiumServer() throws IOException, InterruptedException {
        // Command to start the Appium server
        String command = "appium";
        // Start the Appium server using the command
        Process process = Runtime.getRuntime().exec(command);
        Thread.sleep(10000);
    }

    private void connectEmulatorToAppium() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomation2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        // Other desired capabilities can be added as needed

        // Create a new instance of AndroidDriver and connect to the emulator
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
    }
}
