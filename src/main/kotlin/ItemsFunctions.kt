fun createArchive(): Archive {
    println("Введите название архива:")
    val title: String = correctStringInput()
    return Archive(title)
}

fun startArchivesMenu(archives: MutableList<Archive>) {
    val archiveMenu: Menu<Archive> = Menu(
        ItemTypes.ARCHIVE,
        archives,
        getItemTitle = { it.title },
        createItem = ::createArchive,
        isExit = true
    )
    while (true) {
        val result = archiveMenu.startMenu()
        if (result is Archive) {
            if (result in archives) {
                startNotesMenu(result)
                break
            } else {
                archives.add(result)
                println("Архив \"${result.title}\" добавлен в ваш список архивов.")
                continue
            }
        }
    }
}

fun createNote(): Note {
    println("Введите название заметки:")
    val title: String = correctStringInput()
    println("введите текст заметки:")
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
    val result = noteMenu.startMenu()
    if (result is Note) {
        if (result in archive.notes) {
            startNoteMenu(result)
        } else {
            archive.notes.add(result)
            println("Заметка \"${result.title}\" успешно добавлена в архив \"${archive.title}\".")
        }
    }
}

fun startNoteMenu(note: Note) {
    println("Заметка \"${note.title}\"")
    println("0. Открыть заметку. \n1. Назад.")
    val input = correctIntInput(1)
    when (input) {
        0 -> println("Заметка \"${note.title}\" \n${note.text}")
        1 -> return
    }
}

fun <T> deleteItem(
    items: MutableList<T>,
    itemType: ItemTypes,
    name: String,
    getItemName: (T) -> String,
) {
    val isDeleted = items.removeIf { getItemName(it) == name }
    if (isDeleted) {
        println("Удалили ${itemType.name} \"$name\"!")
    } else {
        when (itemType) {
            ItemTypes.ARCHIVE -> println("${itemType.name.replaceFirstChar { it.uppercase() }} \"$name\" удалён.")
            ItemTypes.NOTE -> println(
                "${
                    itemType.name.replaceFirstChar { it.uppercase() }.dropLast(1) + 'а'
                } \"$name\" удалена."
            )
        }
        println("$ с таким именем не существует")
    }
}




