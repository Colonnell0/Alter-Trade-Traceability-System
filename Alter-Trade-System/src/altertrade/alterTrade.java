package altertrade;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class alterTrade extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane mainPane = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("Alter Trade Traceability System");
        primaryStage.getIcons().add(new Image("/altertrade/assets/images/icon/alter_trade_icon.png"));
        primaryStage.setMinWidth(1080);
        primaryStage.setMinHeight(720);
        primaryStage.setScene(scene);
        primaryStage.show();
        alterTrade.primaryStage = primaryStage;

    }

    public static void addBiodata(String source, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(alterTrade.class.getResource(source));
        AnchorPane addModalBiodata = loader.load();

        Stage addDialogBiodata = new Stage();
        addDialogBiodata.setTitle(title);
        addDialogBiodata.initModality(Modality.WINDOW_MODAL);
        addDialogBiodata.initOwner(primaryStage);
        Scene scene = new Scene(addModalBiodata);
        addDialogBiodata.setScene(scene);
        addDialogBiodata.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
