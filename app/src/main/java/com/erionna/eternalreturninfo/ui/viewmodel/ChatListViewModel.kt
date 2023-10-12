package com.erionna.eternalreturninfo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erionna.eternalreturninfo.R
import com.erionna.eternalreturninfo.model.ERModel
import java.util.concurrent.atomic.AtomicLong

class ChatListViewModel(
    private val idGenerate: AtomicLong
) : ViewModel() {
    private val _list: MutableLiveData<List<ERModel>> = MutableLiveData()
    val list: LiveData<List<ERModel>> get() = _list

    init {
        _list.value = arrayListOf<ERModel>().apply {
            for (i in 0 .. 10) {
                add(
                    ERModel(
                        id = idGenerate.getAndIncrement(),
                        userName = "choco5732",
                        msg = "근태님 버스 감사합니다.. 저도 나딘만 팔까봐요 ㅎㅎ..",
                        profilePicture = R.drawable.ic_jaekie
                    )
                )
            }
        }
    }
}

class ChatListViewModelFactory : ViewModelProvider.Factory {
    private val idGenerate = AtomicLong(1L)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChatListViewModel::class.java)) {
            return ChatListViewModel(idGenerate) as T
        } else {
            throw IllegalArgumentException("not found correct viewModel")
        }
    }
}