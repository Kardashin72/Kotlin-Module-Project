class Screen<T> (
    val items: MutableList<T>,
    val itemType: ItemTypes,
    var isMainMenu: Boolean,
    val getItemName: (T) -> String
) {
    fun menu() {
        while (true) {
            println("--==ЗАМЕТКИ==--")
            println("Список ${itemType.type}.")
            if (itemType.name == "ARCHIVE") println("0. Создать ${itemType.type.dropLast(2)}.")
            else if (itemType.name == "NOTE") println("0. Создать ${itemType.type.dropLast(2)}ку")
            for (i in items.indices) {
                println("${i+1}. ${getItemName(items[i])}.")
            }
            if (isMainMenu) {
                println("${items.size+1}. Выход.")
            } else {
                println("${items.size+1}. Назад.")
            }
            selectItem(items, createItem = {
                val name = correctStringInput()
                Archive(name)
            })

        }
    }


}