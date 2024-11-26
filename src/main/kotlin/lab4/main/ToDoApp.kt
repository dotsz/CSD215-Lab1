package lab4.main

import lab4.logic.FileManager
import lab4.model.TaskList
import lab4.model.Task

/**
 * ToDo App class that will run the app
 */
class ToDoApp {
    private val taskList = TaskList()
    private val fileManager = FileManager()
    private val fileName = "tasks.txt"
    val tasksFromFile = fileManager.loadFromFile(fileName)



    fun run() {

        println("Welcome to the To-Do App!")

        val menu = """
            |a. Add a task
            |c. Complete a task
            |r. Remove a task
            |q. Quit
        """.trimMargin()


        while(true){


            println(menu)
            val choice = readlnOrNull()
            when(choice){
                "a" -> {
                    println("Enter a task description: ")
                    val taskDescription = readlnOrNull()?.trim()
                    if (!taskDescription.isNullOrEmpty()){
                        val newTask = Task(taskDescription)
                        tasksFromFile = taskList.addTask(tasksFromFile, newTask)
                        println("Task added: $taskDescription")
                    } else {
                        println("Task description cannot be empty or only spaces. Please try again.")
                    }
                }
            }

        }
    }

    fun listTasks( listOfTasks: List<Task>){
        if(listOfTasks.isEmpty()){
            println("No tasks to display")
        } else {
            listOfTasks.forEachIndexed { index, task ->
                println("${index + 1}. ${if(task.isComplete) "[COMPLETE] - " else ""}${task.description}")
            }
        }
    }
}