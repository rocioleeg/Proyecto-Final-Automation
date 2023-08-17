import Pages.SprintDosPage;
import Pages.SprintTresPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SprintDosTest {

    private WebDriver driver;
    private SprintDosPage sprintDosPage;
    private SprintTresPage sprintTresPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "../AutomatizacionDigitalBooking/chromedriver_win3/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sprintDosPage = new SprintDosPage(driver);
        sprintDosPage.visit("http://g2c5-frontnode.s3-website.us-east-2.amazonaws.com/home");
        sprintTresPage = new SprintTresPage(driver);
    }


    @Test
    public void crearCuenta() throws Exception {
        sprintDosPage.crearCuenta();
    }

    @Test
    public void loginUser() throws Exception {
        sprintDosPage.iniciarSesionUser();
    }

    @Test
    public void loginAdmin() throws Exception {
        sprintDosPage.iniciarSesionComoAdmin();
    }

    @Test
    public void cerrarSesion() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintDosPage.cerrarSesion();
    }

    @Test
    public void agregarProducto() throws Exception {
        sprintDosPage.iniciarSesionComoAdmin();
        sprintDosPage.agregarInstrumento();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
