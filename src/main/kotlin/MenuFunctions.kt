fun createArchive(): Archive {
    println("Введите название архива:")
    val title: String = correctStringInput()
    return Archive(title)
}

fun startArchivesMenu(archives: MutableList<Archive>) {
    val archiveMenu = Menu(
        ItemTypes.ARCHIVE,
        archives,
        getItemTitle = { it.title },
        createItem = ::createArchive,
        isExit = true
    )
    while (true) {
        println("=== Главное меню архивов ===")
        val result = archiveMenu.startMenu()
        if (result == null) {
            return
        } else if (result is Archive) {
            if (result !in archives) {
                archives.add(result)
                println("Архив \"${result.title}\" добавлен в ваш список архивов.")
            } else {
                startNotesMenu(result)
            }
        }
    }
}

fun createNote(): Note {
    println("Введите название заметки:")
    val title: String = correctStringInput()
    println("Введите текст заметки:")
    val text: String = correctStringInput()
    return Note(title, text)
}

fun startNotesMenu(archive: Archive) {
    val noteMenu = Menu(
        ItemTypes.NOTE,
        archive.notes,
        getItemTitle = { it.title },
        createItem = ::createNote,
        isExit = false
    )
    while (true) {
        println("\n=== Меню заметок архива \"${archive.title}\" ===")
        val result = noteMenu.startMenu()
        if (result == null) {
            return
        } else if (result is Note) {
            if (result in archive.notes) {
                // Переход в меню выбранной заметки
                startNoteMenu(result)
            } else {
                // Добавление новой заметки
                archive.notes.add(result)
                println("Заметка \"${result.title}\" успешно добавлена в архив \"${archive.title}\".")
            }
        }
    }
}

fun startNoteMenu(note: Note) {
    println("\n=== Заметка \"${note.title}\" ===")
    println("0. Открыть заметку.\n1. Назад.")
    val input = correctIntInput(1)
    when (input) {
        0 -> {
            println("\"${note.title}\":\n${note.text}")
            println("Нажмите Enter для возврата в предыдущее меню.")
            readLine()
        }
        1 -> return
    }
}