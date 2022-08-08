import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaCrud {
    private JPanel Main;
    private JTextField textNombre;
    private JTextField textPrecio;
    private JTextField textCiudad;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextField textID;
    private JTextField textCantidad;
    private JButton limpiarButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JavaCrud");
        frame.setContentPane(new JavaCrud().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JavaCrud() {
        Connect();
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            Create();


            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Limpiar();
            }
        });
    }
    Connection con;
    PreparedStatement pst;
    public void Connect(){
        final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
        final String USERNAME="jp";
        final String PASSWORD="12345";


        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();

            System.out.println("Conexion exitosa");

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

    public void Create(){
        String nombre, precio,ciudad, id, cantidad;
        nombre=textNombre.getText();
        precio=textPrecio.getText();
        ciudad=textCiudad.getText();
        //id= textNombre.getText();
        cantidad=textCantidad.getText();
        System.out.println(nombre);
        System.out.println(precio);
        System.out.println(ciudad);
        System.out.println(id);
        System.out.println(cantidad);

        final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
        final String USERNAME="jp";
        final String PASSWORD="12345";


        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="insert into productos(pnombre, pciudad,pprecio,pcantidad)values(?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombre);
            pst.setString(2,ciudad);
            pst.setString(3,precio);
            pst.setString(4,cantidad);
            //ResultSet resultSet=pst.executeQuery();
            pst.executeUpdate();

            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

    public void Limpiar(){
        textNombre.setText("");
        textPrecio.setText("");
        textCiudad.setText("");
        textID.setText("");
        textCantidad.setText("");
    }

}
