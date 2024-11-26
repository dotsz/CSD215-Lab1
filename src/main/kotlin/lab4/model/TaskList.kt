package lab4.model


data class TaskList(val tasks: List<Task> = emptyList()) {
    fun addTask (task: Task): TaskList {
        return this.copy(tasks = tasks + task)
    }

    fun removeTask (index: Int): TaskList {
        return this.copy(tasks = tasks.filterIndexed { i, _ -> i != index })
    }

    fun completeTask (index: Int) : TaskList {
        return this.copy(tasks = tasks.mapIndexed { i, task ->
            if (i == index) {
                task.markAsComplete()
            } else {
                task
            }
        })
    }
}


