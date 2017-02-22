package com.lnganalysis.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConfiguration {
	static final Logger logger=Logger.getLogger(DbConfiguration.class);
	private static SessionFactory sf=null;
	private DbConfiguration()
	{
		//Should not instantiated outside
	}
	
	public static SessionFactory getSessionFactory()
	{
		try
		{
			Configuration config=new Configuration();
			synchronized (DbConfiguration.class) {
				if(sf==null)
				{
					sf=config.configure("hibernate.cfg.xml").buildSessionFactory();
					logger.info("Singleton Instantiated");
				}
					
			}	
		}
		catch(Exception e)
		{
			logger.error("Exception in DbConfiguration:"+e);
		}
			
		return sf;
	}
	
}
