package requete;

import java.sql.SQLException;

import org.testng.annotations.Test;

import JDBC.JdbcClass;

public class TA_depot_requete_portail_verification_valeur_par_defaut {
	
	String dossier;
	   String jur;
	   String DB_id;
	   String DB_mdp;
	   String env;
	   
	@Test   
	public void valeur_depot_TA() throws SQLException {
		jur = "TA";
		env = "rec";
		dossier = "27327";
		
		 switch (jur) {
			case "TA":
				if(env=="rec") {
					DB_id = "tr2_ta75";
					DB_mdp = "tr2_ta75";
				}else {
					DB_id = "tr2_ta69";
					DB_mdp = "tr2_ta69";
				}
				JdbcClass.conDBTR(DB_id, DB_mdp, env);
				break;
				
			case "CAA":
				if(env=="rec") {
					DB_id = "tr2_caa75";
					DB_mdp = "tr2_caa75";
				}else {
					DB_id = "tr2_caa69";
					DB_mdp = "tr2_caa69";
				}
				JdbcClass.conDBTR(DB_id, DB_mdp, env);
				break;
				
			case "CTX":
				JdbcClass.conDBTR("telerecours", "telerecours", env);
				break;

			default:  System.err.println("Aucune juridiction à ce nom");
				break;
		 	}
				
				JdbcClass.saisine_TA_verification_des_valeurs_chargees_en_BDD(dossier);
		}


}
