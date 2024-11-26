package lab4.logic

import lab4.model.Task

import java.io.File

class FileManager {

    private fun createAFile(fileName: String) {
        val file = File(fileName)
        file.createNewFile()
    }

    fun loadFromFile(fileName: String): List<Task> {
        val listOfTasks = mutableListOf<Task>()
        try {
            if (!File(fileName).exists()) {
                createAFile(fileName)
            }

            File(fileName).forEachLine {
                val task = it.split(",")
                if (task.size != 2) {
                    throw Exception("Invalid file format")
                }
                listOfTasks.add(Task(task[0], task[1].toBoolean()))
            }

        } catch (e: Exception) {
            throw Exception("Error: ${e.message}")
        }
        return listOfTasks
    }

    fun saveToFile(tasks: List<Task>, fileName: String) {
        try {
            val file = File(fileName)
            file.writeText("")
            tasks.forEach {
                file.appendText("${it.description},${it.isComplete}\n")
            }
        } catch (e: Exception) {
            throw Exception("Error: ${e.message}")
        }

    }

}