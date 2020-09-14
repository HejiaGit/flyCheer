package com.cqut.flychessgame.controller;

import com.cqut.flychessgame.FlychessgameApplication;
import com.cqut.flychessgame.domain.database.UserInfo;
import com.cqut.flychessgame.service.LoginService;
import com.cqut.flychessgame.view.LoginStageView;
import com.cqut.flychessgame.view.PlayStageView;
import com.sun.java.swing.plaf.windows.WindowsButtonUI;
import com.sun.java.swing.plaf.windows.WindowsRootPaneUI;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Create with IntelliJ IDEA.
 * 控制用户登录
 * @author hj
 */
@FXMLController
public class LoginStageController implements Initializable {
    @FXML
    private TextField userName;

    @FXML
    private PasswordField passWord;

    @FXML
    private Button register;

    @FXML
    private Button login;

    @Autowired
    LoginService loginService;

    private Long id;
    private String password = null;

    /**
     * 注册信息
     *
     * @param event 监听按钮
     */
    @FXML
    public void onRegister(ActionEvent event) {
        if (getInfo()) {
            UserInfo loginInfo = new UserInfo();
            if(loginService.regisUser(id,password)){
                showWarning("注册信息成功！");
                PlayStageController.userId = id;
                FlychessgameApplication.getStage().close();
//                FlychessgameApplication.showView();
                FlychessgameApplication.showView(PlayStageView.class);
            }else {
                showWarning("ID已存在，请直接登录！");
            }
        } else {
            showWarning("注册失败，请重试！");
        }
    }

    /**
     * 登录
     * @param event 监听按钮
     */
    @FXML
    public void onLogin(ActionEvent event) {
        if (getInfo()) {
            int sign = loginService.loginUser(id,password);
            if( sign == 1){
                PlayStageController.userId = id;
                FlychessgameApplication.getStage().close();
                FlychessgameApplication.showView(PlayStageView.class);
            } else if(sign == 0) {
                showWarning("密码有误，请重新输入！");
                passWord.setText(null);
            } else if(sign == -1) {
                showWarning("ID不存在，请重新输入！");
                userName.setText(null);
                passWord.setText(null);
            }
        }
    }

    private boolean getInfo() {
        try {
            String name = userName.getText().trim();
            password = passWord.getText().trim();
            if (name.isEmpty()) {
                showWarning("请输入您的用户ID！");
                return false;
            } else {
                try {
                    id = Long.parseLong(name);
                    if (name.length() < 8 || name.length() > 12) {
                        showWarning("请输入长度在8-12位之间的ID");
                        return false;
                    }
                } catch (Exception e) {
                    showWarning("ID不可包含数值以外的符号！");
                    return false;
                }
            }
            if (passWord == null || password.isEmpty()) {
                showWarning("请输入有效密码！");
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            showWarning("请输入您的信息！");
            return false;
        }
    }

    /**
     * @param s 显示提示信息
     */
    private void showWarning(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
