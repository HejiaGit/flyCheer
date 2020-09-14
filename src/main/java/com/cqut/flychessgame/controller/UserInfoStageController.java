package com.cqut.flychessgame.controller;

import com.cqut.flychessgame.FlychessgameApplication;
import com.cqut.flychessgame.domain.database.PlayInfo;
import com.cqut.flychessgame.domain.database.UserInfo;
import com.cqut.flychessgame.service.PlayInfoService;
import com.cqut.flychessgame.view.PlayStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Create with IntelliJ IDEA.
 * 用户详细信息面板
 * @author hj
 */
@FXMLController
public class UserInfoStageController implements Initializable {

    public static Long userId =0L;

    @FXML
    private TextField nickName;

    @FXML
    private TextField oPassword;

    @FXML
    private TextField nPassword;

    @FXML
    private ToggleGroup sex;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton other;

    @FXML
    private TextArea remark;

    @Autowired
    PlayInfoService playInfoService;

    @FXML
    public void confirm(ActionEvent event){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(this.userId);
        userInfo.setNickname(nickName.getText().trim());
        userInfo.setPassword(oPassword.getText().trim());
        if(other.isSelected()){
            userInfo.setSex("o");
        } else if(female.isSelected()){
            userInfo.setSex("f");
        } else if(male.isSelected()) {
            userInfo.setSex("m");
        }
        userInfo.setRemark(remark.getText().trim());
        int result = playInfoService.changeUserInfo(userInfo,nPassword.getText().trim());
        //提示信息
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setHeaderText(null);
        if(result == -1){
            alert.setContentText("原密码错误，请确认后再修改！");
        } else {
            alert.setContentText("修改信息成功！");
        }
        alert.showAndWait();
        FlychessgameApplication.getStage().close();
        FlychessgameApplication.showView(PlayStageView.class);
    }

    @FXML
    public void reset(ActionEvent event){
        nickName.setText(null);
        male.isSelected();
        remark.setText(null);
    }

    /**
     * 信息初始化填充
     */
    private void fillInfo(){
        UserInfo userInfo = playInfoService.getUserInfo(this.userId);
        if (userInfo.getNickname() != null){
            nickName.setText(userInfo.getNickname());
        }
        if(userInfo.getSex().equals("f")){
            female.isSelected();
        }else if(userInfo.getSex().equals("m")){
            male.isSelected();
        } else{
            other.isSelected();
        }
        if(userInfo.getRemark() != null){
           remark.setText(userInfo.getRemark());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillInfo();
    }
}
