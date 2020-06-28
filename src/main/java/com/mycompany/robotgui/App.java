package com.mycompany.robotgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** App.java
 * 
 * Creates the RobotGUI app.
 * 
 * @author Ryan Veitenheimer
 */

public class App extends Application {

    private static Scene scene;

    /** Start()
     * 
     * Starts the app.
     * 
     * @param stage
     * @throws IOException 
     */
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    /** setRoot()
     * 
     * Sets root FXML for app.
     * 
     * @param fxml
     * @throws IOException 
     */
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /** LoadFXML()
     * 
     * Loads the FXML file.
     * 
     * @param fxml
     * @return
     * @throws IOException 
     */
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /** main()
     * 
     * Launches the app.
     * 
     * @param args 
     */
    
    public static void main(String[] args) {
        launch();
    }
}