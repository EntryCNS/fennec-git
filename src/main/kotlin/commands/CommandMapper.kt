package commands

import commands.help.HelpCommand
import commands.upload.UploadCommand
import kotlin.system.exitProcess

class CommandMapper {
    companion object {
        val map: Map<String, FennecCommand> = mapOf(
            "upload" to UploadCommand(),
            "help" to HelpCommand()
        )

        fun execute(args: Array<String>) {
            if(args.size == 0) {
                CommandHelper.printHelp()
                exitProcess(1)
            }

            try {
                val command = map.get(args[0])!!
                val args = args.slice(1 until args.size)

                ArgumentValidator(command, args).validate()
                command.run(args)
            }catch (ex: Exception) {
                System.err.println("No such command '${args[0]}' Reference this:")
                CommandHelper.printHelp()
            }
        }

    }
}