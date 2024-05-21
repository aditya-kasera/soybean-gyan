package com.example.soybeangyan.ui.read.dataclasses

data class ParentData(val title : String,
                      val image : Int,
                      var childItemList : ArrayList<ChildData>,
                      var isExpandable : Boolean= false) {


    fun getParentName(): String {
        return title
    }
}