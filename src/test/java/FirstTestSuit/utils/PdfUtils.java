package FirstTestSuit.utils;

// src/test/utils/PdfUtils.java


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfUtils {

    // Checks if expected text is in PDF
    public static boolean pdfContainsText(String pdfPath, String expectedText) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfPath));
        String text = new PDFTextStripper().getText(document);
        document.close();
        return text.contains(expectedText);
    }

    // Returns entire text for debugging
    public static String getPdfText(String pdfPath) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfPath));
        String text = new PDFTextStripper().getText(document);
        document.close();
        return text;
    }
}
