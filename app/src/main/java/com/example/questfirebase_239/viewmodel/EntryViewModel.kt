package com.example.questfirebase_239.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questfirebase_239.modeldata.DetailSiswa
import com.example.questfirebase_239.modeldata.UIStateSiswa
import com.example.questfirebase_239.modeldata.toDataSiswa
import com.example.questfirebase_239.repositori.RepositorySiswa

class EntryViewModel(private val repositorySiswa: RepositorySiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    // fungsi buat validasi input
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) { nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank() }
    }

    // fungsi buat nangani kalo ada perubahan text input
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
                UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    // fungsi buat nyimpen data yang di entry
    suspend fun addSiswa() {
        if (validasiInput()) {
            repositorySiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
        }
    }
}
