package com.net0pyr.commands

import com.net0pyr.entity.SpaceMarineInTreeSet
import com.net0pyr.examples.CommandExample
import java.io.File
import java.time.format.DateTimeFormatter

/**
 * Класс команды info
 * @author net0pyr
 */
class Info : CommandExample() {
    /**Поле описания команды*/
    override val commandDescription = "info: Выводит инфорамцию о коллекции"

    /** Метод исполнения команды
     * @param commandArgument аргумент команды
     */
    override fun <T> commandExecution(commandArgument: T) {
        if (commandArgument != null && commandArgument != "") {
            println("\u001B[31mКоманда info не имеет таких аргуметов.\u001B[0m\nВоспользуйтесь командой help, чтобы получить дополнительную информацию")
        } else {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val formattedDateTime = SpaceMarineInTreeSet.creationTime.format(formatter)
            println("Тип коллекции: TreeSet\nДата инициализации: $formattedDateTime\nКоличество элементов: ${SpaceMarineInTreeSet.spaceMarines.size}")
        }
    }
}