package Scripts.Admin;

import java.io.IOException;
import java.lang.System.Logger;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.adminAllPost;
import PageObjects.newPosts;
import PageObjects.setUpApp;
import Scripts.TestBase;

public class testAdminDelete extends TestBase {

	LoginPage objLogin;
	setUpApp objSetUp;
	adminAllPost objAdmin;
	newPosts objNew;
	Logger logger;
	
	@Test(priority = 0)
	public void launchApp() throws IOException, InterruptedException {

		objSetUp = new setUpApp(driver);// login to application

		objSetUp.selectLoginDropdown();
	}

	@Test(priority = 1)
	public void deletePosts() throws IOException {
		objAdmin = new adminAllPost(driver);
		// Reporter.log("---My posts ---" + objActionsUser, true); // Adding post btn
		// click objActionsUser.NewPost();
		try {
			objAdmin.deleteByUser("La");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
