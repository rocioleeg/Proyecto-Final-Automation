package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SprintTresPage extends Base {
    By inputBuscadorInstrumentos = By.xpath("//input[@placeholder='¿Qué instrumento estás buscando?']");
    By clickBuscar = By.xpath(("//button[@type='submit']"));
    By validacionResultadoBusqueda = By.xpath("(//img[contains(@class, 'card')])[2]");

    public SprintTresPage(WebDriver driver) {
        super(driver);
    }

    public void verResultadosBusqueda() throws Exception {
        waitForElementClickable(By.xpath("//input[@placeholder='¿Qué instrumento estás buscando?']"));
        click(inputBuscadorInstrumentos);
        sendKeys("guitarra", inputBuscadorInstrumentos);
        Thread.sleep(1000);
        click(clickBuscar);
        isDisplayed(validacionResultadoBusqueda);

    }

    By seleccionarPrimerInstrumento = By.xpath("(//div[contains(@class, 'instrument')])[1]");
    By visualizarBloqueUbicacion = By.xpath("//div[@class='.subheader-direccion']");

    public void visualizarUbicacion() throws Exception {
        waitForElementClickable(By.xpath("//input[@placeholder='¿Qué instrumento estás buscando?']"));
        click(inputBuscadorInstrumentos);
        sendKeys("guitarra", inputBuscadorInstrumentos);
        Thread.sleep(1000);
        click(clickBuscar);
        waitForElement(By.xpath("(//img[contains(@class, 'card')])[2]"));
        scrollTo(By.xpath("(//img[contains(@class, 'card')])[2]"));
        click(validacionResultadoBusqueda);
        isDisplayed(visualizarBloqueUbicacion);

    }

    By visualizarPoliticasdeProducto = By.xpath("//*[contains(text(),'Políticas')]");

    public void validarPoliticasDelProducto() throws Exception {
        waitForElementClickable(By.xpath("//input[@placeholder='¿Qué instrumento estás buscando?']"));
        click(inputBuscadorInstrumentos);
        sendKeys("guitarra", inputBuscadorInstrumentos);
        Thread.sleep(1000);
        click(clickBuscar);
        waitForElement(By.xpath("(//img[contains(@class, 'card')])[2]"));
        scrollTo(By.xpath("(//img[contains(@class, 'card')])[2]"));
        click(validacionResultadoBusqueda);
        Thread.sleep(3000);
        scrollTo(By.xpath("//*[contains(text(),'Políticas')]"));
        isDisplayed(visualizarPoliticasdeProducto);
    }

    By botonMenu = By.xpath("//button[text()='Menú']");
    By clickBotonPanelAdmin = By.xpath("//*[text()='Panel de Admin']");
    By agregarSucursal = By.xpath(" (//*[text()='Agregar sucursal'])[1]");
    By inputNombreLocator = By.xpath("//input[@placeholder= 'Nombre']");
    By getInputDireccion = By.xpath("//input[@placeholder= 'Dirección']");
    By getInputLatitud = By.xpath("//input[@placeholder= 'Latitud']");
    By getInputLongitud = By.xpath("//input[@placeholder= 'Longitud']");
    By botonAgregarSucursal = By.xpath("//button[text()='Agregar sucursal']");
    By gestionarSucursales = By.xpath("//*[@href='/admin/gestionar-sucursales']");

    public void agregarSucursal() throws Exception {
        waitForElement(By.xpath("//button[text()='Menú']"));
        click(botonMenu);
        click(clickBotonPanelAdmin);
        waitClickElement(By.xpath("//a[@href='#' and text()='Sucursales'][1]"));
        click(agregarSucursal);
        sendKeys("prueba automation", inputNombreLocator);
        sendKeys("pruebaAutomation", getInputDireccion);
        sendKeys("1", getInputLatitud);
        sendKeys("1", getInputLongitud);
        waitForElement(By.xpath("//button[text()='Agregar sucursal']"));
        scrollTo(By.xpath("//button[text()='Agregar sucursal']"));
        click(botonAgregarSucursal);
    }

    public void gestionarSucursal() throws Exception {
        waitForElement(By.xpath("//button[text()='Menú']"));
        click(botonMenu);
        click(clickBotonPanelAdmin);
        waitClickElement(By.xpath("//a[@href='#' and text()='Sucursales'][1]"));
        click(gestionarSucursales);
        //metodo editar
    }

    By filtroCategoriaFender = By.xpath("(//img[@alt='Fender'])[1]");
    By tituloResultadosBusqueda = By.xpath("//*[text()='Resultados de la búsqueda']");

    public void clickFiltroCategoriaFender() throws Exception {
        waitForElement(By.xpath("(//img[@alt='Fender'])[1]"));
        click(filtroCategoriaFender);
        Thread.sleep(500);
        Assert.assertTrue("No se encuentran el titulo resultados busqueda", isDisplayed(tituloResultadosBusqueda));

    }
    By getButtonFavorito = By.xpath("(//div[@class='heart-fav-button'])[1]");
    By desplegableMenuFavoritos = By.xpath("//a[@href='/favoritos']");

    public void marcarFavorito() throws Exception {

        waitForElement(By.xpath("(//img[@alt='Fender'])[1]"));
        click(filtroCategoriaFender);
        scrollTo(By.xpath("(//div[@class='heart-fav-button'])[1]"));
        waitForElementClickable(By.xpath("(//div[@class='heart-fav-button'])[1]"));
        click(getButtonFavorito);

        Thread.sleep(1000);
        click(botonMenu);
        click(desplegableMenuFavoritos);

    }
    public void desmarcarFavorito() throws Exception {

        waitForElement(By.xpath("(//img[@alt='Fender'])[1]"));
        click(filtroCategoriaFender);
        scrollTo(By.xpath("(//div[@class='heart-fav-button'])[1]"));
        waitForElementClickable(By.xpath("(//div[@class='heart-fav-button'])[1]"));
        click(getButtonFavorito);

        Thread.sleep(1000);
        click(botonMenu);
        click(desplegableMenuFavoritos);
        click(getButtonFavorito);
    }

}