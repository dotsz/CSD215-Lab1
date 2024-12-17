package lab1


import lab1.presentation.ConsoleUI
import lab1.data.FileManager
import lab1.model.Task


/**
 * Main function that runs the application.
 * initializes file manager, UI, and task list
 */
fun main() {
    val fileManager = FileManager("tasks.txt")
    val ui = ConsoleUI()

    val initialTaskList: List<Task> = fileManager.loadTasks()

    val finalTaskList = applicationLoop(initialTaskList, fileManager, ui)

    fileManager.saveTasks(finalTaskList)

    ui.displayMessage("Tasks saved to file. Application closing.")
}


