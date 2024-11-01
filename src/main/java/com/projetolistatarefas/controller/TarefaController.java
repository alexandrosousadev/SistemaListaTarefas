package com.projetolistatarefas.controller;

import com.projetolistatarefas.dao.TarefaDao;
import com.projetolistatarefas.model.Tarefa;

import java.util.List;

public class TarefaController {
    private TarefaDao tarefaDAO = new TarefaDao();

    public void criarTarefa(Tarefa tarefa) {
        tarefaDAO.createTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaDAO.readTarefas();
    }

    public void atualizarTarefa(Tarefa tarefa) {
        tarefaDAO.updateTarefa(tarefa);
    }

    public void excluirTarefa(int id) {
        tarefaDAO.deleteTarefa(id);
    }
}
