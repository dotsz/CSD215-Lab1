package lab4.presentation


/**
 * Class that handles the user interface of the application.
 *
 */
class ConsoleUI {

    /**
     * Displays the tasks in the task list.
     *
     * @param taskList The list of tasks to display.
     */
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

    /**
     * Prompts the user for an action to perform.
     *
     * @return The action the user wants to perform.
     */
    fun promptAction(): String {
        println("\nWhat would you like to do?")
        println("a - Add a task")
        println("c - Complete a task")
        println("r - Remove a task")
        println("q - Quit")
        return readlnOrNull() ?: ""
    }

    /**
     * Prompts the user for a task description.
     *
     * @return The task description entered by the user.
     */
    fun promptTaskDescription(): String {
        println("Enter a task description:")
        return readlnOrNull()?.trim()
            ?: throw IllegalArgumentException("Task description cannot be empty")
    }

    /**
     * Prompts the user for a task number.
     *
     * @return The task number entered by the user.
     */
    fun promptTaskIndex(): Int {
        println("Enter the task number:")
        return readlnOrNull()?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid task number")
    }

    /**
     * Displays a message to the user.
     *
     * @param message The message to display.
     */
    fun displayMessage(message: String) {
        println(message)
    }
}
