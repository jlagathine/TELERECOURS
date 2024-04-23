package pdfGeneration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.alg.util.Pair;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.office.LocalOfficeManager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import lesFonctions.MesFonctions;

public class PdfCreationEtEcriture {

	static String pat;
	static String pat1;
	
	public static Object pdfCreate() throws IOException, DocumentException {
		//Texte du paragraphe
		String texte = "Lorem Ipsum\r"
				+ "\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"\r"
				+ "\"Il ny a personne qui naime la souffrance pour elle-même, qui ne la recherche et qui ne la veuille pour elle-même...\"\r\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc scelerisque dolor vitae feugiat rhoncus. Sed nec eleifend nisl. Nullam finibus, magna ut varius tincidunt, mauris lacus mollis nisi, sit amet consectetur augue ligula in sem. Ut lobortis id est ac euismod. Cras pretium neque justo, ac pulvinar diam suscipit eget. Nulla congue at arcu euismod congue. Nulla nisl erat, maximus et est eget, luctus suscipit libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Praesent elementum sem non lacus vulputate, aliquam molestie turpis finibus.\r\n"
				+ "\r\n"
				+ "Aliquam velit sem, blandit vitae nisl eget, iaculis rhoncus elit. Donec tincidunt imperdiet condimentum. Curabitur sit amet lacinia ligula. Ut ac tristique augue. Praesent nisl risus, sagittis id semper quis, molestie vitae dui. Mauris quis odio ipsum. Donec et scelerisque orci, eu consectetur lectus. Sed ultrices et lacus ut feugiat. Aliquam aliquam viverra urna, id finibus risus ornare vel. Quisque iaculis nisi vel bibendum consequat. Morbi consectetur gravida leo a tincidunt. Aenean lacus mi, vehicula sit amet ipsum vel, pretium dapibus nibh. Proin molestie non sem in hendrerit. Donec consequat nisi et varius fermentum. Maecenas vitae eros ipsum.\r\n"
				+ "\r\n"
				+ "Duis non ullamcorper justo, at pharetra neque. Curabitur quis interdum orci, vitae pharetra orci. Duis at odio convallis, tempus magna a, porttitor lectus. Nam in iaculis mauris, in dictum felis. Donec in ornare orci. Praesent cursus libero nec lorem posuere, ac fermentum velit semper. Donec tempus hendrerit ultricies. Praesent ullamcorper iaculis semper. Aliquam sagittis urna nunc, nec mollis sem condimentum id. Fusce sodales nulla non sem aliquam maximus. Nam id odio lobortis turpis rutrum viverra. Vivamus in finibus ligula. Duis euismod vitae mauris eu sollicitudin. Donec aliquet finibus sem, nec tempus velit faucibus et.\r\n"
				+ "\r\n"
				+ "Maecenas nisi orci, cursus a egestas id, vehicula quis orci. Donec consectetur congue tortor, sit amet efficitur mauris finibus ac. Vestibulum ac dui ultricies, auctor sem in, molestie est. Suspendisse ultricies imperdiet velit eget lacinia. Sed eu mauris nec dolor dictum molestie. Sed tincidunt risus in metus accumsan, sit amet vulputate odio aliquam. Curabitur condimentum eros tellus, vel vehicula ante scelerisque non.\r\n"
				+ "\r\n"
				+ "Suspendisse potenti. Phasellus mattis eu erat eget aliquet. Integer eu fringilla risus, ac ornare nisl. Fusce tincidunt mauris nibh, a venenatis est tempus at. Proin vel augue eget est venenatis cursus. Pellentesque posuere iaculis massa et luctus. In fermentum pellentesque urna, in tincidunt eros suscipit eu.";	
		
		//Générer un nombre de PDF 
		for(int i=1; i<250 ; i++) {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\TestTRC\\PJ"+MesFonctions.rewriteDigits(i, 4)+" pièces"+i+".pdf"));
		
		//Insertion du texte
		document.open();
		document.add(new Paragraph(texte)); 
		document.close();
		
		System.out.println("Création du pdf n°: "+i);
		}
		
		return null;
	}
	
