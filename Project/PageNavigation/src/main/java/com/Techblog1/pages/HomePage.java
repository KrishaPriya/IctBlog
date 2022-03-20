package com.Techblog1.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Techblog1.utilities.PageUtility;


public class HomePage {
	
	   //Create a variable of WebDriver
	    WebDriver driver;
	    
	    //  icons are identified by @FindBy annotation
	     @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[1]/a" )
	    private WebElement homeicon  ;
	    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[8]/a" )
	    private WebElement aboutusicon; 
	    
		//ICTAK logo is identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/a/img")
	    private WebElement logo ;
		
		// welcome text identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-home/div/div[1]/div/div/h2" )
	    private WebElement welcometext ;
		
		// Read more link under tech News and Gadgets is identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-home/div/div[2]/div/div/div/div[1]/div/p/a")
	    private WebElement asteroidnereus; 
		
		// more news link under tech News and Gadgetsare identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-home/div/div[2]/div/div/div/div[1]/div/div/a")
	    private WebElement morenews ;
		
		// read more link under latest articles are identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-home/div/div[4]/div/li[1]/div/div/div/small")
	    private WebElement metalclouds;
		
		// Testimonials are identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-home/div/div[5]/section/div/owl-carousel-o/div/div[2]/div[1]")
	    private WebElement prev;
		@FindBy(xpath="/html/body/app-root/app-home/div/div[5]/section/div/owl-carousel-o/div/div[2]/div[2]")
	    private WebElement next;
		
		// Feedback Form elements are identified by @FindBy annotation
		@FindBy(id="fname")
	    private WebElement FirstName ;
		@FindBy(id="lname")
	    private WebElement LastName ;
		@FindBy(xpath="/html/body/app-root/app-home/div/div[6]/form/div[3]/div[2]/select")
	    private WebElement country ;
		@FindBy(xpath="/html/body/app-root/app-home/div/div[6]/form/div[4]/div[2]/textarea")
	    private WebElement subject ;
		@FindBy(xpath="/html/body/app-root/app-home/div/div[6]/form/div[5]/input")
	    private WebElement submit ;
		
		//FooterLinks are identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[1]")
	    private WebElement homelink ;
	    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[3]")
	    private WebElement aboutuslink ;
		@FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[2]")
	    private WebElement contactuslink ;
		
		//social media images are identified by @FindBy annotation
		@FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[1]")
	    private WebElement facebook ;
		@FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[2]")
	    private WebElement twitter  ;
		@FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[3]")
	    private WebElement instagram ;
		@FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[4]")
	    private WebElement linkedin ;
		
		
		
		//initializing page objects
		 public HomePage (WebDriver driver)
		    {
		        this.driver=driver;
		        PageFactory.initElements(driver,this);
		    }
		 
		//sorting the site title
		  public String validateHomePageTitle() {
			 return driver.getTitle();
		  }
		  //move to homepage
		  public void clickHome() {
			  
			  PageUtility.waitForElementTobeclickable(driver,homeicon,50);
			  homeicon.click();
			  
		  }
		  //move to aboutus page
		  public void clickAboutUs() {
			  PageUtility.waitForElementTobeclickable(driver, aboutusicon,50);
			  aboutusicon.click();
			  
		  }
		 

