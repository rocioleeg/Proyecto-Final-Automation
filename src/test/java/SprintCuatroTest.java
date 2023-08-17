import Pages.Base;
import Pages.SprintCuatroPage;
import Pages.SprintDosPage;
import Pages.SprintTresPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SprintCuatroTest {

    private WebDriver driver;
    private SprintDosPage sprintDosPage;
    private SprintTresPage sprintTresPage;
    Base base;
    private SprintCuatroPage sprintCuatroPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "../AutomatizacionDigitalBooking/chromedriver_win3/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sprintDosPage = new SprintDosPage(driver);
        sprintDosPage.visit("http://g2c5-frontnode.s3-website.us-east-2.amazonaws.com/home");
        sprintTresPage = new SprintTresPage(driver);
        sprintCuatroPage = new SprintCuatroPage(driver);
    }

    @Test
    public void seccionReserva() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintTresPage.verResultadosBusqueda();
        sprintCuatroPage.ingresarAReservaDeProducto();

    }
    @Test
    public void seleccionarFechasDisponibles() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintTresPage.verResultadosBusqueda();
        sprintCuatroPage.ingresarAReservaDeProducto();
        sprintCuatroPage.seleccionarFechas(22, 24);
    }

    @Test
    public void validarDetallesReserva() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintTresPage.verResultadosBusqueda();
        sprintCuatroPage.ingresarAReservaDeProducto();
        sprintCuatroPage.validarDetalleReserva();
    }

    @Test
    public void validarHistorialReservas() throws Exception {
        sprintDosPage.iniciarSesionUser();
        sprintCuatroPage.verificarHistorialReservas();
    }

}
