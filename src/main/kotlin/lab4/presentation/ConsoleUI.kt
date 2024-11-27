package lab4.presentation

class ConsoleUI {
    fun displayTasks(taskList: List<String>) {
        if (taskList.isEmpty()) {
            println("No tasks to display")
        } else {
            println("Current Tasks:")
            taskList.forEachIndexed { index, task ->
                println("${index + 1}. $task")
            }
        }
    }

    fun promptAction(): String {
        println("\nWhat would you like to do?")
        println("a - Add a task")
        println("c - Complete a task")
        println("r - Remove a task")
        println("q - Quit")
        return readlnOrNull() ?: ""
    }

    fun promptTaskDescription(): String {
        println("Enter a task description:")
        return readlnOrNull()?.trim()
            ?: throw IllegalArgumentException("Task description cannot be empty")
    }

    fun promptTaskIndex(): Int {
        println("Enter the task number:")
        return readlnOrNull()?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid task number")
    }

    fun displayMessage(message: String) {
        println(message)
    }
}
