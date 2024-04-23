package xmlFile;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyXmlFile {

	
	public static String createXMLRPVA(String file) throws IOException {
		FileOutputStream out = new FileOutputStream(".xml");
		String xml = "Telerecours><Avocat><CNBF>000001</CNBF><Nom>N000001</Nom><Prenom>P000001</Prenom><Civilite>0</Civilite><email>N000001@yopmail.com</email><RaisonSociale>N000001 AVOCAT</RaisonSociale><SIREN>100000000</SIREN><NIC>00012</NIC><FormeJuridique>CABI</FormeJuridique><Adresse1>1 rue des avocats</Adresse1><CodePostal>06000</CodePostal><Ville>NICE</Ville><Titulaire>1</Titulaire><Salarie>0</Salarie><Barreau>NICE</Barreau><CreateTimestamp>20090723051613Z</CreateTimestamp><ModifyTimestamp>20210618090956Z</ModifyTimestamp></Avocat>";
		
		
		
		return null;
	}
}
