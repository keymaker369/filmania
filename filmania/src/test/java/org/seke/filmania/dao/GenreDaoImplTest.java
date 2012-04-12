package org.seke.filmania.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import junit.framework.Assert;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seke.filmania.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:**/service-context-test.xml", "classpath:**/dao-context-test.xml"})
@Transactional
public class GenreDaoImplTest  {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Resource
	private GenreDAO genreDAO;
	
	@Before
	public void before() throws DatabaseUnitException, SQLException, FileNotFoundException, IOException{
		 
		DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
		Connection con = DataSourceUtils.getConnection(dataSource);
		IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
		IDataSet dataSet = new  FlatXmlDataSetBuilder().build(new FileInputStream("./src/test/resources/dataset.xml"));
		
		try {
			DatabaseOperation.REFRESH.execute(dbUnitCon, dataSet);
		} finally {
			DataSourceUtils.releaseConnection(con, dataSource);
		}
	}
	
	
	@Test
	public void firstTest(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(genreDAO);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		Genre genre = new Genre();
		genre.setName("akcija");
		genreDAO.create(genre);
		Assert.assertNotNull(genre.getId());
		
		Assert.assertTrue(genreDAO.retrieveAll().size()>0);
		Assert.assertTrue(genreDAO.retrieveAll().size() == 4);
		
	}

	@Test
	public void secondTest(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(genreDAO);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		Genre genre = new Genre();
		genre.setName("akcija");
		genreDAO.create(genre);
		Assert.assertNotNull(genre.getId());
		
		Assert.assertTrue(genreDAO.retrieveAll().size()>0);
		Assert.assertTrue(genreDAO.retrieveAll().size() == 4);
		
	}
	
	public GenreDAO getGenreDAO() {
		return genreDAO;
	}

	public void setGenreDAO(GenreDAO genreDAO) {
		this.genreDAO = genreDAO;
	}


	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
}
