package Scripts;


import PageObjects.NewPostPage;
import Utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNewPost extends TestBase{
    NewPostPage objNewPost;

    @Test(priority = 1)
    public void verifyNewPost() throws IOException, InterruptedException {
        driver.navigate().refresh();
        objNewPost=new NewPostPage(driver);
        String Title=ExcelUtility.getCellData(4,0);
        String Image=ExcelUtility.getCellData(4,1);
        String Post=ExcelUtility.getCellData(4,2);
        objNewPost.setTitle(Title);
        objNewPost.setImage(Image);
        objNewPost.setCategory();
        objNewPost.setPost(Post);
        Thread.sleep(5000);
        objNewPost.clickSubmit();
        objNewPost.clickLogout();

    }



}
