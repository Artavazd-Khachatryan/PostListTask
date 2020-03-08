package com.task.postlisttask.view.activity.mainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task.postlisttask.view.activity.*
import com.task.postlisttask.view.models.Command

class MainViewModel: ViewModel(){

     val commandLiveData = MutableLiveData<Command>()
     val allListSelected = MutableLiveData<Int>()
         .apply { value = All_List_Checked_Image}

     val starsListSelected = MutableLiveData<Int>()
        .apply { value = Stars_List_UnChecked_Image}

    fun allListChecked(){
            allListSelected.value = All_List_Checked_Image
            starsListSelected.value = Stars_List_UnChecked_Image
            commandLiveData.value = Command(SHOW_ALL_LIST_FRAGMENT_COMMAND)

    }

    fun starsChecked(){
            starsListSelected.value = Stars_List_Checked_Image
            allListSelected.value = All_List_UnChecked_Image
            commandLiveData.value = Command(SHOW_CHECKED_LIST_FRAGMENT_COMMAND)
    }
}