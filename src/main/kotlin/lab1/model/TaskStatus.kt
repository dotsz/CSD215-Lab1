package lab1.model

/**
 * Represents the status of a task.
 * A task can be either complete or incomplete.
 */
sealed class TaskStatus{ // Sum type to represent the status of a task
    data object Complete : TaskStatus()
    data object Incomplete : TaskStatus()
}


