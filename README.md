# Metric Converter App

This JavaFX application converts measurements from meters to feet. The app requires OpenJDK and JavaFX to run, You can clone it and check it out. 
Below are the necessary installations and instructions to compile and run the program. 

## Prerequisites
Before running the program, make sure you have the following installed:
- OpenJDK (Java Development Kit)
- JavaFX

### Installation Steps
1. **OpenJDK Installation:**
   - Visit the OpenJDK [website](https://openjdk.java.net/) or follow your operating system's specific instructions to download and install OpenJDK.

2. **JavaFX Installation:**
   - Download JavaFX SDK from the official [JavaFX website](https://openjfx.io/).
   - Follow the installation instructions provided for your operating system to set up JavaFX.

## How to Compile and Run the App
Ensure that you have the necessary files for the Metric Converter App in a directory. Open your terminal or command prompt and navigate to that directory.

### Compilation Command
To compile the application, use the following command:

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml Main.java
```
Replace `/path/to/javafx-sdk/lib` with the actual path to your JavaFX lib directory.

### Running the App
Once the program is compiled, execute the app using this command:

```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml Main
```
Again, replace `/path/to/javafx-sdk/lib` with the actual path to your JavaFX lib directory.

## Usage
- Launch the app.
- Enter a value in meters that you want to convert to feet.
- Press the 'Convert' button to see the equivalent value in feet.

## Files Included
- `Main.java`: Java source code file containing the Metric Converter App.

## Support
For any issues or inquiries, please contact [vmabhuleka@gmail.com].

Feel free to modify and enhance the app to suit your needs!

---
