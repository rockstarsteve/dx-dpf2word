package com.dx.controller;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/5
 */
public class MainController implements Initializable {

    @FXML
    public TextField pdfInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        pdfInput.setOnDragDone(new EventHandler<DragEvent>() {
//            @Override
//            public void handle(DragEvent event) {
//                Dragboard dragboard = event.getDragboard();
//                if (dragboard.hasFiles()) {
//                    File file = dragboard.getFiles().get(0);
//                    if (file.getAbsolutePath().endsWith(".txt")) { //用来过滤拖入类型
//                        event.acceptTransferModes(TransferMode.COPY);//接受拖入文件
//                    }
//                }
//            }
//        });
    }

    /**
     * 生成word
     *
     * @param actionEvent
     */
    public void toWord(ActionEvent actionEvent) throws IOException {
        String pdfPath = pdfInput.getText();
        if (pdfPath == null || pdfPath.equals("")) {
            AlertUtil.AlertError("请选择pdf文件位置");
            return;
        }
        File pdfFile = new File(pdfPath);
        if (pdfFile.exists() && pdfPath.lastIndexOf(".pdf") == (pdfPath.length() - 4)) {
            String pdfName = pdfFile.getName();
            String fileName = pdfName.substring(0, pdfName.length() - 4);
            String docPath = pdfPath.substring(0, pdfName.length() - 4) + ".docx";
            //pdf转换word
            PdfDocument pdfDocument = new PdfDocument(pdfPath);
            pdfDocument.saveToFile(docPath, FileFormat.DOCX);
            pdfDocument.close();
            //重新读取文档去除第一行
            InputStream isDoc = new FileInputStream(docPath);
            XWPFDocument document = new XWPFDocument(isDoc);
            document.removeBodyElement(0);
            AlertUtil.AlertInfo("生成成功：同目录下生成了" + fileName + ".docx" + "文档！");
        } else {
            AlertUtil.AlertInfo("选择的文件错误，请检查！");
        }
    }


    public void choosePdfFileClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择要转换的pdf文件");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );
        File selectedDirectory = fileChooser.showOpenDialog(null);
        Button button = (Button) event.getSource();
        if (selectedDirectory != null && button != null) {
            pdfInput.setText(selectedDirectory.getPath());
        }
    }
}
