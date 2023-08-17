package Pages;

import org.openqa.selenium.*;

public class SprintDosPage extends Base {

    By botonIniciarSesion = By.xpath("//button[text()= 'Iniciar sesión']");
    By inputEmailLocator = By.xpath("//input[@placeholder= 'Email']");
    By inputContraseñaLocator = By.xpath("//input[@placeholder= 'Contraseña']");
    By botonEnviarFormularioLocator = By.xpath("//button[text()='Ingresar']");
    By validacionDeLoginHolaAdmin = By.xpath("//*[contains(text(), 'Hola, ')]");

    public SprintDosPage(WebDriver driver) {
        super(driver);
    }

    public void iniciarSesionComoAdmin() throws Exception {
        click(botonIniciarSesion);
        scrollTo(By.xpath("//button[text()='Ingresar']"));
        Thread.sleep(1000);
        type("digitalbooking.02@gmail.com", inputEmailLocator);
        type("admin", inputContraseñaLocator);
        click(botonEnviarFormularioLocator);
        waitForElement(By.xpath("//*[contains(text(), 'Hola, ')]"));
        isDisplayed(validacionDeLoginHolaAdmin);
    }

    public void iniciarSesionUser() throws Exception {
        click(botonIniciarSesion);
        scrollTo(By.xpath("//button[text()='Ingresar']"));
        Thread.sleep(1000);
        type("jorgekalas@gmail.com", inputEmailLocator);
        type("A1234567", inputContraseñaLocator);
        click(botonEnviarFormularioLocator);
        waitForElementClickable(By.xpath("//input[@placeholder='¿Qué instrumento estás buscando?']"));
    }

    By botonCrearCuentaLocator = By.xpath("//button[text()= 'Crear cuenta']");
    By inputApellidoLocator = By.xpath("//input[@placeholder= 'Apellido']");
    By inputRepetirContraseñaLocator = By.xpath("//input[@placeholder='Repetir Contraseña']");
    By checkboxMAyorde18 = By.xpath("//input[@type='checkbox']");
    By crearCuentaForm = By.xpath("(//button[text()='Crear cuenta'])[2]");
    By confirmacionDeCreacionCuenta = By.xpath("//*[contains(text(), 'Te enviamos un correo electrónico para ')]");

    public void crearCuenta() throws Exception {
        click(botonCrearCuentaLocator);
        //   type("rocio", inputNombreLocator);
        type("lee", inputApellidoLocator);
        type("rocio1243@gmail.com", inputEmailLocator);
        type("A12345678", inputContraseñaLocator);
        scrollTo(By.xpath("//input[@type='checkbox']"));
        Thread.sleep(1000);
        type("A12345678", inputRepetirContraseñaLocator);
        click(checkboxMAyorde18);
        click(crearCuentaForm);
        isDisplayed(confirmacionDeCreacionCuenta);
    }

    By botonMenu = By.xpath("//button[text()='Menú']");
    By botonCerrarSesion = By.xpath("//a[text()='Cerrar sesión']");

    public void cerrarSesion() throws Exception {
        Thread.sleep(2000);
        click(botonMenu);
        click(botonCerrarSesion);
    }

    By clickBotonPanelAdmin = By.xpath("//*[text()='Panel de Admin']");
    By botonAgregarInstrumentoDesdeAdmin = By.xpath("//*[@href='/admin/agregar-producto']");
    By inputTituloProducto = By.xpath("//input[@placeholder='Título']");
    By inputDescripcion = By.xpath("//*[@placeholder='Descripción']");
    By inputPrecio = By.xpath("//input[@placeholder='Precio']");
    By inputStock = By.xpath("//input[@placeholder='Stock']");
    By inputURLImg = By.xpath("//input[@placeholder='URL imagen']");
    By botonAgregarInstrumentoForm = By.xpath("//button[text()='Agregar instrumento']");
    By desplegableMarca = By.xpath("(//select[@class='form-select'])[1]");
    By seleccionMarca = By.xpath("//option[@value='Fender']");
    By desplegableCategoria = By.xpath("(//select[@class='form-select'])[2]");
    By seleccionCategoria = By.xpath("//option[@value='Viento']");
    By desplegableSucursal = By.xpath("(//select[@class='form-select'])[3]");
    By seleccionSucursal = By.xpath("//option[@value='Burbujas']");

    public void agregarInstrumento() throws Exception {
        click(botonMenu);
        click(clickBotonPanelAdmin);
        click(botonAgregarInstrumentoDesdeAdmin);
        type("Prueba", inputTituloProducto);
        scrollTo(By.xpath("//input[@placeholder='Precio']"));
        Thread.sleep(2000);
        type("Probando desde Automatizacion", inputDescripcion);
        type("20", inputPrecio);
        type("5", inputStock);
        click(desplegableMarca);
        click(seleccionMarca);
        click(desplegableCategoria);
        click(seleccionCategoria);
        click(desplegableSucursal);
        click(seleccionSucursal);
        click(botonAgregarInstrumentoForm);

    }

}
