import java.io.IOException;

public class Sout {

    public static void main(String[] args) throws IOException, InterruptedException {
        Sout sout = new Sout();
        sout.startEmulator();
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
        System.out.println("Starting the process builder");
        Thread.sleep(5000); // Wait for the emulator to start
        System.out.println("Process started");


//        // Replace "emulatorName" with the name of your emulator
//        String emulatorName = "Pixel_XL_API_30";
//        // Command to start the emulator
////        String command = "$" + "ANDROID_HOME/emulator/emulator -avd " + emulatorName;
//        String command = "export PATH=$PATH:$ANDROID_HOME/emulator && emulator -avd " + emulatorName;
//        // Start the emulator using the command
//        Process process = Runtime.getRuntime().exec(command);
//        Thread.sleep(5000); // Wait for the emulator to start
    }
}
