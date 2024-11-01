package com.projetolistatarefas.dao;

import com.projetolistatarefas.config.DatabaseConnection;
import com.projetolistatarefas.model.Tarefa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDao {

    public void createTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO Tarefas (nome, custo, data_limite, ordem_apresentacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getNome());
            pstmt.setDouble(2, tarefa.getCusto());
            pstmt.setDate(3, new java.sql.Date(tarefa.getDataLimite().getTime()));
            pstmt.setInt(4, tarefa.getOrdemApresentacao());
            pstmt.executeUpdate();

            System.out.println("Tarefa inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarefa> readTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM Tarefas ORDER BY ordem_apresentacao";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tarefa tarefa = new Tarefa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("custo"),
                        rs.getDate("data_limite"),
                        rs.getInt("ordem_apresentacao")
                );
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefas;
    }

    public void updateTarefa(Tarefa tarefa) {
        String sql = "UPDATE Tarefas SET nome = ?, custo = ?, data_limite = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getNome());
            pstmt.setDouble(2, tarefa.getCusto());
            pstmt.setDate(3, new java.sql.Date(tarefa.getDataLimite().getTime()));
            pstmt.setInt(4, tarefa.getId());
            pstmt.executeUpdate();

            System.out.println("Tarefa atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTarefa(int id) {
        String sql = "DELETE FROM Tarefas WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Tarefa excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
