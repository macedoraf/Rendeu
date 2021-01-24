package br.com.rafaelmacedo

class GetData() {
    suspend fun execute(): FirstScreenData {
        return FirstScreenData()
    }
}