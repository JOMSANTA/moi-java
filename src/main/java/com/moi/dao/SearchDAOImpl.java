package com.moi.dao;

import com.moi.model.SearchModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDAOImpl implements SearchDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("falla en el jbdc driver");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public SearchModel getProductByName(String producto) {
        SearchModel search = null;

        String InsertQuery = "SELECT * FROM inventario_oficina WHERE producto = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(InsertQuery)) {

            preparedStatement.setString(1,producto);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                search = new SearchModel();
                search.setProducto(resultSet.getString("producto"));
                search.setColor(resultSet.getString("color"));
                search.setNumeroExistencias(resultSet.getInt("numeroExistencias"));
                search.setCodigo(resultSet.getString("codigo"));
                search.setImei(resultSet.getLong("imei"));
                search.setFechaLimiteVenta(resultSet.getString("fechaLimiteVenta"));
                search.setTipoDeProducto(resultSet.getString("tipoDeProducto"));
            }

        }catch (SQLException e){
            System.out.println("Error al obtener producto por nombre" + e.getMessage());
        }
         return search;
    }

    @Override
    public SearchModel getProductByImei(long imeiProducto) {
        return null;
    }

    @Override
    public SearchModel getProductByCodigo(String codigo) {
        return null;
    }

    @Override
    public SearchModel getProductByColor(String colorProducto) {
        return null;
    }


    public List<SearchModel> searchProducts(String producto, String color, String imei, String codigo) {
        List<SearchModel> productos = new ArrayList<>();

        // Comienza la conexión a la base de datos
        try (Connection conn = getConnection()) {
            // Construir la consulta SQL
            StringBuilder query = new StringBuilder("SELECT * FROM inventario_oficina WHERE 1=1");

            // Agregar condiciones según los parámetros no nulos
            if (producto != null && !producto.trim().isEmpty()) {
                query.append(" AND nombre LIKE ?");
            }
            if (color != null && !color.trim().isEmpty()) {
                query.append(" AND color LIKE ?");
            }
            if (imei != null && !imei.trim().isEmpty()) {
                query.append(" AND imei LIKE ?");
            }
            if (codigo != null && !codigo.trim().isEmpty()) {
                query.append(" AND codigo LIKE ?");
            }

            // Preparar la sentencia SQL
            try (PreparedStatement stmt = conn.prepareStatement(query.toString())) {

                // Establecer los parámetros dinámicos
                int index = 1;
                if (producto != null && !producto.trim().isEmpty()) {
                    stmt.setString(index++, "%" + producto + "%");  // Para búsqueda parcial
                }
                if (color != null && !color.trim().isEmpty()) {
                    stmt.setString(index++, "%" + color + "%");  // Para búsqueda parcial
                }
                if (imei != null && !imei.trim().isEmpty()) {
                    stmt.setString(index++, "%" + imei + "%");  // Para búsqueda parcial
                }
                if (codigo != null && !codigo.trim().isEmpty()) {
                    stmt.setString(index++, "%" + codigo + "%");  // Para búsqueda parcial
                }

                // Ejecutar la consulta
                try (ResultSet rs = stmt.executeQuery()) {
                    // Iterar a través de los resultados y agregarlos a la lista
                    while (rs.next()) {
                        SearchModel productoEncontrado = new SearchModel();
                        productoEncontrado.setProducto(rs.getString("nombre"));
                        productoEncontrado.setColor(rs.getString("color"));
                        productoEncontrado.setImei(rs.getLong("imei"));
                        productoEncontrado.setCodigo(rs.getString("codigo"));
                        // Agregar el producto a la lista
                        productos.add(productoEncontrado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores, por ejemplo, lanzar una excepción personalizada
        }

        return productos;  // Retorna la lista de productos encontrados
    }


}
