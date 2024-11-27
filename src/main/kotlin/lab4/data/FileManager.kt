package lab4.data

import lab4.model.Task
import lab4.model.TaskStatus
import java.io.File

class FileManager(private val fileName: String) {

    fun loadTasks(): List<Task> {
        val taskList = mutableListOf<Task>()
        val file = File(fileName)

        if (file.exists()) {
            file.forEachLine { line ->
                val isComplete = line.startsWith("✓")
                val description = line.removePrefix("✓").trim()

                if (description.isNotBlank()) {
                    val status = if (isComplete) TaskStatus.Complete else TaskStatus.Incomplete
                    taskList.add(Task(description, status))
                } else {
                    throw Exception("Invalid task format: $line")
                }
            }
        }
        return taskList
    }

    fun saveTasks(tasks: List<Task>) {
        val file = File(fileName)
        file.writeText("")
        tasks.forEach { task ->
            val line = if (task.status is TaskStatus.Complete) {
                "✓ ${task.description}"
            } else {
                task.description
            }
            file.appendText("$line\n")
        }
    }
}
