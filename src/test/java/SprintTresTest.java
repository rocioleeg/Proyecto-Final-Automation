
import Pages.SprintDosPage;
import Pages.SprintTresPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SprintTresTest {
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
    public void resultadosBusqueda() throws Exception {
        sprintTresPage.verResultadosBusqueda();
    }

    @Test
    public void visualizarBloqueUbicacion() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintTresPage.visualizarUbicacion();
    }

    @Test
    public void validarPoliticasDeProducto() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintTresPage.validarPoliticasDelProducto();
    }

    @Test
    public void agregarSucursal() throws Exception {
        sprintDosPage.iniciarSesionComoAdmin();
        sprintTresPage.agregarSucursal();
    }
    @Test
    public void filtroPorMarca() throws Exception {
        sprintTresPage.clickFiltroCategoriaFender();
    }
    @Test
    public void marcarFavorito() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintTresPage.marcarFavorito();
    }
    @Test
    public void eliminarFavorito() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintTresPage.desmarcarFavorito();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}