class Notepad {
    val archives: MutableList<Archive> = mutableListOf()

    fun startMainMenu() {
        while (true) {
            println("-==Добро пожаловать в Заметки!==-")
            startArchivesMenu(archives)
        }
    }
}


