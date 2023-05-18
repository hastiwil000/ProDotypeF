import gnu.jpdf.PDFJob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main extends JFrame implements ActionListener
{
    private static String outputPdfFile = "C:/Users/hastiwil000/Downloads/Bloop.pdf";
        private static String sampleImageFile;
    private static boolean noWindow;
    private JPanel pane = new JPanel();
    private Dimension documentDimension;
    private int currentPage;
    private PDFJob job;
    private boolean pdfDocumentAlreadyDone;
    public static void main(String[] args)
    {
        System.out.println("Check 1");

        File file = null;
        FileOutputStream fileOutputStream = null;
        try {
            file = new File(outputPdfFile);
            fileOutputStream = new FileOutputStream(file);
            System.out.println("Check 2");
        }
        catch (Exception e) {
            System.err.println("Error!! - Invalid output file path: " + outputPdfFile);
            System.exit(1);
        }

        PDFJob job = new PDFJob(fileOutputStream);

        System.out.println("Check 3");

        Graphics pdfGraphics = job.getGraphics();

        for(int i = 0; i < 615; i++)
        {
            for(int j = 0; j < 100; j++)
            {
                pdfGraphics.setColor(new Color(Math.min(i,255),Math.min(j,255),255));
                pdfGraphics.drawLine(0, 0, i, j);
            }
        }

        pdfGraphics.dispose();
        //pdfGraphics = job.getGraphics();
        //pdfGraphics.dispose();



        job.end();
        System.out.println("Check 4");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}