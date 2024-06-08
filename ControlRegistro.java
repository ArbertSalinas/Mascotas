import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import java.util.*;
import java.net.URL;

public class ControlRegistro {
    private List<Mascota> mascotas = new ArrayList();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnMostrar;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Mascota, String> colNombre;

    @FXML
    private TableColumn<Mascota, String> colEspecie;

    @FXML
    private TableColumn<Mascota, Integer> colEdad;

    @FXML
    private TableColumn<Mascota, String> colRaza;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblEdad;

    @FXML
    private Label lblNombre;

    @FXML
    private TableView<Mascota> tblMascotas;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtEspecie;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtRaza;

    @FXML
    void agregarMascota(ActionEvent event) {
        String nombre = txtNombre.getText();
        String especie = txtEspecie.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String raza = txtRaza.getText();
        
        Mascota mascota = new Mascota(nombre, especie, edad, raza);
        mascotas.add(mascota);

        // Clear input fields after adding
        txtNombre.clear();
        txtEspecie.clear();
        txtEdad.clear();
        txtRaza.clear();
        txtNombre.requestFocus();
    }

    @FXML
    void cerrarAPP(ActionEvent event) {
            Platform.exit();
    }

    @FXML
    void mostrarMascotas(ActionEvent event) {
        tblMascotas.getItems().clear();
        tblMascotas.getItems().addAll(mascotas);
    }

    @FXML
    void initialize() {
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert btnMostrar != null : "fx:id=\"btnMostrar\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert colEdad != null : "fx:id=\"colEdad\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert colEspecie != null : "fx:id=\"colEspecie\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert colRaza != null : "fx:id=\"colRaza\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert lblApellido != null : "fx:id=\"lblApellido\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert lblCodigo != null : "fx:id=\"lblCodigo\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert lblEdad != null : "fx:id=\"lblEdad\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert lblNombre != null : "fx:id=\"lblNombre\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert tblMascotas != null : "fx:id=\"tblMascotas\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert txtEdad != null : "fx:id=\"txtEdad\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert txtEspecie != null : "fx:id=\"txtEspecie\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        assert txtRaza != null : "fx:id=\"txtRaza\" was not injected: check your FXML file 'RegistroMascotas.fxml'.";
        


        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));
        
        txtNombre.requestFocus();
        txtNombre.setOnAction(event -> txtEspecie.requestFocus());
        txtEspecie.setOnAction(event -> txtEdad.requestFocus());
        txtEdad.setOnAction(event -> txtRaza.requestFocus());
        txtRaza.setOnAction(this::agregarMascota);
    }
}
