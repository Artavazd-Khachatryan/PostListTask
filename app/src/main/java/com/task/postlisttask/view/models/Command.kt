package com.task.postlisttask.view.models

data class Command(val command: Int,
                   val data: Any? = null,
                   var isCompleted: Boolean = false)