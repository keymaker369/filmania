package org.seke.filmania.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.seke.filmania.controller.validation.CommentValidator;
import org.seke.filmania.domain.Comment;
import org.seke.filmania.domain.CommentId;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.User;
import org.seke.filmania.model.AddCommentCommand;
import org.seke.filmania.service.CommentService;
import org.seke.filmania.service.MovieService;
import org.seke.filmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommentService commentService;

	@InitBinder(value = "addCommentCommand")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CommentValidator());
	}

	@RequestMapping(value = "/movie/addComment", method = RequestMethod.GET, params = "idMovie")
	public ModelAndView loadAddCommentPage(@RequestParam("idMovie") String idMovie) {
		Movie movieToComment = getMovieService().retrieveMovie(Long.parseLong(idMovie));
		ModelAndView mav = new ModelAndView("/movie/addComment", "movie", movieToComment);
		mav.addObject("addCommentCommand", new AddCommentCommand());
		return mav;
	}

	@RequestMapping(value = "/movie/addComment", method = RequestMethod.POST, params = "sacuvajCommentar")
	public String addCommentPage(@Valid AddCommentCommand addCommentCommand, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return "/movie/addComment";
		}

		Comment comment = new Comment();
		comment.setContent(addCommentCommand.getComment());
		comment.setInputDate(new Date(System.currentTimeMillis()));

		getMovieService().addMovieComment(addCommentCommand.getMovieId(), comment, principal.getName());
		return "redirect:/movie/view?id=" + addCommentCommand.getMovieId();
	}

	public MovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

}
