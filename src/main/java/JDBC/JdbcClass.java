package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lesFonctions.MesFonctions;

public class JdbcClass {
	
	static Connection con;
	static Connection con1;
	static Connection con2;
	static Statement stmt;
	static Statement stmt1;
	static ResultSet rs;
	static ResultSet rs1;
	static String query;
	static int RPVA_AVOCAT_ID;
	static String sql;
	static List<Integer> valeur = new ArrayList<Integer>();
	static float DA_TIMING;
	static String RPVA_AVOCAT_SIREN; 
	static String RPVA_AVOCAT_NIC;
	static String RPVA_AVOCAT_ADD1;
	static String RPVA_AVOCAT_VILLE;
	static String RPVA_AVOCAT_CP;
	static String RPVA_AVOCAT_TITULAIRE;
	static String RPVA_AVOCAT_SALARIE;
	static String RPVA_AVOCAT_BARREAU;
	static String RPVA_AVOCAT_CNBF;
	static int ANJ_AEXID;
	static Random rand = new Random();
	static String CP;
	static String URL;
	static String env;
//	static String navigatr = "chrome";
//	static WebDriver driver = navigateur.choixBrowser(navigatr);
	
	
	//TELERECOURS
	public static boolean conDBTR (String name, String mdp, String env) throws SQLException {
		//URL de la base de données
		String URL = "jdbc:oracle:thin:"+name+"/"+mdp+"@192.168.5.91:1530/mtl1_trr";//URL ( connect via SID ): jdbc:oracle:thin:"User"/"password"@{HOST}[:{PORT}]:{DB}
//		String URL = "jdbc:oracle:thin:"+name+"/"+mdp+"@192.168.5.90:1530/ric1_trr";
		String URL1 = "jdbc:oracle:thin:"+name+"/"+mdp+"@192.168.5.93:1530/TRINT1";
		
		//Chargement de la classe de driver
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());//java Driver Class: oracle.jdbc.OracleDriver
		
