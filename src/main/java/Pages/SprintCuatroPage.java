package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SprintCuatroPage extends Base {

    public SprintCuatroPage(WebDriver driver) {
        super(driver);
    }

    By clickCardProducto = By.xpath("(//*[@class='card-img-top card-image'])[1]");
    By botonReservar = By.xpath("//button[@class='btn-reservar btn btn-primary']");
    By validarTituloCompletaTusdatos = By.xpath("//h4[text()= 'Completa tus datos']");
    By validarTituloDetalleReserva = By.xpath("//*[text()='Detalles de la reserva']");

    By validarTituloDeProducto = By.xpath("//div[@class=\"card-title h5\"]");
    By validarTituloDireccion = By.xpath("  //*[text()='Dirección: ']");
    By validarFechaRetiro = By.xpath("//*[text()='Fecha de retiro:']");
    By validarFechaDevolucion = By.xpath(" //*[text()='Fecha de devolución:']");
    By validarTotal = By.xpath("//*[text()='Total: ']");
    By botonMenu = By.xpath("//button[text()='Menú']");
    By getMisReservas = By.xpath("   //*[text()='Mis reservas']");
    By getTablaHistorial= By.xpath("//*[@class=\"table-user-reservations-container\"]");
    public void ingresarAReservaDeProducto() throws Exception {
        //waitForElementClickable(By.xpath("(//*[@class='card-img-top card-image'])[1]"));
        Thread.sleep(4000);
        click(clickCardProducto);
        Thread.sleep(1000);
        scrollTo(By.xpath("//button[@class='btn-reservar btn btn-primary']"));
        Thread.sleep(1000);
        scrollDown();
        click(botonReservar);
        isDisplayed(validarTituloCompletaTusdatos);
    }


    private By getFecha(int dia) {
        return By.xpath(String.format("//div[@class='rmdp-day ']/descendant::span[contains(text(), '%s')]", dia));
    }

    public void seleccionarFechas(int diaDesde, int diaHasta) throws Exception {
        try {
            waitForElement(By.xpath("//*[text()='Selecciona la fecha de reserva']"));
            scrollTo(By.xpath("//*[text()='Selecciona la fecha de reserva']"));

            WebElement fechaDesde = driver.findElement(getFecha(diaDesde));
            fechaDesde.click();
            WebElement fechaHasta = driver.findElement(getFecha(diaHasta));
            fechaHasta.click();

        } catch (Exception e) {
            throw new Exception("Error al seleccionar fecha: " + e.getMessage());
        }
    }

    public void validarDetalleReserva() throws Exception {
        isDisplayed(validarTituloDetalleReserva);
        scrollTo(By.xpath("//div[@class=\"card-title h5\"]"));
        isDisplayed(validarTituloDeProducto);
        isDisplayed(validarTituloDireccion);
        isDisplayed(validarFechaDevolucion);
        isDisplayed(validarFechaRetiro);
        isDisplayed(validarTotal);
    }

    public void verificarHistorialReservas() throws Exception {
        Thread.sleep(1000);
        click(botonMenu);
        click(getMisReservas);
        waitForElement(By.xpath("//*[@class='table-user-reservations-container']"));
        isDisplayed(By.xpath("//*[text()='Mis Reservas']"));
        isDisplayed(getTablaHistorial);
    }
}
