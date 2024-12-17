import lab1.data.FileManager
import lab1.model.Task
import lab1.model.TaskStatus
import java.io.File

import kotlin.test.Test
import kotlin.test.assertEquals


class FileManagerTest {

    @Test
    fun testLoadTasks() {
        val tempFile = File.createTempFile("tempFile", ".txt")
        tempFile.writeText("✓ Task 1\nTask 2")

        val fileManager = FileManager(tempFile.absolutePath)
        val tasks = fileManager.loadTasks()

        assert(tasks.size == 2)
        assert(tasks[0].description == "Task 1")
        assert(tasks[0].status == TaskStatus.Complete)
        assert(tasks[1].description == "Task 2")
        assert(tasks[1].status == TaskStatus.Incomplete)
    }

    @Test
    fun testLoadTasks_emptyFile() {
        val tempFile = File.createTempFile("tempFile", ".txt")
        tempFile.writeText("")

        val fileManager = FileManager(tempFile.absolutePath)
        val tasks = fileManager.loadTasks()

        assert(tasks.isEmpty())
    }


    @Test
    fun testSaveTasks() {
        val tempFile = File.createTempFile("tempFile", ".txt")
        val fileManager = FileManager(tempFile.absolutePath)

        val tasks = listOf(
            Task("Task 1", TaskStatus.Complete),
            Task("Task 2", TaskStatus.Incomplete)
        )

        fileManager.saveTasks(tasks)

        val savedTasks = tempFile.readLines()
        assert(savedTasks.size == 2)
        assertEquals("✓ Task 1", savedTasks[0])
        assertEquals("Task 2", savedTasks[1])
    }
}
