package com.dx.controller;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Description: 弹窗工具类
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/5
 */
public class AlertUtil {

    private static Stage stage = new Stage();

    public static void AlertError(String info) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        showAlert(info, errorAlert);
    }

    public static void AlertInfo(String info) {
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        showAlert(info, errorAlert);
    }

    private static void showAlert(String info, Alert alter) {
        alter.setHeaderText(null);
        alter.setContentText(info);
        alter.getDialogPane().setStyle("-fx-font-size: 16");
        stage = (Stage) alter.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(AlertUtil.class.getResourceAsStream("/images/360logo.png")));
        alter.show();
    }
}
