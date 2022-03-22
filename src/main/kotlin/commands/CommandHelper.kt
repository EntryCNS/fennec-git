package commands

class CommandHelper {
    companion object {
        fun printCommandHelp(cmd: FennecCommand) {
            val args = cmd.getRequiredArguments().map { "<${it.name}${if(it.optional) "?" else ""}>" }.joinToString(" ")
            println("fennec ${cmd.getName()} ${args}")
            println("  * ${cmd.getDescription()}")
            println("  * Required args:")
            cmd.getRequiredArguments().forEach { arg ->
                println("    * '${arg.name}'(${arg.allowType.map { it.description }.joinToString(" 또는 ")}${if(arg.optional) "?" else ""})")
            }

            println()
        }

        fun printHelp() {
            CommandMapper.map.forEach { pair ->
                printCommandHelp(pair.value)
            }
        }
    }
}