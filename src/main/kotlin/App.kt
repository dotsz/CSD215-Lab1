import java.io.File

data class Task(val taskDescription: String, val isComplete: Boolean)

/**
    Simple Kotlin ToDo List App
    This app allows the user to add, complete, and remove tasks from a list
**/
fun main() {


    println("Welcome to the Kotlin ToDo List App")
    println("---------------------------------")

    // Load tasks from text file and make a list of Task objects
    loadTasksFromFile()



    // Main loop that will keep the app running until the user decides to quit
    while(true){
        val input = promptForInput()
        when(input){
            "a" -> addTask()
            "c" -> toggleTaskCompletion()
            "r" -> removeTask()
            "q" -> quit()
            else -> println("Invalid input. Please try again.")
        }
    }

}


fun loadTasksFromFile(): List<Task> {
    val tasks = listOf<Task>()
    val file = File("tasks.txt")
    if(file.exists()){
        file.forEachLine {
            // parse strings from file and create Task objects
        }

    }
    return tasks
}


/**
    Function to prompt the user for input
    @return the user's input as a String, or null if the input is null
**/
fun promptForInput(): String? {
    println("What would you like to do? ")
    println("a - Add a task")
    println("c - Complete a task")
    println("r - Remove a task")
    println("q - Quit")
    return readlnOrNull()
}

/**
    Prompts the user to add a task.
    @return the task description as a String, or null if the input is null
**/
fun addTask() : List<Task> {
    println("Enter task description: ")
    val taskDescription = readlnOrNull()?: return emptyList()

    val newTask = Task(taskDescription, false)

    val tasks = listOf(newTask)

    return tasks
}

/**
  toggle task boolean value to true or false
 **/
fun toggleTaskCompletion() {
    // some logic to toggle the completion status of a task
}
/**
    remove task from the list
 **/
fun removeTask() {
    // some logic to remove a task from the list
}

fun quit(){
    // logic to save the task data class to a text file


}



