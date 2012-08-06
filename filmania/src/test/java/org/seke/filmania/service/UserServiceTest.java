package org.seke.filmania.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seke.filmania.dao.GenreDAO;
import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.dao.UserDaolMockImpl;
import org.seke.filmania.domain.User;
import org.seke.filmania.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:**/service-context-test.xml", "classpath:**/dao-context-test.xml"})
@Transactional
public class UserServiceTest {

	@Autowired
	private ApplicationContext applicationContext;
//	
	@Autowired
	private UserDAO userDAO;
//	
	@Autowired
	private UserService userService;
	
	private UserServiceImpl userServiceImplUnderTest = new UserServiceImpl();
	
//	@Before
//	public void setUp() {
//		System.out.println("1111111111111111");
//		UserDaolMockImpl userDaolMockImpl = new UserDaolMockImpl();
//		
//		User zika = new User();
//		zika.setId(1l);
//		zika.setUsername("zika");
//		userDaolMockImpl.create(zika);
//		
//		User pera = new User();
//		pera.setId(2l);
//		pera.setUsername("pera");
//		userDaolMockImpl.create(pera);
//		
//		userServiceImplUnderTest.setUserDAO(userDaolMockImpl);
//	}
	
//	@Before
//	public void setUp() {
//		List<User> listaUsera = new ArrayList<>();
//		User zika = new User();
//		zika.setId(1l);
//		zika.setUsername("zika");
//		listaUsera.add(zika);
//		
//		User pera = new User();
//		pera.setId(2l);
//		pera.setUsername("pera");
//		listaUsera.add(pera);
//		
//		UserDAO userDAOMock = mock(UserDAO.class);
//		when(userDAOMock.getAllUsers()).thenReturn(listaUsera);
//		userServiceImplUnderTest.setUserDAO(userDAOMock);
//	}
	
	@Before
	public void before() throws DatabaseUnitException, SQLException, FileNotFoundException, IOException {
		 
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
	
//	
	@Test
	public void saberiDvaBrojaTest(){
		int actualResult = userServiceImplUnderTest.saberi(3, 6);
		int expectedResult = 9;
		assertSame(expectedResult, actualResult);
	}
	
	@Test
	public void podeliDvaBrojaTest(){
		int actualResult = userServiceImplUnderTest.podeli(6, 3);
		int expectedResult = 2;
		assertSame(expectedResult, actualResult);
	}
	
	@Test(expected = ArithmeticException.class)
	public void podeliSaNulomTest(){
		userServiceImplUnderTest.podeli(6, 0);
	}
	
//	@Test
//	public void padaTest(){
//		fail("Not implemented yet");
//	}
	
//	@Test
//	public void vratiKosrisnickaImenaKorisnikaTest() {
//		List<String> listaKosrisnickihImena = userServiceImplUnderTest.vratiKosrisnickaImenaKorisnika();
//		
//		assertTrue(listaKosrisnickihImena.size() == 2);
//		
//		for (String korisnickoIme : listaKosrisnickihImena) {
//			System.out.println(korisnickoIme);
//			assertTrue(korisnickoIme.contains(": "));
//		}
//		
//	}
	
	@Test
	public void vratiKorisnikeTest() {
		assertTrue(userDAO.getAllUsers().size() == 2);
	}
	
	@Test
	public void sacuvajKorisnikaTest() {
		User mika = new User();
		mika.setUsername("mika");
		mika.setPassword("mika");
		
		assertNull(mika.getId());
		
		userService.saveUser(mika);
		
		assertNotNull(mika.getId());
		
	}
	
}
