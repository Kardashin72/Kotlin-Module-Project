abstract class Item (open val title: String){}

data class Note (override val title: String, val text: String) : Item(title) {}

data class Archive(override val title: String, val notes: MutableList<Note> = mutableListOf()) : Item(title) {}

data class MenuItem (val title: String, val action: () -> Unit) {}


enum class ItemTypes (val type: String) {
    ARCHIVE("архив"),
    NOTE("заметка")
}
