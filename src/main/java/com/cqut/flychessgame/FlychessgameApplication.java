package com.cqut.flychessgame;

import com.cqut.flychessgame.controller.GameController;
import com.cqut.flychessgame.controller.LoginStageController;
import com.cqut.flychessgame.view.LoginStageView;
import com.cqut.flychessgame.view.PlayStageView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.cqut.flychessgame.mapper")
public class FlychessgameApplication extends AbstractJavaFxApplicationSupport {

    @Autowired
    LoginStageController loginStageController;

    public static void main(String[] args) {
//        SpringApplication.run(FlychessgameApplication.class, args);
        launch(FlychessgameApplication.class, LoginStageView.class, args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("飞行棋游戏...");
        super.start(primaryStage);
    }

}
