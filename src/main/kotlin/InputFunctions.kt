fun correctStringInput(): String {
    var correctInput: String
    while (true) {
        correctInput = readlnOrNull().orEmpty().trim()
        if (correctInput == "") {
            println("Ошибка! Вы ввели пустую строку. Повторите ввод:")
            continue
        } else break
    }
    return correctInput
}

fun correctIntInput(max: Int): Int {
    var correctInput: Int?
    while (true) {
        correctInput = readlnOrNull()?.toIntOrNull()
        if (correctInput == null) {
            println("Ошибка! Необходимо ввести число от 0 до $max. Повторите ввод:")
            continue
        } else if (correctInput !in 0..max) {
            println("Ошибка! Такого пункта меню не существует. Необходимо ввести число от 0 до $max. Повторите ввод:")
            continue
        }
        return correctInput
    }
}