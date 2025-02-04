import kotlin.system.exitProcess

class Menu<T>(
    private val itemType: ItemTypes,
    private val items: MutableList<T>,
    private val getItemTitle: (T) -> String,
    private val createItem: () -> T,
    private val isExit: Boolean,
) {
    fun startMenu(): T? {
        while (true) {
            if (items.isEmpty()) {
                println("Список пуст. Выберите пункт меню \"0. Создать.\" для начала работы.")
            }
            println("0. Создать.")
            for (index in items.indices) {
                println("${index + 1}. ${getItemTitle(items[index])}")
            }
            if (isExit) println("${items.size + 1}. Выход.") else println("${items.size + 1}. Назад.")
            val input = correctIntInput(items.size + 1)
            when (input) {
                0 -> {
                    val newItem = createItem()
                    return newItem
                }
                items.size + 1 -> {
                    if (!isExit) return null
                    else {
                        println("Работа программы завершена.")
                        exitProcess(0)
                    }
                }
                else -> return items[input - 1]
            }
        }
    }
}