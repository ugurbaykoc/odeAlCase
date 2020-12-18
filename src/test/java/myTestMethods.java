import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class myTestMethods {

        WebDriver driver;

        public void Setup() {
            System.setProperty("webdriver.chrome.driver", "/Users/ugurbaykoc/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.gittigidiyor.com/uye-girisi");

        }

        public void verifyPageTitle() {
            String ActualTitle = driver.getTitle();
            String ExpectedTitle = "Üye Girişi - GittiGidiyor";
            if (ActualTitle.equals(ExpectedTitle)) {
                System.out.println("Title test passed");
            } else {
                System.out.println("Title test failed" + ExpectedTitle);
            }

        }
        public boolean verifyFacebookLoginButton()
        {
            boolean facebookButtonPresent = driver.findElement(By.className("faux-fb-btn")).isDisplayed();
            if (facebookButtonPresent== true)
            {
                System.out.println("Facebook button is verified");
            }
            else
            {
                System.out.println("Facebook button is not there");
            }
            return facebookButtonPresent;
        }
    public boolean verifyGoogleLoginButton()
    {
        boolean googleButtonPresent = driver.findElement(By.id("customGoogleLoginBtn")).isDisplayed();
        if (googleButtonPresent== true)
        {
            System.out.println("Google button is verified");
        }
        else
        {
            System.out.println("Google button is not there");
        }
        return googleButtonPresent;
    }
        public  boolean verifyForgetPwLink()
        {
            boolean forgetPasswordLinkVisible = driver.findElement(By.id("L-ForgotPassword")).isDisplayed();
            if (forgetPasswordLinkVisible == true)
            {
                System.out.println("Forget Password Link Present");
            }
            else
            {
                System.out.println("Forget password link is not there");
            }
            return forgetPasswordLinkVisible;

        }
        public void Login()
        {
            WebElement username = driver.findElement(By.id("L-UserNameField"));
            WebElement password = driver.findElement(By.id("L-PasswordField"));
            WebElement login =driver.findElement(By.id("gg-login-enter"));
            username.sendKeys("ugurbaykoc@gmail.com");
            password.sendKeys("ugur123123");
            login.click();
            String actualUrl ="https://www.gittigidiyor.com/";
            String expectedUrl = driver.getCurrentUrl();





            Assert.assertEquals(expectedUrl,actualUrl);



        }

        public void  SearchIten() throws InterruptedException {
            Thread.sleep(500);
            WebElement searchtxt = driver.findElement(By.name("k"));
            searchtxt.sendKeys("Samsung");

            WebElement searchbtn = driver.findElement(By.xpath("//button[contains(@class,'base-qjixn8-0 styles__StyledButton-sc-1bydi5r-0')]"));
            searchbtn.click();


        }
        public void verifySearchResult(){
            String currentUrl=driver.getCurrentUrl();
            if(currentUrl.contains("Samsung"))
            {
                System.out.println("Page displays sansung results");


            }
            else
            {
                System.out.println("Page contains something else");
            }


        }
        /*public void goToSecondPage() throws InterruptedException {

            Thread.sleep(500);
            WebElement secondPageNav = driver.findElement(By.xpath("//a[@href='/arama/?k=samsung&sf=2']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(secondPageNav);
            actions.perform();
        }*/

        public void verifyCurrentPage(){

            WebElement  currentPage = driver.findElement(By.className("current"));
            if (currentPage.getText().equals("1"))
            {
                System.out.println("You are at the first page");
            }
            else
            {
                System.out.println("You are not on first page");
            }
        }
        public void selectAproduct()
        {
            WebElement selectedProduct = driver.findElement(By.xpath("//img[@alt='Samsung Galaxy S10+ 128GB (Prizma Siyah)']"));
            selectedProduct.click();

        }
        public void addToCart() throws InterruptedException {
            Thread.sleep(500);
            WebElement productincart = driver.findElement(By.cssSelector("button#add-to-basket>span"));
            Actions actions = new Actions(driver);
            actions.moveToElement(productincart);
            actions.click();

        }




    }



