package com.example.killreal.ui

import com.example.killreal.data.teams.TeamsListItem

interface OnNavigateCallback {
    fun navigate(data: TeamsListItem)
}