package com.example.components

class Mock private constructor() {
    companion object {
        fun getList(): List<String> {
            return listOf("Call of Duty Warzone", "Dota 2", "Assasins Creed Odyssay", "Path of Exile");
        }
    }
}