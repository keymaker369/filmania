package org.seke.filmania.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seke.filmania.domain.Genre;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:**/service-context-test.xml", "classpath:**/dao-context-test.xml"})
@Transactional
public class GenreDaoImplTest  {

	@Resource
	private GenreDAO genreDAO;
	
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
		Assert.assertTrue(genreDAO.retrieveAll().size() == 1);
		
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
		Assert.assertTrue(genreDAO.retrieveAll().size() == 1);
		
	}
	
	public GenreDAO getGenreDAO() {
		return genreDAO;
	}

	public void setGenreDAO(GenreDAO genreDAO) {
		this.genreDAO = genreDAO;
	}
	
	
}
