package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.knotspot.model.VenueModel;
import com.knotspot.service.CrudService;
import com.knotspot.service.SearchService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/product" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("search_bar");
		if(action!=null) {
			searchVenue(request, response);
		}
		else {
			CrudService crudService = new CrudService();
			List<VenueModel> listVenue = crudService.selectAllVenues();
			request.setAttribute("listVenue", listVenue);
			request.getRequestDispatcher("/WEB-INF/pages/Customer/product.jsp").forward(request,response);
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void searchVenue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String searchValue = request.getParameter("search_bar");
		SearchService search = new SearchService();
		List<VenueModel> searchVenue = search.selectVenueByNameOrCity(searchValue);
		request.setAttribute("searchVenueList", searchVenue);
		request.getRequestDispatcher("/WEB-INF/pages/Customer/product.jsp").forward(request,response);
	}

}
