class Menu<T>(
    private val itemType: ItemTypes,
    private val items: MutableList<T>,
    private val getItemTitle: (T) -> String,
    private val createItem: () -> T,
    private val isExit: Boolean
) {
    fun startMenu(): T? {
        while (true) {
            if (itemType.type == "заметка") println("Меню ${itemType.type.dropLast(2)}ок:")
            if (itemType.type == "архив") println("Меню ${itemType.type}ов:")

            if (items.isEmpty()) {
                println("Список пуст. Выберете пункт меню \"0. Создать.\" для начала работы.\n\n")
            }

            println("0. Создать.")

            for (index in items.indices) {
                println("${index + 1}. ${getItemTitle(items[index])}")
            }

            if (isExit) println("${items.size + 1}. Выход.")
            else println("${items.size + 1}. Назад.")

            val input = correctIntInput(items.size + 1)
            when (input) {
                null -> {
                    println("Ошибка! Необходимо ввести число от 0 до ${items.size + 1}.")
                    continue
                }

                0 -> {
                    val newItem = createItem()
                    items.add(newItem)
                    return newItem
                }
                items.size+1 -> return null
                else -> return items[input - 1]
            }
        }
    }
}