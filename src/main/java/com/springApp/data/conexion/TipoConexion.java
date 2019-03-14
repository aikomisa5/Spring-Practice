package com.springApp.data.conexion;

import org.hibernate.cfg.Environment;

import java.util.Properties;

public enum TipoConexion {	
	
	H2Test("org.hibernate.dialect.H2Dialect"
			,"org.h2.Driver"
			,"jdbc:h2:~//Test3;AUTO_SERVER=TRUE"
			,"root"
			,"root"
			,"false"
			,"create-drop"),
	H2Server("org.hibernate.dialect.H2Dialect"
			,"org.h2.Driver"
			,"jdbc:h2:~//Inmobi;AUTO_SERVER=TRUE"
			,"root"
			,"root"
			,"false"
			,"update"),
	MariaDBTest("org.hibernate.dialect.MariaDB53Dialect"
			,"org.mariadb.jdbc.Driver"
			,"jdbc:mysql://localhost:3306/prueba"
			,"root"
			,"root"
			,"false"
			,"create-drop"),
	MariaDBServer("org.hibernate.dialect.MariaDB53Dialect"
			,"org.mariadb.jdbc.Driver"
			,"jdbc:mysql://localhost:3306/pruebaserver"
			,"root"
			,"root"
			,"false"
			,"create-drop"),
	MySQLServer("org.hibernate.dialect.MySQL5Dialect",
			"com.mysql.jdbc.Driver"
			,"jdbc:mysql://localhost/basePrueba"
			,"root"
			,"root"
			,"false"
			,"create-drop"
	);

		
	private final String dialect;
	private final String driver;
	private final String url;
	private final String user;
	private final String pass;
	private final String useNewIdGeneratorMappings;
	private final String hbm2ddlauto;
	
	
	private TipoConexion(String dialect, String driver, String url, String user, String pass, String useNewIdGeneratorMappings, String hbm2ddlauto) {
		this.dialect = dialect;
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.useNewIdGeneratorMappings = useNewIdGeneratorMappings;
		this.hbm2ddlauto = hbm2ddlauto;
	}
	
	public Properties properties() {
		Properties p = new Properties();
		p.setProperty(Environment.DIALECT, this.dialect);
		p.setProperty(Environment.DRIVER, this.driver);
		p.setProperty(Environment.URL, this.url);
		p.setProperty(Environment.USER, this.user);
		p.setProperty(Environment.PASS, this.pass);
		p.setProperty(Environment.USE_NEW_ID_GENERATOR_MAPPINGS, this.useNewIdGeneratorMappings);
		p.setProperty(Environment.HBM2DDL_AUTO, hbm2ddlauto);
		return p;
	}
	

}
