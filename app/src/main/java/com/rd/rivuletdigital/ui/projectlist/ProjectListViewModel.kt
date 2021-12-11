package com.rd.rivuletdigital.ui.projectlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rd.rivuletdigital.model.ProjectListModel
import com.rd.rivuletdigital.repository.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectListViewModel @Inject constructor(var retrofitRepository: RetrofitRepository):ViewModel(){

    lateinit var projectdata: MutableLiveData<ProjectListModel>
    init {
        projectdata = MutableLiveData<ProjectListModel>()
    }

    fun getprojectList(token :String){
        retrofitRepository.getprojectlist(token,projectdata, emptyArray())
    }


}