class Notepad {
    val archives: MutableList<Archive> = mutableListOf()

    fun mainMenu() {
        while (true) {
            println("-==Добро пожаловать в Заметки!==-")
            println("Выберите пункт меню: ")
            println("0. Создать архив. \n1. Просмотр архивов. \n2. Выход.")
            val input = correctIntInput(2)
            when (input) {
                0 -> {
                    println("Введите название архива: ")
                    val name = correctStringInput()
                    val newArchive: Archive = createItem{ Archive(name) }
                    archives.add(newArchive)
                    println("Архив \"$name\" создан. Нажмите Enter для продолжения.")
                    readLine()
                }
                1 -> {
                    println("Выберите архив для просмотра заметок.")
                    val archive = selectItem(archives, ItemTypes.ARCHIVE, false) { it.title }
                    if (archive != null) {
                        selectItem(archive.notes, ItemTypes.NOTE, false) {it.title}
                        }
                }
                2 -> return
            }
        }
    }
}