	public static String convertionRTFtoPDF_codeRattachementTRC(String jur) throws InterruptedException, OfficeException, IOException {
		//Installation de LibreOffice
		OfficeManager officeManager
	       = LocalOfficeManager.builder()
    			   .install()
	               .officeHome("C:\\Program Files\\LibreOffice")
	               .build();
	   officeManager.start();
	
	   File inputFile = new File("C:\\temp\\RATACTRC.rtf");
	   File outputFile = new File("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
	
	   try {
	
	       System.out.println("officeManager.isRunning()="+officeManager.isRunning()+"....."+MesFonctions.extractCurrentHeure());
	   Thread.sleep(1000);
	   System.out.println("officeManager.isRunning()="+officeManager.isRunning()+"....."+MesFonctions.extractCurrentHeure());
	       JodConverter.convert(inputFile).to(outputFile).execute();
	   } finally {
	       // Stop the office process
	       OfficeUtils.stopQuietly(officeManager);
	   }
	   String code = "";
	   switch (jur) {
	case "TA":
		pat = "T\\d{2}\\-\\d{7}\\-\\d{9}"; 
		Pattern pattern = Pattern.compile(pat);
		PdfReader reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
		   int pages = reader.getNumberOfPages();
		   StringBuilder text = new StringBuilder();
		   String monText = "";
			 for (int i = 1; i <= pages; i++) {
				 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//			       System.out.println(monText); 
			       Matcher matcher = pattern.matcher(monText);
			       if(matcher.find()) {
						  System.out.println("I found the text "+matcher.group()+" starting at index "+    
					                 matcher.start()+" and ending at index "+matcher.end());
						  code = matcher.group().trim();
						    }
					       else {
					    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
					       }
					    }
			 reader.close();
			 Thread.sleep(150);
			 if(outputFile.delete()) {
				 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
			 }
			 else {
				 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
			 }
		break;
		
	case "CAA":
		pat = "C\\d{2} \\- \\d{7} \\- \\d{9}";
		pattern = Pattern.compile(pat);
		reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
		   pages = reader.getNumberOfPages();
		   text = new StringBuilder();
		   monText = "";
		   code = "";
			 for (int i = 1; i <= pages; i++) {
				 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//			       System.out.println(monText); 
			       Matcher matcher = pattern.matcher(monText);
			       if(matcher.find()) {
						  System.out.println("I found the text "+matcher.group()+" starting at index "+    
					                 matcher.start()+" and ending at index "+matcher.end());
						  code = matcher.group().trim();
						    }
					       else {
					    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
					       }
					    }
			 reader.close();
			 Thread.sleep(150);
			 if(outputFile.delete()) {
				 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
			 }
			 else {
				 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
			 }
		break;
		
	case "CTX":
		pat = "CE\\-\\d{6}\\-\\d{9}";
		pattern = Pattern.compile(pat);
		reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
		   pages = reader.getNumberOfPages();
		   text = new StringBuilder();
		   monText = "";
		   code = "";
			 for (int i = 1; i <= pages; i++) {
				 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//			       System.out.println(monText); 
			       Matcher matcher = pattern.matcher(monText);
			       if(matcher.find()) {
						  System.out.println("I found the text "+matcher.group()+" starting at index "+    
					                 matcher.start()+" and ending at index "+matcher.end());
						  code = matcher.group().trim();
						    }
					       else {
					    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
					       }
					    }
			 reader.close();
			 Thread.sleep(150);
			 if(outputFile.delete()) {
				 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
			 }
			 else {
				 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
			 }
		break;

	default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		break;
	}
		
		return code;
	}
	
	public static Pair<String, String> convertionRTFtoPDF_codeInscription_avocat(String jur) throws OfficeException, InterruptedException, IOException{
		//Installation de LibreOffice
				OfficeManager officeManager
			       = LocalOfficeManager.builder()
		    			   .install()
			               .officeHome("C:\\Program Files\\LibreOffice")
			               .build();
			   officeManager.start();
			
			   File inputFile = new File("C:\\temp\\INSCRTR.rtf");
			   File outputFile = new File("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
			
			   try {
			
			       System.out.println("officeManager.isRunning()="+officeManager.isRunning()+"....."+MesFonctions.extractCurrentHeure());
			   Thread.sleep(1000);
			   System.out.println("officeManager.isRunning()="+officeManager.isRunning()+"....."+MesFonctions.extractCurrentHeure());
			       JodConverter.convert(inputFile).to(outputFile).execute();
			   } finally {
			       // Stop the office process
			       OfficeUtils.stopQuietly(officeManager);
			   }
			   String code = "";
			   String password = "";
			   switch (jur) {
				case "TA":
					pat = "T\\d{2}\\-\\w{6}";
					pat1 = "votre mot de passe : \\w{6}";
					Pattern pattern = Pattern.compile(pat);
					Pattern pattern1 = Pattern.compile(pat1);
					PdfReader reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
					   int pages = reader.getNumberOfPages();
					   StringBuilder text = new StringBuilder();
					   String monText = "";
						 for (int i = 1; i <= pages; i++) {
							 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//						       System.out.println(monText); 
						       Matcher matcher = pattern.matcher(monText);
						       Matcher matcher1 = pattern1.matcher(monText);
						       if(matcher.find() && matcher1.find()) {
									  System.out.println("I found the text "+matcher.group()+" starting at index "+    
								                 matcher.start()+" and ending at index "+matcher.end());
									  System.out.println("I found the text "+matcher1.group()+" starting at index "+    
								                 matcher1.start()+" and ending at index "+matcher1.end());
									  code = matcher.group().trim();
									  String passw = matcher1.group().trim();
									  password = passw.split(" : ")[1];
									    }
								       else {
								    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
								       }
								    }
						 reader.close();
						 Thread.sleep(150);
						 if(outputFile.delete()) {
							 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
						 }
						 else {
							 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
						 }
					break;
					
				case "CAA":
					pat = "C\\d{2}\\-\\w{6}";
					pat1 = "votre mot de passe : \\w{6}";
					pattern = Pattern.compile(pat);
					pattern1 = Pattern.compile(pat1);
					reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
					   pages = reader.getNumberOfPages();
					   text = new StringBuilder();
					   monText = "";
						 for (int i = 1; i <= pages; i++) {
							 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//						       System.out.println(monText); 
						       Matcher matcher = pattern.matcher(monText);
						       Matcher matcher1 = pattern1.matcher(monText);
						       if(matcher.find() && matcher1.find()) {
									  System.out.println("I found the text "+matcher.group()+" starting at index "+    
								                 matcher.start()+" and ending at index "+matcher.end());
									  System.out.println("I found the text "+matcher1.group()+" starting at index "+    
								                 matcher1.start()+" and ending at index "+matcher1.end());
									  code = matcher.group().trim();
									  String passw = matcher1.group().trim();
									  password = passw.split(" : ")[1];
									    }
								       else {
								    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
								       }
								    }
						 reader.close();
						 Thread.sleep(150);
						 if(outputFile.delete()) {
							 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
						 }
						 else {
							 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
						 }
					break;
					
				case "CTX":
					pat = "CE\\-\\w{6}";
					pat1 = "mot de passe \\w{6}";
					pattern = Pattern.compile(pat);
					pattern1 = Pattern.compile(pat1);
					reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
					   pages = reader.getNumberOfPages();
					   text = new StringBuilder();
					   monText = "";
						 for (int i = 1; i <= pages; i++) {
							 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//						       System.out.println(monText); 
						       Matcher matcher = pattern.matcher(monText);
						       Matcher matcher1 = pattern1.matcher(monText);
						       if(matcher.find() && matcher1.find()) {
									  System.out.println("I found the text "+matcher.group()+" starting at index "+    
								                 matcher.start()+" and ending at index "+matcher.end());
									  System.out.println("I found the text "+matcher1.group()+" starting at index "+    
								                 matcher1.start()+" and ending at index "+matcher1.end());
									  code = matcher.group().trim();
									  String passw = matcher1.group().trim();
									  password = passw.split(" ")[3];
									    }
								       else {
								    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
								       }
								    }
						 reader.close();
						 Thread.sleep(150);
						 if(outputFile.delete()) {
							 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
						 }
						 else {
							 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
						 }
					break;

				default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					break;
				}
		
		return new Pair<String, String>(code, password);
	}
	
	public static Pair<String, String> convertionRTFtoPDF_codeInscription_adm(String jur) throws OfficeException, InterruptedException, IOException{
		//Installation de LibreOffice
				OfficeManager officeManager
			       = LocalOfficeManager.builder()
		    			   .install()
			               .officeHome("C:\\Program Files\\LibreOffice")
			               .build();
			   officeManager.start();
			
			   File inputFile = new File("C:\\temp\\COMIITR.rtf");
			   File outputFile = new File("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
			
			   try {
			
			       System.out.println("officeManager.isRunning()="+officeManager.isRunning()+"....."+MesFonctions.extractCurrentHeure());
			   Thread.sleep(1000);
			   System.out.println("officeManager.isRunning()="+officeManager.isRunning()+"....."+MesFonctions.extractCurrentHeure());
			       JodConverter.convert(inputFile).to(outputFile).execute();
			   } finally {
			       // Stop the office process
			       OfficeUtils.stopQuietly(officeManager);
			   }
			   String code = "";
			   String password = "";
			   switch (jur) {
				case "TA":
					pat = "T\\d{2}\\-\\w{6}";
					pat1 = "votre mot de passe : \\w{6}";
					Pattern pattern = Pattern.compile(pat);
					Pattern pattern1 = Pattern.compile(pat1);
					PdfReader reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
					   int pages = reader.getNumberOfPages();
					   StringBuilder text = new StringBuilder();
					   String monText = "";
						 for (int i = 1; i <= pages; i++) {
							 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//						       System.out.println(monText); 
						       Matcher matcher = pattern.matcher(monText);
						       Matcher matcher1 = pattern1.matcher(monText);
						       if(matcher.find() && matcher1.find()) {
									  System.out.println("I found the text "+matcher.group()+" starting at index "+    
								                 matcher.start()+" and ending at index "+matcher.end());
									  System.out.println("I found the text "+matcher1.group()+" starting at index "+    
								                 matcher1.start()+" and ending at index "+matcher1.end());
									  code = matcher.group().trim();
									  String passw = matcher1.group().trim();
									  password = passw.split(" : ")[1];
									    }
								       else {
								    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
								       }
								    }
						 reader.close();
						 Thread.sleep(150);
						 if(outputFile.delete()) {
							 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
						 }
						 else {
							 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
						 }
					break;
					
				case "CAA":
					pat = "C\\d{2}\\-\\w{6}";
					pat1 = "votre mot de passe \\w{6}";
					pattern = Pattern.compile(pat);
					pattern1 = Pattern.compile(pat1);
					reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
					   pages = reader.getNumberOfPages();
					   text = new StringBuilder();
					   monText = "";
						 for (int i = 1; i <= pages; i++) {
							 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//						       System.out.println(monText); 
						       Matcher matcher = pattern.matcher(monText);
						       Matcher matcher1 = pattern1.matcher(monText);
						       if(matcher.find() && matcher1.find()) {
									  System.out.println("I found the text "+matcher.group()+" starting at index "+    
								                 matcher.start()+" and ending at index "+matcher.end());
									  System.out.println("I found the text "+matcher1.group()+" starting at index "+    
								                 matcher1.start()+" and ending at index "+matcher1.end());
									  code = matcher.group().trim();
									  String passw = matcher1.group().trim();
									  password = passw.split(" ")[4];
									    }
								       else {
								    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
								       }
								    }
						 reader.close();
						 Thread.sleep(150);
						 if(outputFile.delete()) {
							 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
						 }
						 else {
							 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
						 }
					break;
					
				case "CTX":
					pat = "CE\\-\\w{6}";
					pat1 = "mot de passe \\w{6}";
					pattern = Pattern.compile(pat);
					pattern1 = Pattern.compile(pat1);
					reader = new PdfReader("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\rtf.pdf");
					   pages = reader.getNumberOfPages();
					   text = new StringBuilder();
					   monText = "";
						 for (int i = 1; i <= pages; i++) {
							 monText = text.append(PdfTextExtractor.getTextFromPage(reader, i)).toString();
//						       System.out.println(monText); 
						       Matcher matcher = pattern.matcher(monText);
						       Matcher matcher1 = pattern1.matcher(monText);
						       if(matcher.find() && matcher1.find()) {
									  System.out.println("I found the text "+matcher.group()+" starting at index "+    
								                 matcher.start()+" and ending at index "+matcher.end());
									  System.out.println("I found the text "+matcher1.group()+" starting at index "+    
								                 matcher1.start()+" and ending at index "+matcher1.end());
									  code = matcher.group().trim();
									  String passw = matcher1.group().trim();
									  password = passw.split(" ")[3];
									    }
								       else {
								    	   System.err.println("L'élément recherché n'a pas été trouvé....."+MesFonctions.extractCurrentHeure());
								       }
								    }
						 reader.close();
						 Thread.sleep(150);
						 if(outputFile.delete()) {
							 System.out.println("Le fichier "+outputFile.getName()+" a bien été supprimé......"+MesFonctions.extractCurrentHeure());
						 }
						 else {
							 System.err.println("Le fichier n'a pas été supprimé....."+MesFonctions.extractCurrentHeure());
						 }
					break;

				default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					break;
				}
		
		return new Pair<String, String>(code, password);
	}
	
}
