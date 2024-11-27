package lab4

import lab4.logic.TaskLogic
import lab4.presentation.ConsoleUI
import lab4.data.FileManager
import lab4.model.TaskStatus

fun main() {
    val fileManager = FileManager("tasks.txt")
    val ui = ConsoleUI()

    var taskList = fileManager.loadTasks()

    ui.displayMessage("Welcome to the Kotlin ToDo List App")
    ui.displayMessage("---------------------------------")

    while (true) {
        ui.displayTasks(taskList.map { task ->
            "${if (task.status is TaskStatus.Complete) "[COMPLETE]" else ""} ${task.description}"
        })

        when (ui.promptAction()) {
            "a" -> {
                try {
                    val description = ui.promptTaskDescription()
                    taskList = TaskLogic.addTask(taskList, description)
                    ui.displayMessage("Task added!")
                } catch (e: Exception) {
                    ui.displayMessage(e.message ?: "An error occurred")
                }
            }

            "c" -> {
                try {
                    val index = ui.promptTaskIndex()
                    taskList = TaskLogic.toggleTaskCompletion(taskList, index - 1)
                    ui.displayMessage("Task updated!")
                } catch (e: Exception) {
                    ui.displayMessage(e.message ?: "An error occurred")
                }
            }

            "r" -> {
                try {
                    val index = ui.promptTaskIndex()
                    taskList = TaskLogic.removeTask(taskList, index - 1)
                    ui.displayMessage("Task removed!")
                } catch (e: Exception) {
                    ui.displayMessage(e.message ?: "An error occurred")
                }
            }

            "q" -> {
                fileManager.saveTasks(taskList)
                ui.displayMessage("Goodbye!")
                break
            }

            else -> {
                ui.displayMessage("Invalid input. Please try again.")
            }
        }
    }
}
