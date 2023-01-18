package com.example.killreal.ui

import com.example.killreal.data.dataClassesResponse.TeamsListItem

interface OnNavigateCallback {
    fun navigate(data: TeamsListItem)
}