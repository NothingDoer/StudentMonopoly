package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenSettings {
    public static Stage primaryStage;
    public static int screenWidth = 1920;
    public static int screenHeight = 1080;
    public static boolean isFullScreen = false;
    public static double scale=1;

    public static void changeScale(double scaleChange)
    {
        scale+=scaleChange;
        if(scale>1)scale=1;
        if(scale<0.2)scale=0.2;
    }
    public static void initializeScreen(){
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(isFullScreen);
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHeight);
    }
    public static void resize(Scene scene)
    {
        scene.getRoot().setScaleX(scale);
        scene.getRoot().setScaleY(scale);
    }
}