		//Création de l'objet de statement
			switch (env) {
			case "rec":
				try {
				con = DriverManager.getConnection(URL);
				boolean verif = con != null;
					if(verif) {
					System.out.println("Connecté à BDD RECETTE TELERECOURS");
					}
				}catch(Exception e) {
					System.out.println("Non connecté à BDD TELERECOURS");
					e.printStackTrace();
				}
				break;
				
			case "int1":
				try {
				con = DriverManager.getConnection(URL1);
				boolean verif = con != null;
					if(verif) {
					System.out.println("Connecté à BDD INT1 TELERECOURS");
					}
				}catch(Exception e) {
					System.out.println("Non connecté à BDD TELERECOURS");
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
		
		return false;
		
	}
	
	//SKIPPER
	public static boolean conDBSK (String SID) throws SQLException {
		//URL de la base de données
		String URL = "jdbc:oracle:thin:lb/lb@192.168.13.134:1526/"+SID;//URL ( connect via SID ): jdbc:oracle:thin:"User"/"password"@{HOST}[:{PORT}]:{DB}
		
		//Chargement de la classe de driver
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());//java Driver Class: oracle.jdbc.OracleDriver
		
		//Création de l'objet de statement
		try {
		con1 = DriverManager.getConnection(URL);
		boolean verif = con1 != null;
		if (verif==true) {
		    System.out.println("Connecté à BDD RECETTE SKIPPER");
		    return verif;
			}
		}catch(Exception e) {
			System.out.println("Non connecté à BDD RECETTE SKIPPER");
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	//TRC
	public static boolean conDBTRC (String env) throws Throwable {
		//URL de la base de données
		
//		boolean verif = driver.getCurrentUrl().contains("int1");
//		System.out.println(verif);
		
//		if(verif==true) {
//			URL = "jdbc:mysql://I1VUApTrcWeb001:3306/portail-citoyen-integration";
//			System.out.println("jdbc:mysql://I1VUApTrcWeb001:3306/portail-citoyen-integration");
//		}
//		else {
//			URL = "jdbc:mysql://RcVUApTrcWeb001:3306/portail-citoyen-recette";
//			System.out.println("jdbc:mysql://RcVUApTrcWeb001:3306/portail-citoyen-recette");
//		}
		switch (env) {
		case "int1":
			URL = "jdbc:mysql://I1VUApTrcWeb001:3306/portail-citoyen-integration";
			break;
			
		case "rec":
			URL = "jdbc:mysql://RcVUApTrcWeb001:3306/portail-citoyen-recette";
			break;

		default: System.err.println("cet environnement n'est pas connu");
			break;
		}
		
		//Chargement de la classe de driver
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());//java Driver Class: oracle.jdbc.OracleDriver
		
		//Création de l'objet de statement
		try {
		con2 = DriverManager.getConnection(URL, "trc", "4J773I+;F8rO0Kp63T265:k04%vWSn");
		boolean verif = con2 != null;
		if (verif) {
			verif = URL.contains("integration");
			if(verif) {
				System.out.println("Connecté à BDD INTEGRATION TRC");
			}else {
				System.out.println("Connecté à BDD RECETTE TRC");	
			}
		    return verif;
			}
		}catch(Exception e) {
			System.out.println("Non connecté à BDD TRC");
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static Integer sqlQuery () throws SQLException {
		//Création de la méthode statement (méthode pour exécuter les requêtes)
		stmt = con.createStatement();
		
		//Requête SQL
		query = "SELECT RA.RPVA_AVOCAT_ID, RA.RPVA_AVOCAT_CNBF, RA.RPVA_AVOCAT_NOM, RA.RPVA_AVOCAT_NIC, RA.RPVA_AVOCAT_SIREN\r\n"
				+ "FROM RPVA_AVOCAT RA, RPVA_STRUCT R\r\n"
				+ "WHERE RA.RPVA_AVOCAT_ID = R.RPVA_AVOCAT_ID \r\n"
				+ "AND RA.RPVA_AVOCAT_ID = 529196";
		try {
			//Exécution de la requête de type SELECT -> executeQuery
			rs = stmt.executeQuery(query);
			//Affichage des résultats
			while(rs.next()) {
			RPVA_AVOCAT_ID = rs.getInt("RPVA_AVOCAT_ID");
			System.out.println(RPVA_AVOCAT_ID);
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			//Fermeture de l'objet d'exécution
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return RPVA_AVOCAT_ID;
	}
		
	public static String deletUtiPref (Integer RPVA_AVOCAT_ID, Integer ANJ_AEXID) throws SQLException {
		stmt = con.createStatement();
		query = "DELETE \r\n"
				+ "PREFERENCES_UTILISATEURS\r\n"
				+ "WHERE PU_UTI_ID = \r\n"
				+ "    (SELECT PU_UTI_ID FROM PREFERENCES_UTILISATEURS PU\r\n"
				+ "        INNER JOIN UTI_EXT_TR UE ON UE.UTI_EXT_TR_ID = PU.PU_UTI_ID\r\n"
				+ "            WHERE UE.UTI_EXT_TR_ID =\r\n"
				+ "                (SELECT UTI_EXT_TR_ID FROM UTI_EXT_TR \r\n"
				+ "                    WHERE UTI_EXT_RPVA_AVOCAT_ID ="+RPVA_AVOCAT_ID+"\r\n"
				+ "                    AND ANJ_AEXID = "+ANJ_AEXID+"))";
		
		sql = "DELETE  \r\n"
				+ "UTI_EXT_TR \r\n"
				+ "WHERE UTI_EXT_RPVA_AVOCAT_ID ="+RPVA_AVOCAT_ID+"\r\n"
				+ "AND ETATCOMPTE = 'Actif'\r\n"
				+ "AND ANJ_AEXID = "+ANJ_AEXID+"";
		
		try {
			//Exécution de la requête qui modifie les données d'une table
			stmt.executeUpdate(query);
			System.out.println("Record deleted successfully");
//			con.commit();//Présence de l'autocomit commande inutile
			stmt.executeUpdate(sql);
			System.out.println("Record deleted successfully");
//			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	 public static String changeCabinetRpva() throws SQLException {
		 RPVA_AVOCAT_SIREN = "330000004"; 
		 RPVA_AVOCAT_NIC = "00148";
		 RPVA_AVOCAT_ADD1 = "61 Rue Sainte Marie";
		 RPVA_AVOCAT_VILLE = "MARSEILLE";
		 RPVA_AVOCAT_CP = "13000";
		 RPVA_AVOCAT_TITULAIRE = "1";
		 RPVA_AVOCAT_SALARIE = "1";
		 RPVA_AVOCAT_BARREAU = "MARSEILLE";
		 RPVA_AVOCAT_CNBF = "000002";
				 
		 stmt = con.createStatement();
		 
		 query = "UPDATE RPVA_AVOCAT R\r\n"
		 		+ "SET R.RPVA_AVOCAT_SIREN = '"+RPVA_AVOCAT_SIREN+"', \r\n"
		 		+ "R.RPVA_AVOCAT_NIC = '"+RPVA_AVOCAT_NIC+"',\r\n"
		 		+ "R.RPVA_AVOCAT_ADD1 = '"+RPVA_AVOCAT_ADD1+"',\r\n"
		 		+ "R.RPVA_AVOCAT_VILLE = '"+RPVA_AVOCAT_VILLE+"',\r\n"
		 		+ "R.RPVA_AVOCAT_CP = '"+RPVA_AVOCAT_CP+"',\r\n"
		 		+ "R.RPVA_AVOCAT_TITULAIRE = '"+RPVA_AVOCAT_TITULAIRE+"',\r\n"
		 		+ "R.RPVA_AVOCAT_SALARIE = '"+RPVA_AVOCAT_SALARIE+"',\r\n"
		 		+ "R.RPVA_AVOCAT_BARREAU = '"+RPVA_AVOCAT_BARREAU+"'\r\n"
		 		+ "WHERE R.RPVA_AVOCAT_CNBF = '"+RPVA_AVOCAT_CNBF+"'";
		 try {
			 stmt.executeUpdate(query);
			 System.out.println("Les informations ont été mises à jour");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return null;
	 }
	 
	 public static String inscriptCabinet() throws SQLException {
		 int min = 300000000;
		 int max = 399999999;
		 int siren = rand.nextInt((max - min)+1) + min;
		 RPVA_AVOCAT_SIREN = Integer.toString(siren);
		 min = 00100;
		 max = 00200;
		 int nic = rand.nextInt((max - min)+1) + min;
		 RPVA_AVOCAT_NIC = String.format("%05d", nic);
		 RPVA_AVOCAT_ADD1 = "61 Rue Saint Honoré";
		 RPVA_AVOCAT_VILLE = "MARSEILLE";
		 RPVA_AVOCAT_CP = "13000";
		 RPVA_AVOCAT_TITULAIRE = "1";
		 RPVA_AVOCAT_SALARIE = "1";
		 RPVA_AVOCAT_BARREAU = "MARSEILLE";
		 RPVA_AVOCAT_CNBF = "000002";
		 
		 stmt = con.createStatement();
		 
		 query = "UPDATE RPVA_AVOCAT R\r\n"
		 		+ "SET R.RPVA_AVOCAT_SIREN = '"+RPVA_AVOCAT_SIREN+"', \r\n"
		 		+ "R.RPVA_AVOCAT_NIC = '"+RPVA_AVOCAT_NIC+"',\r\n"
		 		+ "R.RPVA_AVOCAT_ADD1 = '"+RPVA_AVOCAT_ADD1+"',\r\n"
		 		+ "R.RPVA_AVOCAT_VILLE = '"+RPVA_AVOCAT_VILLE+"',\r\n"
		 		+ "R.RPVA_AVOCAT_CP = '"+RPVA_AVOCAT_CP+"',\r\n"
		 		+ "R.RPVA_AVOCAT_TITULAIRE = '"+RPVA_AVOCAT_TITULAIRE+"',\r\n"
		 		+ "R.RPVA_AVOCAT_SALARIE = '"+RPVA_AVOCAT_SALARIE+"',\r\n"
		 		+ "R.RPVA_AVOCAT_BARREAU = '"+RPVA_AVOCAT_BARREAU+"'\r\n"
		 		+ "WHERE R.RPVA_AVOCAT_CNBF = '"+RPVA_AVOCAT_CNBF+"'";
		 try {
			 stmt.executeUpdate(query);
			 System.out.println("Les informations ont été mises à jour");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return null;
	 }
	 
	 public static String cleanDataInscript(Integer ANJ_AEXID) throws SQLException {
		 RPVA_AVOCAT_ID = 529196;
		 
		 String upd = "UPDATE ANN_TR A\r\n"
		 		+ "SET A.ACTIF = 0\r\n"
		 		+ "WHERE A.ANJ_AEXID = (SELECT U.ANJ_AEXID\r\n"
		 		+ "                        FROM UTI_EXT_TR U\r\n"
		 		+ "                        WHERE U.UTI_EXT_RPVA_AVOCAT_ID = "+RPVA_AVOCAT_ID+"\r\n"
		 		+ "                        AND U.UTI_EXT_TR_ID = (SELECT MAX(U.UTI_EXT_TR_ID) FROM UTI_EXT_TR U))";
		 
		 String dlt1 = "DELETE \r\n"
		 		+ "PREFERENCES_UTILISATEURS P\r\n"
		 		+ "WHERE P.PU_UTI_ID = (SELECT U.UTI_EXT_TR_ID\r\n"
		 		+ "                        FROM UTI_EXT_TR U\r\n"
		 		+ "                        WHERE U.UTI_EXT_RPVA_AVOCAT_ID = "+RPVA_AVOCAT_ID+"\r\n"
		 		+ "                        AND U.UTI_EXT_TR_ID = (SELECT MAX(U.UTI_EXT_TR_ID) FROM UTI_EXT_TR U))";
		 
		 String dlt2 = "DELETE\r\n"
		 		+ "UTI_EXT_TR U \r\n"
		 		+ "WHERE U.ANJ_AEXID = (SELECT U.ANJ_AEXID\r\n"
		 		+ "                        FROM UTI_EXT_TR U\r\n"
		 		+ "                        WHERE U.UTI_EXT_RPVA_AVOCAT_ID = "+RPVA_AVOCAT_ID+"\r\n"
		 		+ "                        AND U.UTI_EXT_TR_ID = (SELECT MAX(U.UTI_EXT_TR_ID) FROM UTI_EXT_TR U))";
		 String dlt3 = "DELETE\r\n"
		 		+ "ANN_TR A\r\n"
		 		+ "WHERE A.ANJ_AEXID = "+ANJ_AEXID+"";

		 stmt = con.createStatement();
		 
		 try {
			 stmt.executeUpdate(upd);
			 System.out.println("Les informations ont été mises à jour");
			 stmt.executeUpdate(dlt1);
			 System.out.println("Les informations ont été mises à jour");
			 stmt.executeUpdate(dlt2);
			 System.out.println("Les informations ont été mises à jour");
			 stmt.executeUpdate(dlt3);
			 System.out.println("Les informations ont été mises à jour");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 return null;
	 }
	 
	 public static Integer AEXID (Integer RPVA_AVOCAT_ID) throws SQLException {
		String sql = "SELECT U.ANJ_AEXID\r\n"
		 		+ "FROM UTI_EXT_TR U\r\n"
		 		+ "WHERE U.UTI_EXT_RPVA_AVOCAT_ID = "+RPVA_AVOCAT_ID+" \r\n"
		 		+ "AND U.UTI_EXT_TR_ID = (SELECT MAX(U.UTI_EXT_TR_ID) FROM UTI_EXT_TR U)";
		
		stmt = con.createStatement();
		try {rs = stmt.executeQuery(sql);
		while(rs.next()){
			ANJ_AEXID = rs.getInt("ANJ_AEXID");
			System.out.println(ANJ_AEXID);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return ANJ_AEXID; 
	 }
	 
	 public static String mdpValidite(int duree, String nom, int ANJ_AEXID) throws SQLException {
		 //Création de la méthode d'exécution
		 stmt = con.createStatement();
		 
		 //Requête SQL
		 sql = "UPDATE UTI_EXT_TR\r\n"
		 		+ "SET DATE_CREATION_MDP = (SYSDATE - "+duree+")\r\n"
		 		+ "WHERE NOM ='"+nom+"'"
 				+ "AND ANJ_AEXID = "+ANJ_AEXID+"";
		 
		 
		 try {
			 stmt.executeUpdate(sql);
		System.out.println("Données mises à jour");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 //Vérification des modifications
		 sql = "SELECT U.DATE_CREATION_MDP\r\n"
		 		+ "FROM UTI_EXT_TR U\r\n"
		 		+ "where U.NOM = '"+nom+"'\r\n"
		 		+ "AND ANJ_AEXID = "+ANJ_AEXID+"";
		 try {
			 rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				System.out.println("la nouvelle date de création du mdp = date d'aujourd'hui - "+duree+ "jrs = "+rs.getDate(1)); 
			 }	
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 try {
			stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return null;
	 }
	 
	 public static float telechargement (String NUM_DOSSIER) throws SQLException, Throwable {
//		 Thread.sleep(1000);
		 //Requete sql statut
			String sql = "SELECT D.DAR_ID, D.DAR_PROGRESS, D.DAR_STATUS, ROUND((D.DAR_DURATION/60), 2) AS \"NBR_MINUTE\", D.DAR_BLOCKING\r\n"
					+ "FROM DEMANDE_ARCHIVE D\r\n"
					+ "WHERE D.DAR_NUM_DOSSIER = '"+NUM_DOSSIER+"'\r\n"
					+ "AND ROWNUM < 2\r\n"
					+ "ORDER BY D.DAR_DATE_CREATION DESC";
//			System.out.println(sql);

			stmt = con.createStatement();
			
			try {rs = stmt.executeQuery(sql);
			while(rs.next()){
				DA_TIMING = rs.getFloat("NBR_MINUTE") ;
				System.out.println("N° de la demande : "+rs.getInt("DAR_ID"));
				System.out.println("Pourcentage d'achèvement : "+rs.getInt("DAR_PROGRESS")+"%");
				System.out.println("Code état : "+rs.getInt("DAR_STATUS"));
				System.out.println("Temps d'exécution : "+DA_TIMING+" minutes");
				System.out.println("Téléchargement : "+rs.getInt("DAR_BLOCKING"));
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return DA_TIMING ; 
	 }
	 
	 public static String test () throws SQLException, Throwable {
//		 Thread.sleep(1000);
		 //Requete sql statut
			String sql = "SELECT E.REQ_ID, SUM((F.FI_TAILLE)/1000000)\r\n"
					+ "FROM EVT E, PJ P, FICHIER F, ACT A\r\n"
					+ "WHERE E.EVT_ID = P.EVT_ID\r\n"
					+ "AND P.PJ_ID = F.FI_PJ_ID\r\n"
					+ "AND A.REQ_ID = E.REQ_ID\r\n"
					+ "AND A.ANN_ID = 16640 \r\n"
					+ "GROUP BY E.REQ_ID\r\n"
					+ "HAVING SUM((F.FI_TAILLE)/1000000)< 1";
			System.out.println(sql);

			stmt = con.createStatement();
			
			try {rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("REQ_ID"));
				System.out.println(rs.getFloat("SUM((F.FI_TAILLE)/1000000)"));
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return null ; 
	 }
	 
	 public static String actCP (String acteur) throws SQLException {
		 String sql = "SELECT A.ADR_CP\r\n"
		 		+ "FROM ANN_AVO A\r\n"
		 		+ "WHERE A.ACT_NOM = '"+acteur+"'";
//		 System.out.println(sql);
		 
		 stmt = con.createStatement();
		 
		 try {rs = stmt.executeQuery(sql);
			while(rs.next()){
				String CP = rs.getString("ADR_CP");
				System.out.println(CP);
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return CP;
	 }
	 
	 
	 
	 public static String listColumns() throws SQLException {
		 String sql = "SELECT COLUMN_NAME\r\n"
		 		+ "FROM INFORMATION_SCHEMA.COLUMNS\r\n"
		 		+ "WHERE TABLE_NAME = 'jhi_user'";
		 
		 stmt = con.createStatement();
		 
		 try {rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1));
				
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return null;
		 
	 }
	 
	 public static String listTable() throws SQLException {
		 String sql = "SELECT   * \r\n"
		 		+ "FROM   information_schema.tables\r\n"
		 		+ "WHERE   table_type='BASE TABLE'";
		 
		 stmt = con.createStatement();
		 
		 try {rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(3));
				
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return null;
		 
	 }
	 
	 public static String deleteUserTrc (String name, String mail) throws SQLException {
		 String delUser = "DELETE FROM jhi_user_authority WHERE user_id = (SELECT id FROM jhi_user WHERE email = '"+mail+"')";
		 String delUser1 = "DELETE FROM jhi_user WHERE last_name = '"+name+"' AND email = '"+mail+"'";
		 stmt = con2.createStatement();
		 
		 try {
			 System.out.println(stmt.executeUpdate(delUser));
			 System.out.println(stmt.executeUpdate(delUser1));
			System.out.println("L'utilisateur a bien été supprimé");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return null;
	 }
	 
	 public static String resSqlTrc() throws SQLException {
		 
		 String sql = "SELECT first_name, last_name, activated, email, fc_souscription "
		 		+ "FROM jhi_user "
		 		+ "WHERE email in ('gradenait@yopmail.com', 'zaire@yopmail.com', 'wossewodda-3728@yopmail.com', 'delvy@yopmail.com')" ;
		 stmt = con2.createStatement();
		 
		 try {rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return null;
	 }
	 
	 
	 public static String removingReq(String Numprovisoire) throws SQLException {
		String sql1 = "DELETE FROM tr_event\r\n"
					+ "WHERE requete_id = (SELECT r.id \r\n"
					+ "					FROM requete r\r\n"
					+ "					WHERE r.numero_requete_provisoire = '"+Numprovisoire+"' )";
		
		String sql2 = "DELETE FROM partie \r\n"
					+ "WHERE requete_id = (SELECT r.id \r\n"
					+ "					FROM requete r\r\n"
					+ "					WHERE r.numero_requete_provisoire = '"+Numprovisoire+"' )";
		
		String sql3 = "DELETE FROM trc_event_depot_refus_requete \r\n"
					+ "WHERE requete_id = (SELECT r.id \r\n"
					+ "					FROM requete r\r\n"
					+ "					WHERE r.numero_requete_provisoire = '"+Numprovisoire+"' )";
		
		String sql4 = "DELETE FROM requete\r\n"
					+ "WHERE numero_requete_provisoire  = '"+Numprovisoire+"'";
		
		stmt = con.createStatement();
		try {
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			System.out.println("La requête a bien été supprimée");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return null;
	 }
	 
	 public static String removeReqTRConTR(int NumProvisoire) throws SQLException {
		 //Delete piecejointe 
		 String sql1 = "DELETE FICHIER_TRC FT WHERE FT.FI_ID IN (SELECT F.FI_ID FROM FICHIER F WHERE F.FI_PJ_ID IN (SELECT P.PJ_ID FROM PIECEJOINTE P WHERE P.PJ_RT_ID = "+NumProvisoire+"))";
		 System.out.println(sql1);
		 String sql2 = "DELETE FICHIER F WHERE F.FI_PJ_ID IN (SELECT P.PJ_ID FROM PIECEJOINTE P WHERE P.PJ_RT_ID = "+NumProvisoire+")";
		 System.out.println(sql2);
		 String sql3 = "DELETE PIECEJOINTE P WHERE P.PJ_RT_ID = "+NumProvisoire+"";
		 System.out.println(sql3);
		 String sql4 = "DELETE LECTUREMESSAGE LM WHERE LM.LM_MS_ID IN(SELECT M.MS_ID FROM MESSAGE M WHERE M.MS_RT_ID = "+NumProvisoire+")";
		 System.out.println(sql4);
		 String sql5 = "DELETE MESSAGE M WHERE M.MS_RT_ID = "+NumProvisoire+"";
		 System.out.println(sql5);
		 String sql6 = "DELETE REQUERANT R WHERE R.RR_RT_ID = "+NumProvisoire+"";
		 System.out.println(sql6);
		 String sql7 = "DELETE REQUETE R WHERE R.RT_ID = "+NumProvisoire+"";
		 System.out.println(sql7);
		 
		 stmt = con.createStatement();
			try {
				System.out.println("Nombre de ligne(s) supprimée(s) : "+stmt.executeUpdate(sql1));
				System.out.println("Nombre de ligne(s) supprimée(s) : "+stmt.executeUpdate(sql2)); 
				System.out.println("Nombre de ligne(s) supprimée(s) : "+stmt.executeUpdate(sql3));
				System.out.println("Nombre de ligne(s) supprimée(s) : "+stmt.executeUpdate(sql4));
				System.out.println("Nombre de ligne(s) supprimée(s) : "+stmt.executeUpdate(sql5));
				System.out.println("Nombre de ligne(s) supprimée(s) : "+stmt.executeUpdate(sql6));
				System.out.println("Nombre de ligne(s) supprimée(s) : "+stmt.executeUpdate(sql7));
				System.out.println("La requête a bien été supprimée");
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return null;
	 }
	 
	 public static String sqlVerificationRattachement(String code) throws SQLException {
			//Création de la méthode statement (méthode pour exécuter les requêtes)
			stmt = con.createStatement();
					
					//Requête SQL
					query = "SELECT I.RATTACH_TRC_DT\r\n"
							+ "FROM INSCRIPT_TRC I\r\n"
							+ "WHERE I.CODE_SECRET = '"+code+"'";
					try {
						//Exécution de la requête de type SELECT -> executeQuery
						rs = stmt.executeQuery(query);
						//Affichage des résultats
						while(rs.next()) {
							while(rs.getString(1)==null) {
								System.out.println("aucune information disponible dans la colonne RATTACH_TRC_DT....."+MesFonctions.extractCurrentHeure()+"\r");
								Thread.sleep(2000);
								rs = stmt.executeQuery(query);
								if(rs.next()) {
									System.out.println("CODE_RETOUR=0");;
								}
								else {
									System.err.println("CODE_RETOUR=-1");
								}
							}
							System.out.println("La colonne RATTACH_TRC_DT est renseignée : "+rs.getString(1)+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						//Fermeture de l'objet d'exécution
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			
		 return null;
		}
	 
	 public static String sqlVerificationCodeRattachementTr(String code) throws SQLException {
			//Création de la méthode statement (méthode pour exécuter les requêtes)
			stmt = con.createStatement();
					
					//Requête SQL
					query = "SELECT DISTINCT (SELECT I.CODE_SECRET FROM INSCRIPT_TRC I WHERE I.CODE_SECRET = '"+code+"') AS code_secret FROM INSCRIPT_TRC";
					try {
						//Exécution de la requête de type SELECT -> executeQuery
						rs = stmt.executeQuery(query);
						//Affichage des résultats
						while(rs.next()) {
							while(rs.getString(1)==null) {
								System.out.println("aucune information disponible....."+MesFonctions.extractCurrentHeure()+"\r");
								Thread.sleep(2000);
								rs = stmt.executeQuery(query);
								if(rs.next()) {
									System.out.println("CODE_RETOUR=0");
								}
								else {
									System.err.println("CODE_RETOUR=-1");
								}
							}
							System.out.println("La colonne est renseignée ; le rattachement a été réalisé : "+rs.getString(1)+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						//Fermeture de l'objet d'exécution
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			return null;
		}
	 
	 public static String sqlVerificationCodeInscriptionTr(String code) throws SQLException, InterruptedException {
			//Création de la méthode statement (méthode pour exécuter les requêtes)
			stmt = con.createStatement();
					
					//Requête SQL
					query = "SELECT DISTINCT (SELECT I.LOGIN_INSCRIPT_TR FROM INSCRIPT_TR I WHERE I.MDP_INSCRIPT_TR = '"+code+"') AS code_secret FROM INSCRIPT_TR";
					try {
						//Exécution de la requête de type SELECT -> executeQuery
						rs = stmt.executeQuery(query);
						//Affichage des résultats
						while(rs.next()) {
							while(rs.getString(1)==null) {
								System.out.println("aucune information disponible....."+MesFonctions.extractCurrentHeure()+"\r");
								Thread.sleep(2000);
								rs = stmt.executeQuery(query);
								if(rs.next()) {
									System.out.println("CODE_RETOUR=0");
								}
								else {
									System.err.println("CODE_RETOUR=-1");
								}
							}
							System.out.println("La colonne est renseignée ; le rattachement a été réalisé : "+rs.getString(1)+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						//Fermeture de l'objet d'exécution
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(1000);
			return null;
		}
	 
	 public static String change_date_mois_creation_compteTRC(String mail, int mois) throws SQLException {
		 String sql  = "UPDATE jhi_user \r\n"
		 		+ "SET created_date = DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL "+mois+" MONTH)), INTERVAL 1 DAY), \r\n"
		 		+ "last_modified_date = DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL "+mois+" MONTH)), INTERVAL 1 DAY),\r\n"
		 		+ "cgu_date_acceptation = DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL "+mois+" MONTH)), INTERVAL 1 DAY) \r\n"
		 		+ "WHERE email in ('"+mail+"')";
		 
		 stmt = con2.createStatement();
			try {
				System.out.println("Nombre de ligne modifiée : "+stmt.executeUpdate(sql));
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 return null;
	 }
	 
	 public static boolean verification_aucun_dossier(String mail) throws SQLException {
		 String sql  = "SELECT count(r.id) \r\n"
		 		+ "FROM requete r\r\n"
		 		+ "WHERE r.user_id in (SELECT ju.id\r\n"
		 		+ "				FROM jhi_user ju\r\n"
		 		+ "					WHERE ju.email in ('"+mail+"'))\r\n";
		 System.out.println(mail);
		 stmt = con2.createStatement();
		 boolean verif = false;
			try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
				
				if(rs.getInt(1)<1) {
					verif = true;
					System.out.println(rs.getInt(1)+" dossier trouvé....."+MesFonctions.extractCurrentHeure());
				}else {
					verif = false;
					System.out.println(rs.getInt(1)+" dossiers trouvés....."+MesFonctions.extractCurrentHeure());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return verif;
	 }
	 
	 public static String verification_derniere_connexion(String mail) throws SQLException {
		 String sql = "SELECT ju.last_login_date \r\n"
		 		+ "FROM jhi_user ju \r\n"
		 		+ "WHERE ju.email = '"+mail+"'";
		 String date = "";
		 stmt = con2.createStatement();
		 try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
				
				if(rs.getString(1) != null) {
					date = rs.getString(1); 
				System.out.println("Date retournée : "+rs.getString(1)+"....."+"\r");
					}
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return date.trim();
	 }
	 
	 public static String modification_date_derniere_connexion_compteTRC(String mail, int mois) throws SQLException {
		 String sql  = "UPDATE jhi_user  \r\n"
		 				+ "SET last_login_date = DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL  "+mois+" MONTH)), INTERVAL 1 DAY)\r\n"
		 				+ "WHERE email = '"+mail+"'";
		 
		 
		 stmt = con2.createStatement();
			try {
				System.out.println("La colonne \"LAST_LOGIN_DATE\" a bien été modifiée : "+stmt.executeUpdate(sql)+"....."+MesFonctions.extractCurrentHeure()+"\r");
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 return null;
	 }
	 
	 public static String modification_date_dernier_rappel_compteTRC(String mail) throws SQLException {
		 String sql  = "UPDATE jhi_user\r\n"
		 				+ "SET last_call_date = NULL "	
		 				+ "WHERE email = '"+mail+"'";
		 
		 
		 stmt = con2.createStatement();
			try {
				System.out.println("La colonne \"LAST_CALL_DATE\" a bien été valorisée à \"NULL\" : "+stmt.executeUpdate(sql)+"....."+MesFonctions.extractCurrentHeure()+"\r");
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 return null;
	 }
	 
	 public static String modification_date_dossier(String mail, int mois) throws SQLException {
		 String sql1 = "UPDATE requete \r\n"
		 		+ "SET date_modification = DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL  "+mois+" MONTH)), INTERVAL 1 DAY), \r\n"
		 		+ "date_creation =  DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL  "+mois+" MONTH)), INTERVAL 1 DAY)\r\n"
		 		+ "WHERE user_id in (SELECT id \r\n"
		 		+ "					FROM jhi_user \r\n"
		 		+ "					WHERE email in ('"+mail+"'))";
		 
		 String sql2 = "UPDATE tr_event  \r\n"
		 		+ "set date_evt =  DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL  "+mois+" MONTH)), INTERVAL 1 DAY)\r\n"
		 		+ "WHERE requete_id in (SELECT id from requete"
		 		+ "						WHERE user_id in(SELECT id \r\n"
		 		+ "		 							FROM jhi_user \r\n"
		 		+ "		 							WHERE email in ('"+mail+"')))"; 
		 
		 String sql3 = "UPDATE tr_event  \r\n"
		 		+ "set date_evt =  DATE_ADD((Select DATE_SUB(SYSDATE(), INTERVAL  "+mois+" MONTH)), INTERVAL 1 DAY)\r\n"
		 		+ "WHERE requete_id in (SELECT id from requete"
		 		+ "						WHERE user_id in(SELECT id \r\n"
		 		+ "		 							FROM jhi_user \r\n"
		 		+ "		 							WHERE email in ('"+mail+"')))";
		 
		 stmt = con2.createStatement();
			try {
				System.out.println("Les colonnes \"DATE_MODIFICATION\" et \"DATE_CREATION\" ont bien été modifiées : "+stmt.executeUpdate(sql1)+"....."+MesFonctions.extractCurrentHeure()+"\r");
				Thread.sleep(120);
				System.out.println("Le colonne \"DATE_EVENT\" a bien été modifiée : "+stmt.executeUpdate(sql2)+"....."+MesFonctions.extractCurrentHeure()+"\r");
				Thread.sleep(120);
				System.out.println("Le colonne \"DATE_EVT\" a bien été modifiée : "+stmt.executeUpdate(sql3)+"....."+MesFonctions.extractCurrentHeure()+"\r");
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 return null;
	 }
	 
	 public static boolean verification_dossier_en_cour(String mail) throws SQLException {
		 String sql  = "SELECT count(r.id) \r\n"
		 		+ "FROM requete r\r\n"
		 		+ "WHERE r.user_id in (SELECT ju.id\r\n"
		 		+ "				FROM jhi_user ju\r\n"
		 		+ "					WHERE ju.email in ('"+mail+"'))\r\n"
		 		+ "AND r.statut NOT IN ('Terminé','Refusé')"
		 		;
		 System.out.println(mail);
		 stmt = con2.createStatement();
		 boolean verif = false;
			try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
				
				if(rs.getInt(1)<1) {
					verif = true;
					System.out.println(rs.getInt(1)+" dossier en cours trouvé....."+MesFonctions.extractCurrentHeure());
				}else {
					verif = false;
					System.out.println(rs.getInt(1)+" dossiers en cours trouvés....."+MesFonctions.extractCurrentHeure());
					}
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return verif;
	 }
	 
	 public static String verification_etat_req_TRC_Async(String mail) throws SQLException {
		 //Récupération de la transaction ID depuis la table TRC
		 String sql1 = "SELECT r.transaction_id \r\n"
		 		+ "FROM requete r\r\n"
		 		+ "WHERE r.id = (SELECT max(r2.id) \r\n"
		 		+ "				FROM requete r2 \r\n"
		 		+ "				WHERE r2.user_id = (SELECT id FROM jhi_user\r\n"
		 		+ "		 		 								WHERE email in ('"+mail+"')))";
		 
		 String numDos = "";
		 String transId = "";
		 stmt = con.createStatement();
		 stmt1 = con2.createStatement();
		 try {
				rs1 = stmt1.executeQuery(sql1);
				
				while(rs1.next()) {
					//Vérification du numéro de transaction ID dans la table TR 
					transId = rs1.getString(1).trim();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

		 		try {
		 			
					String sql2 = "SELECT DISTINCT (SELECT R.RT_TRC_TRANS_ID FROM REQUETE R WHERE R.RT_TRC_TRANS_ID = '"+transId+"') AS trans_ID FROM REQUETE";
					
					rs = stmt.executeQuery(sql2);
					
					while(rs.next()) {
						
						while(rs.getString(1)==null) {
							System.out.println("aucune information disponible....."+MesFonctions.extractCurrentHeure()+"\r");
							Thread.sleep(2000);
							rs = stmt.executeQuery(sql2);
							if(rs.next()) {
								System.out.println("CODE_RETOUR=0");
							}
							else {
								System.err.println("CODE_RETOUR=-1");
							}
						}
						System.out.println("La colonne est renseignée ; la ligne de la RT_TRC_TRANS_ID est renseignée : "+rs.getString(1)+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					}
		 		} 	catch (Exception e) {
		 			e.printStackTrace();
		 		}
					
					//Vérification de l'ETAT de la REQUETE
					String sql3 = "SELECT R.RT_ID, R.RT_CD_XML_ID_ETA\r\n"
					 		+ "FROM REQUETE R\r\n"
					 		+ "WHERE R.RT_TRC_TRANS_ID = '"+transId+"'";
					try {
					rs = stmt.executeQuery(sql3);
					while(rs.next()) {
						numDos = rs.getString(1);
						
						while(!rs.getString(2).equals("2")) {
							System.out.println("La requête est à l'état BROUILLON : "+rs.getString(2)+"....."+MesFonctions.extractCurrentHeure()+"\r");
							Thread.sleep(2000);
							rs = stmt.executeQuery(sql3);
							if(rs.next()) {
								System.out.println("CODE_RETOUR=0");
							}
							else {
								System.err.println("CODE_RETOUR=-1");
							}
						}
						System.out.println("La requête est à l'état TRAITE....."+MesFonctions.extractCurrentHeure()+"\r");
					}
				}
			 catch (Exception e) {
				e.printStackTrace();
			}
				
		 try {
				//Fermeture de l'objet d'exécution
				stmt.close();
				stmt1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 System.out.println("Le numéro provisoire de la requête : "+numDos);
		 return numDos;
	 }
	 
	 
	 public static String sqlVerificationNumeroRequete(String code) throws SQLException {
			//Création de la méthode statement (méthode pour exécuter les requêtes)
			stmt = con.createStatement();
					
					//Requête SQL
					query = "SELECT DISTINCT (SELECT R.REQ_ID FROM REQ R WHERE R.REQ_ID ='"+code+"') AS numero_requete FROM REQ ";
					try {
						//Exécution de la requête de type SELECT -> executeQuery
						rs = stmt.executeQuery(query);
						//Affichage des résultats
						while(rs.next()) {
							while(rs.getString(1)==null) {
								System.out.println("aucune information disponible....."+MesFonctions.extractCurrentHeure()+"\r");
								Thread.sleep(2000);
								rs = stmt.executeQuery(query);
								if(rs.next()) {
									System.out.println("CODE_RETOUR=0");
								}
								else {
									System.err.println("CODE_RETOUR=-1");
								}
							}
							System.out.println("La ligne est ajoutée, la requête a été créée : "+rs.getString(1)+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						//Fermeture de l'objet d'exécution
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			return null;
		}
	 
	 public static String sqlVerification_ReceptionPMI_Requete(String req, String jur) throws SQLException {
			//Création de la méthode statement (méthode pour exécuter les requêtes)
		 if(jur=="TA" || jur=="CAA") {
			stmt = con.createStatement();
					//Requête SQL
					query = "SELECT DISTINCT (SELECT E.MES_ID FROM EVT E WHERE E.REQ_ID ='"+req+"' AND E.MES_ID = 'RECRPMI') AS mesure FROM EVT";
					try {
						//Exécution de la requête de type SELECT -> executeQuery
						rs = stmt.executeQuery(query);
						//Affichage des résultats
						while(rs.next()) {
							while(rs.getString(1)==null) {
								System.out.println("aucune information disponible....."+MesFonctions.extractCurrentHeure()+"\r");
								Thread.sleep(2000);
								rs = stmt.executeQuery(query);
								if(rs.next()) {
									System.out.println("CODE_RETOUR=0");
								}
								else {
									System.err.println("CODE_RETOUR=-1");
								}
							}
							System.out.println("La ligne est ajoutée, la requête a été créée : "+rs.getString(1)+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						//Fermeture de l'objet d'exécution
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
		 }else {
			 stmt = con.createStatement();
				
				//Requête SQL
				query = "SELECT DISTINCT (SELECT E.MES_ID FROM EVT E WHERE E.REQ_ID ='"+req+"' AND E.MES_ID = 'RECDPI') AS mesure FROM EVT";
				try {
					//Exécution de la requête de type SELECT -> executeQuery
					rs = stmt.executeQuery(query);
					//Affichage des résultats
					while(rs.next()) {
						while(rs.getString(1)==null) {
							System.out.println("aucune information disponible....."+MesFonctions.extractCurrentHeure()+"\r");
							Thread.sleep(2000);
							rs = stmt.executeQuery(query);
							if(rs.next()) {
								System.out.println("CODE_RETOUR=0");
							}
							else {
								System.err.println("CODE_RETOUR=-1");
							}
						}
						System.out.println("La ligne est ajoutée, la requête a été créée : "+rs.getString(1)+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					//Fermeture de l'objet d'exécution
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }
			return null;
		}
	 
}

