abstract class Item (open val title: String){}

data class Note (override val title: String, val text: String) : Item(title) {}

data class Archive(override val title: String, val notes: MutableList<Note> = mutableListOf()) : Item(title) {}

enum class ItemTypes (val type: String) {
    ARCHIVE("архивов"),
    NOTE("заметок")
}
