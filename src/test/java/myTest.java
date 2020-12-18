
import org.junit.Assert;
import org.junit.Test;
public class myTest extends myTestMethods {
    @Test
    public void Test() throws InterruptedException {
        myTest myTest = new myTest();
        myTest.Setup();
        myTest.verifyPageTitle();
        myTest.verifyFacebookLoginButton();
        myTest.verifyGoogleLoginButton();
        myTest.verifyForgetPwLink();
        myTest.Login();
        myTest.SearchIten();
        myTest.verifySearchResult();
        //myTest.goToSecondPage();
        myTest.verifyCurrentPage();
        myTest.selectAproduct();
        myTest.addToCart();



    }



}
