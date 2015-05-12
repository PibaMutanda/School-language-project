package be.school;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import be.school.controller.HomeController;

public class HomeControllerTest {

	@Test
	public void testController() {
		HomeController controller = new HomeController();
		Model model = new ExtendedModelMap();
		Assert.assertEquals("home",controller.home(model));
		
		Object message = model.asMap().get("controllerMessage");
		Assert.assertEquals("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. "
				+ "Aenean commodo ligula eget dolor. Aenean massa."
				+ " Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."
				+ " Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem."
				+ " Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu."
				+ " In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. "
				+ "Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus."
				+ " Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus."
				+ " Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. "
				+ "Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.",message);
			
	}
}
