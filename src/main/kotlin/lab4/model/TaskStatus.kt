package lab4.model

/**
 * Represents the status of a task.
 *
 */
sealed class TaskStatus{
    object Complete : TaskStatus()
    object Incomplete : TaskStatus()
}

// used sealed class because it is a good way to represent a fixed number of possible states

