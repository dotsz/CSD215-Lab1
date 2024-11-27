package lab4.model

sealed class TaskStatus{
    object Complete : TaskStatus()
    object Incomplete : TaskStatus()
}

