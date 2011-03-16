/**
 * 
 */
package org.seke.filmania.controller;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import org.seke.filmania.domain.Genre;
import org.seke.filmania.service.GenreService;
import org.springframework.validation.BindingResult;

/**
 * @author Nenad Seke
 * 
 */
public class GenreControllerTest {

	private GenreService genreService;
	private GenreController genreControllerUnderTest;

	@SuppressWarnings("unused")
	@Before
	public void setUp() {
		genreService = mock(GenreService.class);
		genreControllerUnderTest = new GenreController();
		genreControllerUnderTest.setGenreService(genreService);
	}

	@Test
	public void testSaveNewGenre() {
		Genre genreToSave = new Genre();
		genreControllerUnderTest.saveNewGenre(genreToSave,
				mock(BindingResult.class));
	}
}
