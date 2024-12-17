import lab1.logic.TaskLogic
import lab1.model.Task
import lab1.model.TaskStatus
import kotlin.test.Test

class TaskLogicTest {
    @Test
    fun testAddTask() {
        val taskList = listOf(
            Task("Task 1", TaskStatus.Incomplete),
            Task("Task 2", TaskStatus.Incomplete)
        )
        val newTaskList = TaskLogic.addTask(taskList, "Task 3")

        assert(newTaskList.size == 3)
        assert(newTaskList[2].description == "Task 3")
        assert(newTaskList[2].status == TaskStatus.Incomplete)
    }

    @Test
    fun addTask_emptyList() {
        val taskList = emptyList<Task>()
        val newTaskList = TaskLogic.addTask(taskList, "Task 1")

        assert(newTaskList.size == 1)
        assert(newTaskList[0].description == "Task 1")
        assert(newTaskList[0].status == TaskStatus.Incomplete)
    }

    @Test
    fun addTask_givenEmptyDescription() {
        val taskList = listOf(
            Task("Task 1", TaskStatus.Incomplete)
        )
        val newTaskList = TaskLogic.addTask(taskList, "")

        assert(newTaskList.size == 2)
        assert(newTaskList[1].description == "")
        assert(newTaskList[1].status == TaskStatus.Incomplete)
    }

    @Test
    fun removeTask() {
        val taskList = listOf(
            Task("Task 1", TaskStatus.Incomplete),
            Task("Task 2", TaskStatus.Incomplete),
            Task("Task 3", TaskStatus.Incomplete)
        )
        val newTaskList = TaskLogic.removeTask(taskList, 2)

        assert(newTaskList.size == 2)
        assert(newTaskList[0].description == "Task 1")
        assert(newTaskList[1].description == "Task 3")
    }

    @Test
    fun removeTask_invalidIndex() {
        val taskList = listOf(
            Task("Task 1", TaskStatus.Incomplete),
            Task("Task 2", TaskStatus.Incomplete)
        )
        val newTaskList = TaskLogic.removeTask(taskList, 3)
        assert(newTaskList.size == 2)
    }

    @Test
    fun toggleTaskCompletion() {
        val taskList = listOf(
            Task("Task 1", TaskStatus.Incomplete),
            Task("Task 2", TaskStatus.Incomplete)
        )

        val newTaskList = TaskLogic.toggleTaskCompletion(taskList, 2)
        assert(newTaskList.size == 2)
        assert(newTaskList[0].status == TaskStatus.Incomplete)
        assert(newTaskList[1].status == TaskStatus.Complete)
    }

    @Test
    fun toggleTaskCompletion_invalidIndex() {
        val taskList = listOf(
            Task("Task 1", TaskStatus.Incomplete),
            Task("Task 2", TaskStatus.Incomplete)
        )
        val newTaskList = TaskLogic.toggleTaskCompletion(taskList, 3)
        assert(newTaskList.size == 2)
        assert(newTaskList[0].status == TaskStatus.Incomplete)
        assert(newTaskList[1].status == TaskStatus.Incomplete)
    }

}