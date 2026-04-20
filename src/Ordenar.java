import java.sql.*;

public class Ordenar {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        String sql = "SELECT SALARIO " +
                " FROM EJEMPLOCONEXION " +
                " ORDER BY SALARIO DESC";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement();) {

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                double salario = rs.getDouble("salario");
                System.out.println("Salario ordenado: " + salario);
            }

        }catch(SQLException e ){
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}