package com.cqut.flychessgame.controller;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with IntelliJ IDEA.
 * 游戏控制界面
 * @author hj
 */
@RestController
public class GameController extends AbstractJavaFxApplicationSupport {

    public void stageShow(){
        try {
            AnchorPane loginStage = FXMLLoader.load(getClass().getResource("../../../../../resources/ui/LoginStage.fxml"));
            Scene newScene = new Scene(loginStage);
            Stage stage = new Stage();
            stage.setTitle("飞行棋");
            stage.setScene(newScene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
