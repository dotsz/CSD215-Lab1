package lab4.model

/**
 * Represents a task in the to-do list.
 *
 * @property description a description of the task
 * @property status the status of the task
 */
data class Task(val description: String, val status: TaskStatus) // data class is used to store data
