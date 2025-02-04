class SelectResult() {
    
}

fun <T : Item> selectItem(
    items: MutableList<T>,
    createItem: () -> T,
): T? {
    var input = correctIntInput(items.size)
    when (input) {
        0 -> return createItem()
        items.size + 1 -> return null
        else -> return items[input - 1]
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




