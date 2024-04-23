package trc;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;

public class RemoveReqte {
	
	static String num;
	static int nbr;
	static String ID;
	static String mdp;
	static WebDriver driver;
	static String env;
	
	@Test
	public void removeNumReq() throws Throwable {
		num = "85876";
		env = "rec";//int1
		JdbcClass.conDBTRC(env);
		JdbcClass.removingReq(num);
	}
	
	@Test
	public void removeReqTrcOnTR() throws SQLException {
		nbr = 85876;
		ID = "TELERECOURS";
		mdp = "telerecours";
		JdbcClass.conDBTR(ID, mdp, env);
		JdbcClass.removeReqTRConTR(nbr);	
	}

}