		//check the visibility of ICTAK logo
		public boolean validateICTAKlogo() { 
			PageUtility.waitForElementTobeVisible(driver, logo,50);
			return logo.isDisplayed();
		}
		//check the visibility of welcome text
		public String validateWelcomeText(){ 
			PageUtility.waitForElementTobeVisible(driver, welcometext,50);
			return welcometext.getText();
		}
		//click on  read more link under Technews section
		 public boolean validateTechnewsReadmorelink() throws InterruptedException {
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",asteroidnereus);
			 asteroidnereus.click();
			 return asteroidnereus.isEnabled();
		 }
		//click on  more link under Technews section
		 public boolean validateTechnewsMorelink() throws InterruptedException {
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",morenews);
			  morenews.click();
			  return morenews.isEnabled(); 
		 }
		//click on  more link under latest article section
		 public boolean validateLatestarticlesMorelink() throws InterruptedException {
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", metalclouds);
			metalclouds.click();
			 Thread.sleep(500);
			 return metalclouds.isEnabled();
		 }
		//validate the functioning of prev button
		 public boolean validatePrevbtn() throws InterruptedException {
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prev);
			   Thread.sleep(500);
			   prev.click();
			  return prev.isEnabled();
			}
		//validate the functioning of next button
			public boolean validateNextbtn() throws InterruptedException{
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
			   Thread.sleep(500);
			    next.click();
				return next.isEnabled();
			}
			
		 
		
		
		
		//Set firstname in textbox
	     public void setfirstName(String strFirstName ) throws InterruptedException{
			   
			    FirstName .clear();
			    Thread.sleep(1000);
			    FirstName.sendKeys( strFirstName);     
			    }

		 //Set lastname in  textbox
		 public void setLastName(String strLastName) throws InterruptedException{
			     
			     LastName .clear();
			     Thread.sleep(500);
			     LastName.sendKeys(strLastName);     
			    }
		 //Set country name
		 public void setCountry(){
			     
			     Select countryList=new Select(country);
			      countryList.selectByVisibleText("India");
			    }
		 //send Feedback
	     public void  sendFeedback(String strSubject) throws InterruptedException {
	    	
			    	subject.clear();
			    	 Thread.sleep(500);
			    	subject.sendKeys(strSubject);
			    }
			   // click submit
			    public void clickSubmit() throws InterruptedException {
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",submit);
			        Thread.sleep(500);
			        submit.click();
			    }
			    
			//click on homelink using click command
			    public void clickHomeLink() throws InterruptedException {
			    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homelink);
			    	 PageUtility .waitForElementTobeclickable(driver,homelink,50);
			    	homelink.click();				 
			    }
			  //click on aboutuslink using click command
			    public void  clickAboutusLink() throws InterruptedException {
			    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutuslink);
			    	PageUtility.waitForElementTobeclickable(driver,aboutuslink,50);
			    	aboutuslink.click();
					
			    }
			  //click on contactuslink using click command
			    public void clickContactusLink() throws InterruptedException {
			    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactuslink);
			    	PageUtility.waitForElementTobeclickable(driver,contactuslink,50);
			    	 contactuslink.click();
					 
			    }
			    
				//check the visibility of facebook image	
			   public boolean facebookImage() {
				   PageUtility.waitForElementTobeVisible(driver,facebook,50);
				   return facebook .isDisplayed();
				   
			   }
			 //check the visibility of twitter image
		      public  boolean  twitterImage() {
		    	  PageUtility.waitForElementTobeVisible(driver,twitter,50);
		    	 return twitter.isDisplayed(); 
		      }
		    //check the visibility of instagram image
		      public boolean  instagramImage() {
		    	  PageUtility.waitForElementTobeVisible(driver,instagram,50);
		    	 return instagram.isDisplayed();
		      }
		    //check the visibility of linkedin image
		      public  boolean linkedinImage() {
		    	  PageUtility.waitForElementTobeVisible(driver,linkedin,50);
		    	  return linkedin .isDisplayed();
		    	  
		      }
		       //finding number of elements in header
		      public int findNoOfElementsInHeader() throws InterruptedException {

		          List<WebElement> elements=driver.findElements(By.xpath("//a[contains(@class, 'nav-link')]"));
		          int links=elements.size();

		          return links;
		      }

		      //finding number of textbox in homePage
		      public int findNoOfTextBoxesInHomePage() {
		          List<WebElement> elements=driver.findElements(By.xpath("//input [contains(@class, 'ng-untouched ng-pristine ng-invalid')]"));
		          int count=elements.size();
		          return count;
		      }
              //find number of elements in footer
		      public int findNoOfElemeentsInFooter(){
		          List<WebElement> elements=driver.findElements(By.xpath("//a[contains(@class, 'text-white')]"));
		          int count=elements.size();
		          return count;
		      }
             //find number of  submitbutton in homepage
		      public int findNoOfButtonInHomepage(){
		          List<WebElement> elements=driver.findElements(By.xpath("//input[type=submit]")); 
		          int count=elements.size();
		          return count;
		      }
		 
		
	}



