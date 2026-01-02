package com.example.questfirebase_239.repositori

interface ContainerApp {
    val repositorySiswa: RepositorySiswa
}

class DefaultContainerApp : ContainerApp {
    override val repositorySiswa: RepositorySiswa by lazy { FirebaseRepositorySiswa() }
}
