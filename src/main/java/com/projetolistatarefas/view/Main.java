package com.projetolistatarefas.view;

import com.projetolistatarefas.controller.TarefaController;
import com.projetolistatarefas.model.Tarefa;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TarefaController tarefaController = new TarefaController();

        // Criar uma nova tarefa
        Tarefa novaTarefa = new Tarefa(2, "Tarefa de Exemplo", 500.0, new Date(), 1);
        tarefaController.criarTarefa(novaTarefa);

        // Listar todas as tarefas
        List<Tarefa> tarefas = tarefaController.listarTarefas();
        for (Tarefa tarefa : tarefas) {
            System.out.println("ID: " + tarefa.getId() + ", Nome: " + tarefa.getNome() + ", Custo: " + tarefa.getCusto());
        }

        // Atualizar uma tarefa
        novaTarefa.setNome("Tarefa Atualizada");
        tarefaController.atualizarTarefa(novaTarefa);

        // Excluir uma tarefa
        tarefaController.excluirTarefa(novaTarefa.getId());
    }
}
