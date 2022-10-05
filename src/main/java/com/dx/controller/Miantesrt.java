package com.dx.controller;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/5
 */
public class Miantesrt {
    public static void main(String[] args) {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile("E:\\研究生报名-姚俭.pdf");
        pdfDocument.saveToFile("E:\\test.docx", FileFormat.DOCX);
        pdfDocument.close();
    }

}
