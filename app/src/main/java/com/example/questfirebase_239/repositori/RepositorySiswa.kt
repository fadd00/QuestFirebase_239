package com.example.questfirebase_239.repositori

import com.example.questfirebase_239.modeldata.Siswa

interface RepositorySiswa {
    suspend fun getDataSiswa(): List<Siswa>
    suspend fun postDataSiswa(siswa: Siswa)
}
