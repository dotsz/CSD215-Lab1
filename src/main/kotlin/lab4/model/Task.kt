package lab4.model

data class Task(val description: String, val isComplete: Boolean = false) {
    fun markAsComplete(): Task {
        return this.copy(isComplete = true)
    }
    fun markAsIncomplete(): Task {
        return this.copy(isComplete = false)
    }
    override fun toString(): String {
        return "${if (isComplete) "[✔]" else "[ ]"} $description"
    }
}


