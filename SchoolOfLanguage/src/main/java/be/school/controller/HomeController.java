package be.school.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * HomeController Controller Class
 * 
 * @author P. Mutanda
 * 
 *         Sample controller for going to the home page with a message
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Selects the home page and populates the model with a message
	 * 
	 * @param model
	 *            model
	 * @return retourne la page home
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute(
				"controllerMessage",
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. "
						+ "Aenean commodo ligula eget dolor. Aenean massa."
						+ " Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."
						+ " Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem."
						+ " Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu."
						+ " In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. "
						+ "Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus."
						+ " Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus."
						+ " Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. "
						+ "Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.");
		return "home";
	}

}
