package com.example.TP2.service;
import com.example.TP2.model.Task;
import com.example.TP2.DAO.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Méthode pour créer une nouvelle tâche
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Méthode pour récupérer toutes les tâches
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Méthode pour récupérer une tâche par ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Méthode pour mettre à jour une tâche par ID
    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTaskOpt = taskRepository.findById(id);
        if (existingTaskOpt.isPresent()) {
            Task existingTask = existingTaskOpt.get();
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            // Notez que la date de création ne doit généralement pas être modifiée
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer une tâche par ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
