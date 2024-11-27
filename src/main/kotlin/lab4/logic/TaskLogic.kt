package lab4.logic

import lab4.model.Task
import lab4.model.TaskStatus

/**
 * Contains the business logic for managing tasks.
 *
 */
object TaskLogic {
    /**
     * Adds a new task to the list.
     *
     * @param taskList the list of tasks
     * @param taskDescription the description of the new task
     * @return the updated list of tasks
     */
    fun addTask(taskList: List<Task>, taskDescription: String): List<Task> {
        val newTask = Task(taskDescription, TaskStatus.Incomplete)
        return taskList + newTask
    }

    /**
     * Removes a task from the list.
     *
     * @param taskList the list of tasks
     * @param taskIndex the index of the task to remove
     * @return the updated list of tasks
     */
    fun removeTask(taskList: List<Task>, taskIndex: Int): List<Task> {
        return taskList.filterIndexed { index, _ -> index != taskIndex }
    }

    /**
     * Toggles the completion status of a task.
     *
     * @param taskList the list of tasks
     * @param taskIndex the index of the task to update
     * @return the updated list of tasks
     */
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
