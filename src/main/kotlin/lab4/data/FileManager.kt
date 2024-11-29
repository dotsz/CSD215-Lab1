package lab4.data

import lab4.model.Task
import lab4.model.TaskStatus
import java.io.File


/**
 * Manages reading and writing tasks to a file.
 *
 * @property fileName the name of the file to read and write tasks
 */
class FileManager(private val fileName: String) {

    /**
     * Loads tasks from the file.
     *
     * @return a list of tasks
     */
    fun loadTasks(): List<Task> {
        val file = File(fileName)
        try {
            if(!file.exists()) {
                file.createNewFile() // create file if it doesn't exist
            }

            return file.readLines().map { line ->
                val status = if (line.startsWith("\u2713")) {
                    TaskStatus.Complete
                } else {
                    TaskStatus.Incomplete
                }
                Task(line.removePrefix("\u2713").trim(), status)
            }
        }catch (e: Exception) {
            println("An error occurred while reading the file.")
            return emptyList()
        }
    }

    /**
     * Saves tasks to the file.
     *
     * @param tasks the list of tasks to save
     */
    fun saveTasks(tasks: List<Task>) {
        val lines = prepareTaskLines(tasks)
        File(fileName).writeText(lines.joinToString("\n"))
    }

    /**
     * Prepares the task lines to write to the file.
     * converts the list of tasks to a list of strings
     *
     * @param tasks the list of tasks
     * @return a list of strings representing the tasks
     */
    private fun prepareTaskLines (tasks: List<Task>): List<String> {
        return tasks.map { task ->
            if (task.status is TaskStatus.Complete) {
                "\u2713 ${task.description}"
            } else {
                task.description
            }
        }
    }
}
