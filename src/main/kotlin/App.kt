import java.io.File

data class Task(val taskDescription: String, val isComplete: Boolean)


/**
    Simple Kotlin ToDo List App
    This app allows the user to add, complete, and remove tasks from a list
**/
fun main() {

    // initialize an empty list of tasks
    var taskList: List<Task> = listOf()

    println("Welcome to the Kotlin ToDo List App")
    println("---------------------------------")

    // Load tasks from text file

    taskList = loadTasksFromFile("tasks.txt")

    // Main loop that will keep the app running until the user decides to quit
    while(true){
        println("\nCurrent Tasks: ")
        if (taskList.isEmpty()){
            println("No tasks to display")
        } else {
            taskList.forEachIndexed { index, task ->
                println("${index + 1}. ${if(task.isComplete) "[COMPLETE] - " else ""}${task.taskDescription}")
            }
        }
        println("\n What would you like to do? ")
        println("a - Add a task")
        println("c - Complete a task")
        println("r - Remove a task")
        println("q - Quit\n")

        val input = readlnOrNull()
        when(input){
            "a" -> {
                println("Enter a task description: ")
                val taskDescription = readlnOrNull()?.trim()
                if (!taskDescription.isNullOrEmpty()){
                        taskList = addTask(taskList, taskDescription)
                        println("Task added: $taskDescription")
                } else {
                    println("Task description cannot be empty or only spaces. Please try again.")
                }
            }

            "c" -> {
                println("Which task would you like to complete? Enter the number: ")
                val taskIndex = readlnOrNull()?.toIntOrNull()
                if (taskIndex != null && taskIndex > 0 && taskIndex <= taskList.size){
                    val selectedTask = taskList[taskIndex - 1]
                    if(selectedTask.isComplete){
                        println("Task: ${selectedTask.taskDescription} is already marked as completed")
                    } else {
                        taskList = toggleTaskCompletion(taskList, taskIndex - 1)
                        println("Task: ${selectedTask.taskDescription} completed")
                    }
                }
                else{
                    println("Invalid task number. Please try again.")
                }
            }

            "r" -> {
                if(taskList.isEmpty()){
                    println("No tasks to remove")
                } else{
                    println("Enter the number of the task you would like to remove: ")
                    val taskIndex = readlnOrNull()?.toIntOrNull()
                    if (taskIndex != null && taskIndex > 0 && taskIndex <= taskList.size){
                        taskList = removeTask(taskList, taskIndex - 1)
                        println("Task removed")
                    } else {
                        println("Invalid task number. Please try again.")
                    }
                }
            }

            "q" -> {
                println("Saving task to file...")
                saveTasksToFile(taskList, "tasks.txt")
                println("Goodbye!")
                break
            }
            else -> {
                println("Invalid input. Please try again.")
            }
        }
    }

}


/**
 * function to add a task to an immutable list of tasks
 * @param taskList: List<Task> - the current list of tasks
 * @param taskDescription: String - the description of the task to be added
 * @return List<Task> - the updated list of tasks
 */
fun addTask(taskList: List<Task>, taskDescription: String) : List<Task> {
    val newTask = Task(taskDescription, false)
    val updatedTaskList = taskList + newTask
    return updatedTaskList
}

/**
 * function to remove a task from an immutable list of tasks
 * @param taskList: List<Task> - the current list of tasks
 * @param taskIndex: Int - the index of the task to be removed
 * @return List<Task> - the updated list of tasks
 */
fun removeTask(taskList: List<Task>, taskIndex: Int) : List<Task> {
    val updatedTaskList = taskList.filterIndexed { index, _ -> index != taskIndex }
    return updatedTaskList
}
/**
 * function to toggle the completion status of a task in an immutable list of tasks
 * @param taskList: List<Task> - the current list of tasks
 * @param taskIndex: Int - the index of the task to be toggled
 * @return List<Task> - the updated list of tasks
 */
fun toggleTaskCompletion(taskList: List<Task>, taskIndex: Int) : List<Task> {
    val updatedTaskList = taskList.mapIndexed { index, task ->
        if (index == taskIndex){
            task.copy(isComplete = !task.isComplete)
        } else {
            task
        }
    }
    return updatedTaskList
}

/**
 * function to save tasks to a text file
 * @param taskList: List<Task> - the list of tasks to be saved
 * @param fileName: String - the name of the file to save the tasks to
 */
fun saveTasksToFile(taskList: List<Task>, fileName: String){
    val file = File(fileName)
    file.writeText("")
    taskList.forEach { task ->
            file.appendText("${if(task.isComplete) "\u2713" else ""} ${task.taskDescription}\n")
    }
}

/**
 * function to load tasks from a text file
 * @param fileName: String - the name of the file to load tasks from
 * @return List<Task> - the list of tasks loaded from the file
 */
fun loadTasksFromFile(fileName: String) : List<Task> {
    val file = File(fileName)
    val taskList = mutableListOf<Task>()

    if(file.exists()){
        file.forEachLine {
            if(it.startsWith("\u2713")){
                taskList.add(Task(it.substringAfter(" "), true))
            } else {
                taskList.add(Task(it, false))
            }
        }
    }
    return taskList
}




