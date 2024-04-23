package pdf;

import java.io.IOException;

import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import pdfGeneration.PdfCreationEtEcriture;

public class CreationDePdf {
	
	@Test
	public void generationPdf() throws IOException, DocumentException {
		PdfCreationEtEcriture.pdfCreate();
	}

}
