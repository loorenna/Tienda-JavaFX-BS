package org.example.tareafxconbs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Platform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {
    @FXML
    public TableView<Producto> tblProductos;
    @FXML
    public TableColumn<Producto,Integer> colId;
    @FXML
    public TableColumn<Producto,String> colNombre;
    @FXML
    public TableColumn<Producto,Double> colPrecio;
    @FXML
    public TableColumn<Producto,Integer> colStock;
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtPrecio;
    @FXML
    public TextField txtStock;
    @FXML
    public Button btnGuardar;
    @FXML
    public Button btnMostrar;
    @FXML
    public Button btnLimpiar;
    @FXML
    public Button btnSalir;
    @FXML
    public Label txtMsj;

    @FXML
    public  void guardar(){
        if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtStock.getText().isEmpty()){
            txtMsj.setText("Complete todos los campos");
            return;
        }
        String sql="INSERT INTO productos(nombre,precio,stock) VALUES (?,?,?)";
        try (
            Connection con=Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql)){
            ps.setString(1,txtNombre.getText());
            ps.setDouble(2,Double.parseDouble(txtPrecio.getText()));
            ps.setInt(3,Integer.parseInt(txtStock.getText()));
            ps.executeUpdate();
            txtMsj.setText("Producto guardado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void limpiar(){
        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();
        txtMsj.setText("");
        txtNombre.requestFocus();
    }
    @FXML
    public void mostrar(){
        ObservableList<Producto> productos= FXCollections.observableArrayList();
        String sql="SELECT*FROM productos";
        try (
            Connection con=Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery()){
            while (rs.next()){
                productos.add(new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getDouble("precio"),rs.getInt("stock")));
            }
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
            colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

            tblProductos.setItems(productos);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void salir(){
        Platform.exit();
    }
}
