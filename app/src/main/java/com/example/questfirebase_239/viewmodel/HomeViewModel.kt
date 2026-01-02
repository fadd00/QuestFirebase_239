package com.example.questfirebase_239.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questfirebase_239.modeldata.Siswa
import com.example.questfirebase_239.repositori.RepositorySiswa
import java.io.IOException
import kotlinx.coroutines.launch

sealed interface StatusUiSiswa {
    data class Success(val siswa: List<Siswa> = listOf()) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}

class HomeViewModel(private val repositorySiswa: RepositorySiswa) : ViewModel() {
    var statusUiSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set
    init {
        loadSiswa()
    }

    fun loadSiswa() {
        viewModelScope.launch {
            statusUiSiswa = StatusUiSiswa.Loading
            statusUiSiswa =
                    try {
                        StatusUiSiswa.Success(repositorySiswa.getDataSiswa())
                    } catch (e: IOException) {
                        StatusUiSiswa.Error
                    } catch (e: Exception) {
                        StatusUiSiswa.Error
                    }
        }
    }
}
