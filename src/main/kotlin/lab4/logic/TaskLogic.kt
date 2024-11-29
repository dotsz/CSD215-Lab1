package lab4.logic

import lab4.model.Task
import lab4.model.TaskStatus


/**
 * Handles the logic for managing tasks.
 *
 * @param taskList the list of tasks
 * @param description the description of the new task
 * @param taskIndex the index of the task to modify/remove
 * @return the updated list of tasks
 *
 */
object TaskLogic { // object instead of class because it doesn't need multiple instances, singleton object

    // Add a new task
    fun addTask(taskList: List<Task>, description: String): List<Task> {
        return taskList + Task(description, TaskStatus.Incomplete) // create a new list with the new task added
    }

    // Remove a task
    fun removeTask(taskList: List<Task>, taskIndex: Int): List<Task> {
        if (taskIndex !in taskList.indices) {
            return taskList // Return the original list if index is invalid
        }
        return taskList.filterIndexed { index, _ -> index != taskIndex } // create a new list without the task that matches the index
    }

    // Toggle task completion
    fun toggleTaskCompletion(taskList: List<Task>, taskIndex: Int): List<Task> {
        if (taskIndex !in taskList.indices) {
            return taskList // Return the original list if index is invalid
        }
        return taskList.mapIndexed { index, task ->
            if (index == taskIndex) {
                task.copy(
                    status = when (task.status) {
                        TaskStatus.Incomplete -> TaskStatus.Complete
                        TaskStatus.Complete -> TaskStatus.Incomplete
                    }
                )
            } else {
                task
            } // create a new list with the task at the index toggled
        }
    }
}
