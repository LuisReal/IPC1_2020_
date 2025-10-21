
package proyecto1;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;//para las fuentes de la letra

public class Reportes {
    public void GenerarPDF(String ruta){
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        
        document.addPage(page);
        try{
            PDPageContentStream cs = new PDPageContentStream(document, page);
            cs.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 14);
            cs.beginText(); //abre el documento para empezar a trabajar
            cs.newLineAtOffset(100, 700); //indica las coordenadas de donde debe empezar a escribir en la pagina
            cs.showText("Esto es un document pdf creado con PDFBOX");
            cs.endText();
            cs.close();
            
            document.save(ruta);
            document.close();
            
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
}
