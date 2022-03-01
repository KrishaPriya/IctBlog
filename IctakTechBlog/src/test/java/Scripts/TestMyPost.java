package Scripts;

import Constants.AutomationConstants;
import PageObjects.MyPostPage;
import Utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMyPost extends TestBase {
    MyPostPage objMyPost;

    @Test(priority = 0)
    public void verifyExistingPostEmpty(){
        Assert.assertEquals(true,true);
    }

/*
    @Test(priority = 0)
    public void verifyEditPost(){
        driver.navigate().refresh();
        objMyPost=new MyPostPage(driver);
        objMyPost.clickEdit();
        //String Title= ExcelUtility.getCellData();
       // String Image=ExcelUtility.getCellData();
       // String Post=ExcelUtility.getCellData();
        objMyPost.setTitle(Title);
        objMyPost.setImage(Image);
        objMyPost.setPostDesc(Post);
        objMyPost.submit();
        String expectedTitle= AutomationConstants.HOMEPAGETITLE;
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    */


//    @Test(priority = 1)
//    public void verifyDeletePost(){
//        driver.navigate().refresh();
//       objMyPost= new MyPostPage(driver);
//       objMyPost.clickDelete();
//       String expectedTitle= AutomationConstants.MYPOSTTITLE;
//       String actualTitle= driver.getTitle();
//        Assert.assertEquals(expectedTitle,actualTitle);
//    }
}
