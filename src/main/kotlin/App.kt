
/**
    Simple Kotlin ToDo List App
    This app allows the user to add, complete, and remove tasks from a list
**/
fun main() {

    // a data class that represents a task
    data class Tasks(val taskDescription: String, val isComplete: Boolean)

    println("Welcome to the Kotlin ToDo List App")
    println("---------------------------------")

    // Main loop that will keep the app running until the user decides to quit
    while(true){
        val input = promptForInput()
        when(input){
            "a" -> addTask()
            "c" -> println("Complete a task")
            "r" -> println("Remove a task")
            "q" -> {
                println("Goodbye!")
                break
            }
            else -> println("Invalid input. Please try again.")
        }
    }

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
fun addTask() {
    println("Enter task description: ")

    // some logic to add the task to an immutable list
    // copy the list to add new task
}

/**
  toggle task boolean value to true or false
 **/
fun toggleTaskCompletion() {
    // some logic to toggle the completion status of a task
}

fun removeTask() {
    // some logic to remove a task from the list
}

fun quit(){
    // logic to save the task data class to a text file
}



