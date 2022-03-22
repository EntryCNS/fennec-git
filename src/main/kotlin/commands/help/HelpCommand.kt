package commands.help

import commands.*

class HelpCommand: FennecCommand() {
    override fun getName(): String = "help"

    override fun getDescription(): String = "도움말을 출력합니다"

    override fun getRequiredArguments(): List<FennecArgument> = listOf(
        FennecArgument("명령어 이름", listOf(ArgumentType.STRING), true)
    )

    override fun run(arguments: List<String>) {
        when(arguments.size) {
            1 -> {
                val query = arguments[0]
                val command = CommandMapper.map[query]
                if(command != null) {
                    CommandHelper.printCommandHelp(command)
                }else println("명령어 '${query}'을/를 찾을 수 없습니다")
            }
            else -> CommandHelper.printHelp()
        }
    }

}