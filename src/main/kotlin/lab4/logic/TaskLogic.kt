package lab4.logic

import lab4.model.Task
import lab4.model.TaskStatus

object TaskLogic {
    fun addTask(taskList: List<Task>, taskDescription: String): List<Task> {
        val newTask = Task(taskDescription, TaskStatus.Incomplete)
        return taskList + newTask
    }

    fun removeTask(taskList: List<Task>, taskIndex: Int): List<Task> {
        return taskList.filterIndexed { index, _ -> index != taskIndex }
    }

    fun toggleTaskCompletion(taskList: List<Task>, taskIndex: Int): List<Task> {
        return taskList.mapIndexed { index, task ->
            if (index == taskIndex) {
                task.copy(status = if (task.status is TaskStatus.Complete) TaskStatus.Incomplete else TaskStatus.Complete)
            } else {
                task
            }
        }
    }
}
