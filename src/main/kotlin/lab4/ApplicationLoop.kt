package lab4

import lab4.data.FileManager
import lab4.logic.TaskLogic
import lab4.model.Task
import lab4.model.TaskStatus
import lab4.presentation.ConsoleUI


/**
 * Main recursive function that runs the application.
 *
 * Maintains immutability of taskList by passing a new list on each recursive call
 *
 * @param taskList the list of tasks
 * @param fileManager the file manager to read and write tasks
 * @param ui the user interface
 * @return the list of tasks to save to file when the user quits
 *
 * base case: when the user quits, the taskList is returned to save to file
 */
fun applicationLoop (taskList: List<Task>, fileManager: FileManager, ui: ConsoleUI) : List<Task> {

    ui.displayTasks(taskList.map { task ->
        "${if (task.status is TaskStatus.Complete) "[COMPLETE]" else ""} ${task.description}"
    })

    return when (ui.promptAction()) {
        "a" -> {
            val description = ui.promptTaskDescription()
            val newTaskList = TaskLogic.addTask(taskList, description)
            applicationLoop(newTaskList, fileManager, ui)
        }
        "c" -> {
            val index = ui.promptTaskIndex()
            val newTaskList = TaskLogic.toggleTaskCompletion(taskList, index)
            applicationLoop(newTaskList, fileManager, ui)
        }
        "r" -> {
            val index = ui.promptTaskIndex()
            val newTaskList = TaskLogic.removeTask(taskList, index)
            applicationLoop(newTaskList, fileManager, ui)
        }
        "q" -> return taskList // base case: return taskList to save to file, stopping the recursion
        else -> {
            ui.displayMessage("Invalid input. Please try again.") // invalid input and calls recursively to continue the loop
            applicationLoop(taskList, fileManager, ui)
        }

    }
}
