package commands.help

import commands.CommandHelper
import commands.FennecArgument
import commands.FennecCommand

class HelpCommand: FennecCommand() {
    override fun getName(): String = "help"

    override fun getDescription(): String = "도움말을 출력합니다"

    override fun getRequiredArguments(): List<FennecArgument> = listOf()

    override fun run(arguments: List<String>) {
        CommandHelper.printHelp()
    }

}