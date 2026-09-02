package com.example.kanban.model

import android.os.Parcelable

@Parcelize
class Task(string: String, string1: String) {
    data class task(
        val id: String,
        val description: String
    ): Parcelable